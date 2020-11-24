package br.com.drummond.aula.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_pagamento")
public class TipoPagamento {

	@Id
	@Column(name = "id_tp_pgto")
	private Integer idTpPgto;
	@Column(name = "tipo_pgto")
	private String tipoPgto;

	public Integer getIdTpPgto() {
		return idTpPgto;
	}

	public void setIdTpPgto(Integer idTpPgto) {
		this.idTpPgto = idTpPgto;
	}

	public String getTipoPgto() {
		return tipoPgto;
	}

	public void setTipoPgto(String tipoPgto) {
		this.tipoPgto = tipoPgto;
	}

}
