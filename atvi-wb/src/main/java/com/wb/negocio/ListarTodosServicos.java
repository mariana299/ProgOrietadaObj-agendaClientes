package com.wb.negocio;

import java.util.List;

import com.wb.modelo.Servico;

public class ListarTodosServicos extends Listagem {
	private List<Servico> servicos;

	public ListarTodosServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	@Override
	public void listar() {
		System.out.println("Lista de todos os servicos:");
		for (Servico servico : servicos) {
			System.out.println("\nCódigo: " + servico.getCodigo());
			System.out.println("Nome: " + servico.getNome());
			System.out.println("Preço: R$" + servico.getPreco());
			System.out.println("Categoria: " + servico.getCategoria());
			System.out.println("Genero: " + servico.getGenero());
			System.out.println("--------------------------------------");
		}
	}
}
