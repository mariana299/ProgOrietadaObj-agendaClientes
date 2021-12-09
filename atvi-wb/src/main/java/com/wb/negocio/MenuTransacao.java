package com.wb.negocio;


import com.wb.io.Entrada;
import com.wb.modelo.Cliente;
import com.wb.modelo.Empresa;

public class MenuTransacao extends Execucao{
	private Empresa empresa;

	public MenuTransacao(Empresa empresa) {
		this.empresa = empresa;
		
	}

	@Override
	public void executar() {
		
		boolean execucaoTransacoes = true;
		while (execucaoTransacoes) {
			System.out.println("\n\n💶MENU TRANSAÇÕES💳💲");				
			System.out.println("\nEscolha a operação a ser realizada:");
			System.out.println("1 - ➕Cadastrar Nova Transação");
			System.out.println("2 - 🧐Listar Transacoes Cadastradas");
			System.out.println("0 - 🔙Voltar ao Menu Principal");
			
			Entrada entradaTransacao = new Entrada();
			int operacaoTransacao = entradaTransacao.receberNumeroInteiro();
			
			switch (operacaoTransacao) {
				case 0:
					execucaoTransacoes = false;
					break;
				case 1:
					System.out.println("Início do registro de transação");
					ProcuraCliente procuraClienteTransacao = new ProcuraCpf(empresa.getClientes());
					Cliente clienteProcuradoTransacao = procuraClienteTransacao.procurar();
					if (clienteProcuradoTransacao != null) {
						
						System.out.println("\nPor favor, selecione o tipo de transação que deseja realizar:");
						System.out.println("1 - Produtos");
						System.out.println("2 - Serviço");
						
						Entrada entradaTransacaoTipo = new Entrada();
						int operacaoTransacaoTipo = entradaTransacaoTipo.receberNumeroInteiro();
						
						switch (operacaoTransacaoTipo) {
							case 1:
								Cadastro cadastroTransacao = new CadastroTransacao(empresa.getProdutos(), empresa.getTransacoes(), clienteProcuradoTransacao);
								cadastroTransacao.cadastrar();
								break;
							case 2:
								Cadastro cadastroTransacaoServico = new CadastroTransacaoServico(empresa.getServicos(), empresa.getTransacoes(), clienteProcuradoTransacao);
								cadastroTransacaoServico.cadastrar();
								break;
						}
						break;
					}
					break;
				case 2:
					Listagem listagemTransacao = new ListarTodasTransacoes(empresa.getTransacoes());
					listagemTransacao.listar();
					break;
			}
		}
	}

}
