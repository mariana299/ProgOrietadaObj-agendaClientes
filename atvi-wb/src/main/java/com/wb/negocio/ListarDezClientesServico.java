package com.wb.negocio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;
import com.wb.modelo.ClienteQtddConsumo;
import com.wb.modelo.Servico;

public class ListarDezClientesServico extends Listagem {
	private List<Cliente> clientes;

	public ListarDezClientesServico(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public void listar() {
                
		List<ClienteQtddConsumo> listaoClientesQtddConsumida = new ArrayList<>();
		
		for (Cliente cliente : clientes) {
			double itensConsumidos = cliente.getServicosConsumidos().size();
			ClienteQtddConsumo clienteQtddConsumo = new ClienteQtddConsumo(cliente, itensConsumidos);	
			listaoClientesQtddConsumida.add(clienteQtddConsumo);
		}

		listaoClientesQtddConsumida.sort(Comparator.comparing(ClienteQtddConsumo::getQtddConsumo).reversed());

	
		boolean flag = true;	
		System.out.println("Por favor, selecione uma opção");
		System.out.println("1 - Imprimir lista detalhando todos os itens adquiridos pelo cliente");
		System.out.println("2 - Imprimir lista simplificada");
		Entrada entrada = new Entrada();
		int operacao = entrada.receberNumeroInteiro();
		switch (operacao) {
			case 1:
				flag = true;
				break;
			case 2:
				flag = false;
				break;
			default:
				System.out.println("Operação não entendida");				
			break;	
		}		
		
		int quantidadeServicos = 10;
		int count = 0;
		System.out.println("\nLista dos 10 clientes que mais consumiram serviço em quantidade:\n");
		for (ClienteQtddConsumo item : listaoClientesQtddConsumida) {
			if (count < quantidadeServicos)
			{
				System.out.println("\nNome: " + item.getCliente().nome);
				System.out.println("CPF: " + item.getCliente().getCpf().getValor());
				System.out.println("Quantidade de itens: " + item.getQtddConsumo().intValue());
				int contadorServico = 1;
				if (flag) {
					System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
					System.out.println("Lista de Itens consumidos por " + item.getCliente().nome);
					for (Servico servico : item.getCliente().getServicosConsumidos()) {
						System.out.println(contadorServico + ". "+servico.getNome() + " - R$:" + servico.getPreco());
						contadorServico++;
					}
				}
				System.out.println("--------------------------------------");
				count++;
			}
		}
	}
}