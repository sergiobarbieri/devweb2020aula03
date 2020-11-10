package br.com.drummond.aula.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "especialidade")
public class Especialidade {

	@Id
	@Column(name = "id_espec")
	private Integer idFormaPagto;
	private String especialidade;

	public Integer getIdFormaPagto() {
		return idFormaPagto;
	}

	public void setIdFormaPagto(Integer idFormaPagto) {
		this.idFormaPagto = idFormaPagto;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

}
