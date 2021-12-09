package com.wb.negocio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Produto;
import com.wb.modelo.ProdutoQtddConsumo;
import com.wb.modelo.Transacao;

public class ListarProdutosMaisConsumidos extends Listagem {
	private List<Transacao> transacoes;
	private List<Produto> produtos;

	public ListarProdutosMaisConsumidos(List<Transacao> transacoes, List<Produto> produtos) {
		this.produtos = produtos;
		this.transacoes = transacoes;
	}

	@Override
	public void listar() {
		
		
		List<Produto> listaoProdutosConsumidos = new ArrayList<>();
		for (Transacao transacao : transacoes) {
			if (transacao.getProdutosComprados() != null) {
				listaoProdutosConsumidos.addAll(transacao.getProdutosComprados());
			}
		}
		
		List<ProdutoQtddConsumo> listaoProdutosQtddConsumida = new ArrayList<>();
		for (Produto produto : produtos) {
			int ocorrencias = Collections.frequency(listaoProdutosConsumidos, produto);
			ProdutoQtddConsumo produtoQtddConsumo = new ProdutoQtddConsumo(produto, ocorrencias);
			listaoProdutosQtddConsumida.add(produtoQtddConsumo);
		}

		listaoProdutosQtddConsumida.sort(Comparator.comparing(ProdutoQtddConsumo::getQtddConsumo).reversed());

		System.out.println("\nPor favor, informe a quatidade de produtos que deseja listar:\n");
		Entrada entrada = new Entrada();
		int quantidadeProdutos = entrada.receberNumeroInteiro();
		int count = 0;
		System.out.println("\nLista dos Produtos Mais Consumidos:\n");
		for (ProdutoQtddConsumo item : listaoProdutosQtddConsumida) {
			if (count < quantidadeProdutos)
			{
				System.out.println("\nCódigo: " + item.getProduto().getCodigo());
				System.out.println("Nome: " + item.getProduto().getNome());
				System.out.println("Preço: R$" + item.getProduto().getPreco());
				System.out.println("Marca: " + item.getProduto().getMarca());
				System.out.println("Quantidade de itens: " + item.getQtddConsumo());
				System.out.println("Total consumido em valorR$:" + item.getQtddConsumo()*item.getProduto().getPreco());
				System.out.println("--------------------------------------");
				count++;
			}
		}
	}
}