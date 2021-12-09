package com.wb.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Cliente {

	public String nome;
	public String email;
	private CPF cpf;
	private RG rg;
	private LocalDate dataCadastro;
	private List<Produto> produtosConsumidos;
	private List<Servico> servicosConsumidos;
	private LocalDate dataNascimento;
	private String genero;
	private Telefone telefone;
	public Cliente(String nome, String email, CPF cpf, RG rg, String genero, LocalDate dataNascimento, Telefone telefone) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.rg = rg;
		this.setTelefone(telefone);
		this.dataCadastro = LocalDate.now();
		this.produtosConsumidos = new ArrayList<>();
		this.servicosConsumidos = new ArrayList<>();
		this.genero = genero;
		this.setDataNascimento(dataNascimento);
	}
	
	
	public CPF getCpf() {
		return cpf;
	}
	public void setCpf(CPF cpf) {
		this.cpf = cpf;
	}
	
	
	public RG getRg() {
		return rg;
	}
	public void setRg(RG rg) {
		this.rg = rg;
	}
	
	
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	
	
	public List<Produto> getProdutosConsumidos() {
		return produtosConsumidos;
	}
	public void includeProdutoConsumido(Produto produto) {
		this.produtosConsumidos.add(produto);
	}
	
	
	public List<Servico> getServicosConsumidos() {
		return servicosConsumidos;
	}
	public void includeServicoConsumido(Servico servico) {
		this.servicosConsumidos.add(servico);
	}
	
	
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public Telefone getTelefone() {
		return telefone;
	}


	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
}