package com.wb.modelo;


public class ClienteQtddConsumo {
	private Cliente cliente;
	private Double qtddConsumo;
	
	public ClienteQtddConsumo(Cliente cliente, Double qtddConsumo) {
		this.cliente = cliente;
		this.qtddConsumo = qtddConsumo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getQtddConsumo() {
		return qtddConsumo;
	}

	public void setQtddConsumo(Double qtddConsumo) {
		this.qtddConsumo = qtddConsumo;
	}

	
}