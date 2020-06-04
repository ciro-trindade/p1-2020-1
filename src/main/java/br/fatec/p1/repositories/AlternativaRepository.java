package br.fatec.p1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.fatec.p1.model.Alternativa;

@Repository
public interface AlternativaRepository extends JpaRepository<Alternativa, Long> {

}
