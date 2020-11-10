package br.com.drummond.aula.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "forma_pagamento")
public class FormaPagamento {

	@Id
	@Column(name = "id_forma_pagto")
	private Integer idFormaPagto;
	@Column(name = "forma_pagto")
	private String formaPagto;

	public Integer getIdFormaPagto() {
		return idFormaPagto;
	}

	public void setIdFormaPagto(Integer idFormaPagto) {
		this.idFormaPagto = idFormaPagto;
	}

	public String getFormaPagto() {
		return formaPagto;
	}

	public void setFormaPagto(String formaPagto) {
		this.formaPagto = formaPagto;
	}

	public Integer getQtdParcelas() {
		return qtdParcelas;
	}

	public void setQtdParcelas(Integer qtdParcelas) {
		this.qtdParcelas = qtdParcelas;
	}

	@Column(name = "qtd_parcelas")
	private Integer qtdParcelas;

}
