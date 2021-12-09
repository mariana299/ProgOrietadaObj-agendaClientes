package com.wb.modelo;

public class Produto {
	private String codigo;
	private String nome;
	private Double preco;
	private String marca;
	private String categoria;
	private String genero;
	public Produto(String codigo, String nome, Double preco, String marca, String categoria, String genero) {
		this.setCodigo(codigo);
		this.nome = nome;
		this.setPreco(preco);
		this.setMarca(marca);
		this.setCategoria(categoria);
		this.genero = genero;
	}
	
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
}
