package com.wb.modelo;

import java.time.LocalDate;
import java.util.List;

public class Transacao {
   
    private String codigo;
    private Cliente comprador;
    private Double valorTotal;
    private Integer quantidadeProdutos;
    private LocalDate dataCompra;
    private List<Produto> produtosComprados;
    private List<Servico> servicosComprados;
    private Integer quantidadeServicos;

    
    public Transacao(String codigo, Cliente comprador, Double valorTotal,  Integer quantidadeProdutos, List<Produto> produtosComprados) {
		this.codigo = codigo;
		this.comprador = comprador;
		this.valorTotal = valorTotal;
		this.quantidadeProdutos = quantidadeProdutos;
		this.dataCompra = LocalDate.now();
		this.produtosComprados = produtosComprados;
	}
    
    public Transacao(String codigo, Cliente comprador, Double valorTotal,  Integer quantidadeServiços, List<Servico> servicosComprados, LocalDate dataCompra) {
		this.codigo = codigo;
		this.comprador = comprador;
		this.valorTotal = valorTotal;
		this.quantidadeServicos = quantidadeServiços;
		this.dataCompra = LocalDate.now();
		this.servicosComprados = servicosComprados;
	}
    

    public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	public Cliente getComprador() {
		return comprador;
	}
	public void setComprador(Cliente comprador) {
		this.comprador = comprador;
	}
	
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
	public Integer getQuantidadeProdutos() {
		return quantidadeProdutos;
	}
	public void setQuantidadeProdutos(Integer quantidadeProdutos) {
		this.quantidadeProdutos = quantidadeProdutos;
	}

	
	public LocalDate getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
	}
	
	
	public List<Produto> getProdutosComprados() {
		return produtosComprados;
	}
	public void setProdutosComprados(List<Produto> produtosComprados) {
		this.produtosComprados = produtosComprados;
	}


	public List<Servico> getServicosComprados() {
		return servicosComprados;
	}


	public void setServicosComprados(List<Servico> servicosComprados) {
		this.servicosComprados = servicosComprados;
	}


	public Integer getQuantidadeServicos() {
		return quantidadeServicos;
	}


	public void setQuantidadeServicos(Integer quantidadeServicos) {
		this.quantidadeServicos = quantidadeServicos;
	}
	

}

  
