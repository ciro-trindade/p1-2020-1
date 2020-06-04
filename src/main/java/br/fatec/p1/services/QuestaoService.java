package br.fatec.p1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.p1.model.Questao;
import br.fatec.p1.repositories.QuestaoRepository;

@Service
public class QuestaoService implements ServiceInterface<Questao> {

	@Autowired
	private QuestaoRepository repo;
	
	@Override
	public Questao create(Questao obj) {
		repo.save(obj);
		return obj;
	}

	@Override
	public Questao findById(Long id) {
		Optional<Questao> _questao = repo.findById(id);
		return _questao.orElse(null);
	}

	@Override
	public List<Questao> findAll() {
		return repo.findAll();
	}
	
	@Override
	public boolean update(Questao obj) {
		Optional<Questao> _questao = repo.findById(obj.getId());
		if (_questao.isPresent()) {
			repo.save(obj);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		Optional<Questao> _questao = repo.findById(id);
		if (_questao.isPresent()) {
			repo.delete(_questao.get());
			return true;
		}
		return false;
	}

}
