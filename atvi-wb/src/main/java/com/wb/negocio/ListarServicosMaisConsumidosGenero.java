package com.wb.negocio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;
import com.wb.modelo.Servico;
import com.wb.modelo.ServicoQtddConsumo;

public class ListarServicosMaisConsumidosGenero extends Listagem {
	private List<Cliente> clientes;
	private List<Servico> servicos;
	private Entrada entrada;

	public ListarServicosMaisConsumidosGenero(List<Servico> servicos, List<Cliente> clientes) {
		this.servicos = servicos;
		this.clientes = clientes;
		this.entrada = new Entrada();
	}

	@Override
	public void listar() {
		
		
		System.out.println("\nPor favor, escolha o Genero a ser buscado: ");
        System.out.print("\n1 - Masculino");
        System.out.print("\n2 - Feminino\n");
        String genero = null;
        int operacaoGenero = entrada.receberNumeroInteiro();
        switch (operacaoGenero) {
            case 1:
                genero = "Masculino";
                break;
            case 2:
                genero = "Feminino";
                break;
            default:
                break;	
        }
		
		List<Servico> listaoServicosConsumidos = new ArrayList<>();
		for (Cliente cliente : clientes) {
			if (cliente.getGenero().equals(genero)) {
				listaoServicosConsumidos.addAll(cliente.getServicosConsumidos());
			}
		}
		
		List<ServicoQtddConsumo> listaoServicosQtddConsumida = new ArrayList<>();
		for (Servico servico : servicos) {
			int ocorrencias = Collections.frequency(listaoServicosConsumidos, servico);
			ServicoQtddConsumo servicoQtddConsumo = new ServicoQtddConsumo(servico, ocorrencias);
			listaoServicosQtddConsumida.add(servicoQtddConsumo);
		}

		listaoServicosQtddConsumida.sort(Comparator.comparing(ServicoQtddConsumo::getQtddConsumo).reversed());

		System.out.println("\nPor favor, informe a quatidade de serviços que deseja listar:\n");
		Entrada entrada = new Entrada();
		int quantidadeServicos = entrada.receberNumeroInteiro();
		int count = 0;
		System.out.println("\nLista dos Serviços Mais Consumidos:\n");
		for (ServicoQtddConsumo item : listaoServicosQtddConsumida) {
			if (count < quantidadeServicos)
			{
				System.out.println("\nCódigo: " + item.getServico().getCodigo());
				System.out.println("Nome: " + item.getServico().getNome());
				System.out.println("Preço: R$" + item.getServico().getPreco());
				System.out.println("Quantidade de itens: " + item.getQtddConsumo());
				System.out.println("Total consumido em valorR$:" + item.getQtddConsumo()*item.getServico().getPreco());
				System.out.println("--------------------------------------");
				count++;
			}
		}
	}
}