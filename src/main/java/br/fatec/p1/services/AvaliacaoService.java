package br.fatec.p1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.p1.model.Avaliacao;
import br.fatec.p1.repositories.AvaliacaoRepository;

@Service
public class AvaliacaoService implements ServiceInterface<Avaliacao> {

	@Autowired
	private AvaliacaoRepository repo;
	
	@Override
	public Avaliacao create(Avaliacao obj) {
		repo.save(obj);
		return obj;
	}

	@Override
	public Avaliacao findById(Long id) {
		Optional<Avaliacao> _aval = repo.findById(id);
		return _aval.orElse(null);
	}

	@Override
	public List<Avaliacao> findAll() {
		return repo.findAll();
	}

	@Override
	public boolean update(Avaliacao obj) {
		Optional<Avaliacao> _aval = repo.findById(obj.getId());
		if (_aval.isPresent()) {
			repo.save(obj);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		Optional<Avaliacao> _aval = repo.findById(id);
		if (_aval.isPresent()) {
			repo.delete(_aval.get());
			return true;
		}
		return false;
	}

}
