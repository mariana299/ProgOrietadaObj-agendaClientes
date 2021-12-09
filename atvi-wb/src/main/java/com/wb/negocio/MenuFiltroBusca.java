package com.wb.negocio;


import com.wb.io.Entrada;
import com.wb.modelo.Empresa;

public class MenuFiltroBusca extends Execucao{
	private Empresa empresa;

	public MenuFiltroBusca(Empresa empresa) {
		this.empresa = empresa;
		
	}

	@Override
	public void executar() {
		
		boolean execucaoBusca = true;
		while (execucaoBusca) {
			System.out.println("\nPor favor, escolha o tipo de busca desejada\n");
			System.out.println("1 - Listagem dos 10 clientes que mais consumiram produtos ou serviços, em quantidade, não em valor. \n"
							 + "2 - Listagem de todos os clientes por gênero. \n"
							 + "3 - Listagem geral dos serviços ou produtos mais consumidos. \n"
							 + "4 - Listagem dos serviços ou produtos mais consumidos por gênero. \n"
							 + "5 - Listagem dos 10 clientes que menos consumiram produtos ou serviços. \n"
							 + "6 - Listagem dos 5 clientes que mais consumiram em valor, não em quantidade. \n"
							 + "0 - 🔙Voltar ao Menu Principal");
			
			Entrada entradaBusca = new Entrada();
			int operacaoBusca = entradaBusca.receberNumeroInteiro();
			
			switch (operacaoBusca) {
				case 0:
					execucaoBusca = false;
					break;
				case 1:
					System.out.println("Selecione uma das opções abaixo:"
									+ "\n1 - Buscar por Produtos"
									+ "\n2 - Buscar por Serviços");
					
					Entrada entradaBuscaDezClientes = new Entrada();
					int operacaoBuscaDezClientes = entradaBuscaDezClientes.receberNumeroInteiro();
					
					switch (operacaoBuscaDezClientes) {
						case 0:
							break;
						case 1:
							Listagem listarDezClientes = new ListarDezClientes(empresa.getClientes());
							listarDezClientes.listar();
							break;
						case 2:
							Listagem listarDezClientesServico = new ListarDezClientesServico(empresa.getClientes());
							listarDezClientesServico.listar();
							break;
					}
					break;

				case 2:
					Listagem listarClientesPorGenero = new ListarClientesPorGenero(empresa.getClientes());
					listarClientesPorGenero.listar();
					break;
				
				case 3:
					System.out.println("Selecione uma das opções abaixo:"
							+ "\n1 - Buscar por Produtos"
							+ "\n2 - Buscar por Serviços");
			
					Entrada entradaMaisConsumidos = new Entrada();
					int operacaoMaisConsumidos = entradaMaisConsumidos.receberNumeroInteiro();
			
					switch (operacaoMaisConsumidos) {
					case 0:
						break;
					case 1:
						Listagem listarProdutosMaisConsumidos = new ListarProdutosMaisConsumidos(empresa.getTransacoes(), empresa.getProdutos());
						listarProdutosMaisConsumidos.listar();
						break;
					case 2:
						Listagem listarServicosMaisConsumidos = new ListarServicosMaisConsumidos(empresa.getTransacoes(), empresa.getServicos());
						listarServicosMaisConsumidos.listar();
						break;
					}
					break;

				case 4:
					System.out.println("Selecione uma das opções abaixo:"
							+ "\n1 - Buscar por Produtos"
							+ "\n2 - Buscar por Serviços");
			
					Entrada entradaMaisConsumidosGenero = new Entrada();
					int operacaoMaisConsumidosGenero = entradaMaisConsumidosGenero.receberNumeroInteiro();
			
					switch (operacaoMaisConsumidosGenero) {
					case 0:
						break;
					case 1:
						Listagem listarProdutosMaisConsumidosGenero = new ListarProdutosMaisConsumidosGenero(empresa.getProdutos(), empresa.getClientes());
						listarProdutosMaisConsumidosGenero.listar();
						break;
					case 2:
						Listagem listarServicosMaisConsumidosGenero = new ListarServicosMaisConsumidosGenero(empresa.getServicos(), empresa.getClientes());
						listarServicosMaisConsumidosGenero.listar();
						break;
					}
					break;

				case 5:
					System.out.println("Selecione uma das opções abaixo:"
							+ "\n1 - Buscar por Produtos"
							+ "\n2 - Buscar por Serviços");
			
					Entrada entradaBuscaDezClientesMenos = new Entrada();
					int operacaoBuscaDezClientesMenos = entradaBuscaDezClientesMenos.receberNumeroInteiro();
			
					switch (operacaoBuscaDezClientesMenos) {
					case 0:
						break;
					case 1:
						Listagem listarDezClientesMenos = new ListarDezClientesMenos(empresa.getClientes());
						listarDezClientesMenos.listar();
						break;
					case 2:
						Listagem listarDezClientesMenosServico = new ListarDezClientesMenosServico(empresa.getClientes());
						listarDezClientesMenosServico.listar();
						break;
					}
					break;
					
				case 6:
					System.out.println("Selecione uma das opções abaixo:"
							+ "\n1 - Buscar por Produtos"
							+ "\n2 - Buscar por Serviços");
			
					Entrada entradaBuscaCincoClientesValor = new Entrada();
					int operacaoBuscaCincoClientesValor = entradaBuscaCincoClientesValor.receberNumeroInteiro();
			
					switch (operacaoBuscaCincoClientesValor) {
					case 0:
						break;
					case 1:
						Listagem listarCincoClientesValor = new ListarCincoClientesValor(empresa.getClientes());
						listarCincoClientesValor.listar();
						break;
					case 2:
						Listagem listarCincoClientesValorServico = new ListarCincoClientesValorServico(empresa.getClientes());
						listarCincoClientesValorServico.listar();
						break;
					}
					break;
			}
		}

	}

}
