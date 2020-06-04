package br.fatec.p1.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fatec.p1.model.Questao;
import br.fatec.p1.services.QuestaoService;

@RestController
@RequestMapping(value = "/questoes")
public class QuestaoResource implements ResourceInterface<Questao> {

	@Autowired
	private QuestaoService service;
	
	@Override
	@GetMapping
	public ResponseEntity<List<Questao>> get() {		
		return ResponseEntity.ok(service.findAll());
	}

	@Override
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {
		Questao _questao = service.findById(id);
		if (_questao != null) {
			return ResponseEntity.ok(_questao);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Override
	@PostMapping
	public ResponseEntity<Questao> post(@RequestBody Questao obj) {		
		return ResponseEntity.ok(service.create(obj));
	}

	@Override
	@PutMapping
	public ResponseEntity<?> put(@RequestBody Questao obj) {
		if (service.update(obj)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Override
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if (service.delete(id)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

}
