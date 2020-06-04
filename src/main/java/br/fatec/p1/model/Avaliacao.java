package br.fatec.p1.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name = "tb_avaliacao")
@Entity
public class Avaliacao extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "ds_titulo", length = 100)
	private String titulo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_inicio")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss")
	private Date inicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_fim")	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss")
	private Date fim;
	
	@ManyToMany
	private List<Questao> questoes;

	public Avaliacao() {
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public List<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}
	
	
}
