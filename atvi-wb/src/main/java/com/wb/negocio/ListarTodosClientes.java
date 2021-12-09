package com.wb.negocio;

import java.util.List;

import com.wb.modelo.Cliente;

public class ListarTodosClientes extends Listagem {
	private List<Cliente> clientes;

	public ListarTodosClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public void listar() {
		System.out.println("Lista de todos os clientes:");
		for (Cliente cliente : clientes) {
			System.out.println("Nome: " + cliente.nome);
			System.out.println("Email: " + cliente.email);
			System.out.println("CPF: " + cliente.getCpf().getValor());
			System.out.println("Telefone: (" + cliente.getTelefone().getDdd() + ")" + cliente.getTelefone().getNumero());
			System.out.println("RG: " + cliente.getRg().getValor());
			System.out.println("Genero: " + cliente.getGenero());
			System.out.println("Data Nascimento: " + cliente.getDataNascimento());
			System.out.println("--------------------------------------");
		}
	}
}
