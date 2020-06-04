package br.fatec.p1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "tb_alternativa")
@Entity
public class Alternativa extends AbstractEntity {
	private static final long serialVersionUID = 1L;
		
	@Column(name = "ds_texto", length = 500)
	private String texto;
	@Column(name = "ic_correta")
	private boolean correta;
	
	public Alternativa() {
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public boolean isCorreta() {
		return correta;
	}

	public void setCorreta(boolean correta) {
		this.correta = correta;
	}		

}
