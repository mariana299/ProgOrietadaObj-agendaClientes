package com.wb;

import com.wb.io.Entrada;
import com.wb.io.Mock;
import com.wb.modelo.Empresa;
import com.wb.negocio.MenuCliente;
import com.wb.negocio.MenuFiltroBusca;
import com.wb.negocio.MenuProduto;
import com.wb.negocio.MenuServico;
import com.wb.negocio.MenuTransacao;

public class App {
	public static void main(String[] args) {
		
		//https://www.w3schools.com/charsets/ref_emoji.asp
		System.out.println("👤Bem-vindo a aplicação do 🌐Grupo World 🌸Beauty🌐");
		Empresa empresa = new Empresa();
		
		Mock mock = new Mock(empresa.getClientes(), empresa.getProdutos(), empresa.getTransacoes(), empresa.getServicos());
		mock.cadastrar();
		
		boolean execucao = true;
		while (execucao) {
			System.out.println("\n\n🛠MENU PRINCIPAL⛏");
			System.out.println("\nEscolha uma das opções do sistema:");
			System.out.println("1 - 👥 Clientes");
			System.out.println("2 - 👛 Produtos");
			System.out.println("3 - 👫 Serviços");
			System.out.println("4 - 💰 Transações");
			System.out.println("5 - 🔎 Filtros de Busca");
			System.out.println("0 - 🔚 Sair ");

			Entrada entrada = new Entrada();
			int operacao = entrada.receberNumeroInteiro();

			switch (operacao) {
			case 0:
				execucao = false;
				System.out.println("\nAté mais! 😘\n");
				break;
				
			case 1:
				MenuCliente menuCliente = new MenuCliente(empresa);
				menuCliente.executar();
				break;
			
			case 2:		
				MenuProduto menuProduto = new MenuProduto(empresa);
				menuProduto.executar();
				break;
			
			case 3:
				MenuServico menuServico = new MenuServico(empresa);
				menuServico.executar();
				break;
			
			case 4:	
				MenuTransacao menuTransacao = new MenuTransacao(empresa);
				menuTransacao.executar();
				break;
				
			case 5:
				MenuFiltroBusca menuFiltroBusca = new MenuFiltroBusca(empresa);
				menuFiltroBusca.executar();
				break;
				
			default:
				System.out.println("Operação não entendida");
			}
		}
	}
}