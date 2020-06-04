package br.fatec.p1.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "tb_questao")
@Entity
public class Questao extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "ds_enunciado", length = 1000)
	private String enunciado;
	@Column(name = "nr_pontos")
	private Integer pontos;
	@Column(name = "ic_multipla_escolha")
	private boolean multiplaEscolha;
	
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_questao_id")
	private List<Alternativa> alternativas;

	public Questao() {
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public Integer getPontos() {
		return pontos;
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

	public boolean isMultiplaEscolha() {
		return multiplaEscolha;
	}

	public void setMultiplaEscolha(boolean multiplaEscolha) {
		this.multiplaEscolha = multiplaEscolha;
	}

	public List<Alternativa> getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(List<Alternativa> alternativas) {
		this.alternativas = alternativas;
	}
		
}
