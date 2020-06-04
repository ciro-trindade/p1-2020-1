package br.fatec.p1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.p1.model.Alternativa;
import br.fatec.p1.repositories.AlternativaRepository;

@Service
public class AlternativaService implements ServiceInterface<Alternativa> {

	@Autowired
	private AlternativaRepository repo;
	
	@Override
	public Alternativa create(Alternativa obj) {
		repo.save(obj);
		return obj;
	}

	@Override
	public Alternativa findById(Long id) {
		Optional<Alternativa> _alt = repo.findById(id);
		return _alt.orElse(null);
	}

	@Override
	public List<Alternativa> findAll() {
		return repo.findAll();
	}

	@Override
	public boolean update(Alternativa obj) {
		Optional<Alternativa> _alt = repo.findById(obj.getId());
		if (_alt.isPresent()) {
			repo.save(obj);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		Optional<Alternativa> _alt = repo.findById(id);
		if (_alt.isPresent()) {
			repo.delete(_alt.get());
			return true;
		}
		return false;
	}

}
