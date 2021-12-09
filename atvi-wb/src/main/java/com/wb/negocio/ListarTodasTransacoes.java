package com.wb.negocio;

import java.util.List;

import com.wb.modelo.Produto;
import com.wb.modelo.Servico;
import com.wb.modelo.Transacao;

public class ListarTodasTransacoes extends Listagem {
	private List<Transacao> transacoes;

	public ListarTodasTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}

	@Override
	public void listar() {
		System.out.println("\nLista de todas as Transações:\n");
		for (Transacao transacao : transacoes) {
			System.out.println("\nTransação Codigo: " + transacao.getCodigo());
			System.out.println("Data da Transação: " + transacao.getDataCompra());
			System.out.println("Nome do Cliente: " + transacao.getComprador().nome);
			System.out.println("CPF do Cliente: " + transacao.getComprador().getCpf().getValor());
			System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
			if (transacao.getProdutosComprados()!=null) {
				System.out.println("Lista de Produtos Transação ");
				for (Produto produto : transacao.getProdutosComprados()) {
					System.out.println("+ R$:" + produto.getPreco() + " - " + produto.getNome() + " (" + produto.getMarca() + ")");
				}
				System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
				System.out.println("= R$:" + transacao.getValorTotal() + " - Valor total");
				System.out.println("Quantidade de Item(ns): " + transacao.getQuantidadeProdutos());
			}
			if (transacao.getServicosComprados()!=null) {
				System.out.println("Lista de Serviços Transação ");
				for (Servico servico : transacao.getServicosComprados()) {
					System.out.println("+ R$:" + servico.getPreco() + " - " + servico.getNome());
					}
				System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
				System.out.println("= R$:" + transacao.getValorTotal() + " - Valor total");
				System.out.println("Quantidade de Item(ns): " + transacao.getQuantidadeServicos
						());
			}
			System.out.println("--------------------------------------");
			
		}
	}
}
