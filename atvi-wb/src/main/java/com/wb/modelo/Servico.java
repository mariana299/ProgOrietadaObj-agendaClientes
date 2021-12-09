package com.wb.modelo;

public class Servico {
	private String codigo;
	private String nome;
	private Double preco;
	private String categoria;
	private String genero;
	public Servico(String codigo, String nome, Double preco, String categoria, String genero) {
		this.setCodigo(codigo);
		this.setNome(nome);
		this.setPreco(preco);
		this.setCategoria(categoria);
		this.setGenero(genero);
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
}