package com.wb.negocio;

import java.util.List;

import com.wb.modelo.Produto;

public class ListarTodosProdutos extends Listagem {
	private List<Produto> produtos;

	public ListarTodosProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public void listar() {
		System.out.println("Lista de todos os produtos:");
		for (Produto produto : produtos) {
			System.out.println("\nCódigo: " + produto.getCodigo());
			System.out.println("Nome: " + produto.getNome());
			System.out.println("Preço: R$" + produto.getPreco());
			System.out.println("Marca: " + produto.getMarca());
			System.out.println("Categoria: " + produto.getCategoria());
			System.out.println("Genero: " + produto.getGenero());
			System.out.println("--------------------------------------");
		}
	}
}
