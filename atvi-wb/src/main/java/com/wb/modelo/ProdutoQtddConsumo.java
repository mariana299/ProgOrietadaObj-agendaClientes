package com.wb.modelo;


public class ProdutoQtddConsumo {
	private Produto produto;
	private Integer qtddConsumo;
	
	public ProdutoQtddConsumo(Produto produto, Integer qtddConsumo) {
		this.produto = produto;
		this.qtddConsumo = qtddConsumo;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQtddConsumo() {
		return qtddConsumo;
	}

	public void setQtddConsumo(Integer qtddConsumo) {
		this.qtddConsumo = qtddConsumo;
	}

	
}