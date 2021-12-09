package com.wb.modelo;


public class ServicoQtddConsumo {
	private Servico servico;
	private Integer qtddConsumo;
	
	public ServicoQtddConsumo(Servico servico, Integer qtddConsumo) {
		this.servico = servico;
		this.qtddConsumo = qtddConsumo;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Integer getQtddConsumo() {
		return qtddConsumo;
	}

	public void setQtddConsumo(Integer qtddConsumo) {
		this.qtddConsumo = qtddConsumo;
	}

	
}