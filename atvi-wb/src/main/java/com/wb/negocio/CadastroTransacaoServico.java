package com.wb.negocio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;
import com.wb.modelo.Servico;
import com.wb.modelo.Transacao;

public class CadastroTransacaoServico extends Cadastro {
	private List<Servico> servicos;
	private List<Transacao> transacoes;
	private Cliente clienteComprador;
	private Entrada entrada;
	

	public CadastroTransacaoServico(List<Servico> servicos, List<Transacao> transacoes, Cliente clienteComprador) {
		this.servicos = servicos;
		this.transacoes = transacoes;
		this.clienteComprador = clienteComprador;
		this.entrada = new Entrada();
	}
	

	@Override
	public void cadastrar() {

		String codigo = LocalDateTime.now().toString().replace("-", "").replace(":", "").replace(".", "");
		Double valorTotal = 0.0;
		Integer quantidadeServicos = 0;
		ArrayList<Servico> servicosComprados = new ArrayList<>();
		boolean exec = true;
		
		while(exec) {
				
			ProcuraServico procuraServicoTransacao = new ProcuraCodigoServico(servicos);
			Servico servicoProcuradoTransacao = procuraServicoTransacao.procurar();
			if (servicoProcuradoTransacao != null) {
				
				valorTotal = valorTotal + servicoProcuradoTransacao.getPreco();
				quantidadeServicos = quantidadeServicos + 1;
				servicosComprados.add(servicoProcuradoTransacao);
				this.clienteComprador.includeServicoConsumido(servicoProcuradoTransacao);
				System.out.println("\n✔ Servico incluido");
			}
			System.out.println("\n Deseja inserir outro serviço?");
			System.out.println("1 - Sim");
			System.out.println("2 - Não");
			int operacao = entrada.receberNumeroInteiro();
			if (operacao==2) {
				exec = false;
			}
		}

		if (quantidadeServicos > 0) {
			Transacao transacao = new Transacao(codigo, clienteComprador, valorTotal, quantidadeServicos, servicosComprados, LocalDate.now());
			this.transacoes.add(transacao);
			System.out.println("\n✅ Transação registrada");
		}
		else {
			System.out.println("\nCadastro de Transação cancelado, pois nenhum serviço foi incluido.");
		}
		
	}
}