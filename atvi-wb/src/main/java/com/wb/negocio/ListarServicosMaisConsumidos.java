package com.wb.negocio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Servico;
import com.wb.modelo.ServicoQtddConsumo;
import com.wb.modelo.Transacao;

public class ListarServicosMaisConsumidos extends Listagem {
	private List<Transacao> transacoes;
	private List<Servico> servicos;

	public ListarServicosMaisConsumidos(List<Transacao> transacoes, List<Servico> servicos) {
		this.servicos = servicos;
		this.transacoes = transacoes;
	}

	@Override
	public void listar() {
		
		
		List<Servico> listaoServicosConsumidos = new ArrayList<>();
		for (Transacao transacao : transacoes) {
			if (transacao.getServicosComprados() != null) {
				listaoServicosConsumidos.addAll(transacao.getServicosComprados());
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
				System.out.println("Total consumido em valor R$:" + item.getQtddConsumo()*item.getServico().getPreco());
				System.out.println("--------------------------------------");
				count++;
			}
		}
	}
}