package com.wb.negocio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;
import com.wb.modelo.Produto;
import com.wb.modelo.Transacao;

public class CadastroTransacao extends Cadastro {
	private List<Produto> produtos;
	private List<Transacao> transacoes;
	private Cliente clienteComprador;
	private Entrada entrada;
	

	public CadastroTransacao(List<Produto> produtos, List<Transacao> transacoes, Cliente clienteComprador) {
		this.produtos = produtos;
		this.transacoes = transacoes;
		this.clienteComprador = clienteComprador;
		this.entrada = new Entrada();
	}
	

	@Override
	public void cadastrar() {

		String codigo = LocalDateTime.now().toString().replace("-", "").replace(":", "").replace(".", "");
		Double valorTotal = 0.0;
		Integer quantidadeProdutos = 0;
		ArrayList<Produto> produtosComprados = new ArrayList<>();
		boolean exec = true;
		
		while(exec) {
				
			ProcuraProduto procuraProdutoTransacao = new ProcuraCodigoProduto(produtos);
			Produto produtoProcuradoTransacao = procuraProdutoTransacao.procurar();
			if (produtoProcuradoTransacao != null) {
				
				valorTotal = valorTotal + produtoProcuradoTransacao.getPreco();
				quantidadeProdutos = quantidadeProdutos + 1;
				produtosComprados.add(produtoProcuradoTransacao);
				this.clienteComprador.includeProdutoConsumido(produtoProcuradoTransacao);
				System.out.println("\n✔ Produto incluído");
			}
			
			System.out.println("\n Deseja inserir outro produto?");
			System.out.println("1 - Sim");
			System.out.println("2 - Não");
			int operacao = entrada.receberNumeroInteiro();
			if (operacao==2) {
				exec = false;
			}
		}
		
		if (quantidadeProdutos > 0) {
			Transacao transacao = new Transacao(codigo, clienteComprador, valorTotal, quantidadeProdutos, produtosComprados);
			this.transacoes.add(transacao);
			System.out.println("\n✅ Transação registrada");
		}
		else {
			System.out.println("\nCadastro de Transação cancelado, pois nenhum produto foi incluido.");
		}
		
	}
}