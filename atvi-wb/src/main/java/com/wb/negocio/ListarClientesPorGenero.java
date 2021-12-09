package com.wb.negocio;


import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;

public class ListarClientesPorGenero extends Listagem {
	private List<Cliente> clientes;

	public ListarClientesPorGenero(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	@Override
	public void listar() {
		
		System.out.println("\n Qual o gênero dos clientes deseja listar?\n");
		System.out.println("1 - Feminino");
		System.out.println("2 - Masculino");
		
		String genero = "";
		
		Entrada entrada = new Entrada();
		int operacao = entrada.receberNumeroInteiro();
        switch (operacao) {
        	case 0:
        		break;
            case 1:
            	System.out.println("\nClientes do Gênero Feminino\n");
                genero = "Feminino";
                
                break;
            case 2:
            	System.out.println("\nClientes do Gênero Masculino\n");
                genero = "Masculino";
                
                break;
        }
        
        for (Cliente cliente : clientes) {
            if (cliente.getGenero().equals(genero)) {
            	System.out.println("Nome: " + cliente.nome);
    			System.out.println("Email: " + cliente.email);
    			System.out.println("CPF: " + cliente.getCpf().getValor());
    			System.out.println("RG: " + cliente.getRg().getValor());
    			System.out.println("Genero: " + cliente.getGenero());
    			System.out.println("Data Nascimento: " + cliente.getDataNascimento());
    			System.out.println("--------------------------------------");
            }
        }
		
	}

}
