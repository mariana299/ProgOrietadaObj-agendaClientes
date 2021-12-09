package com.wb.io;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.wb.modelo.CPF;
import com.wb.modelo.Cliente;
import com.wb.modelo.Produto;
import com.wb.modelo.Transacao;
import com.wb.negocio.Cadastro;
import com.wb.modelo.RG;
import com.wb.modelo.Servico;
import com.wb.modelo.Telefone;


public class Mock extends Cadastro {
	private List<Cliente> clientes;
	private List<Produto> produtos;
	private List<Transacao> transacoes;
	private List<Servico> servicos;
	
	public Mock(List<Cliente> clientes, List<Produto> produtos, List<Transacao> transacoes, List<Servico> servicos) {
		this.clientes = clientes;
		this.produtos = produtos;
		this.transacoes = transacoes;
		this.servicos = servicos;
	}
	@Override
	public void cadastrar() {
		
		// 20 Produtos:
		String mockProdutosCodigo [] = {"1" , "2" , "3" , "4" , "5" , "6" , "7" , "8" , "9" , "10" , "11" , "12" , "13" , "14" , "15" , "16" , "17" , "18" , "19" , "20"};
		String mockProdutosNome [] = {"shampoo" , "condicionador" , "sabonete" , "demaquilante" , "sabonete líquido" , "rímel" , "pancake" , "shampoo" , "condicionador" , "sabonete" , "demaquilante" , "sabonete líquido" , "rímel" , "locao barba" , "shampoo" , "condicionador" , "shampoo 2 in 1" , "sabonete" , "barbeador" , "depilador"};
		Double mockProdutosPreco [] = {5.0 , 15.0 , 3.0 , 10.0 , 20.0 , 30.0 , 50.0 , 10.0 , 30.0 , 6.0 , 20.0 , 40.0 , 60.0 , 3.0 , 15.0 , 20.0 , 10.0 , 2.0 , 100.0 , 1000.0};
		String mockProdutosMarca [] = {"Fantástica" , "Fantástica" , "Fantástica" , "Fantástica" , "Fantástica" , "Fantástica" , "Fantástica" , "Maravilhosa" , "Maravilhosa" , "Maravilhosa" , "Maravilhosa" , "Maravilhosa" , "Beauty Care" , "Beauty Care" , "Beauty Care" , "Beauty Care" , "Beauty Care" , "Beauty Care" , "Elec" , "Elec"};
		String mockProdutosCategoria [] = {"para Banho" , "para Banho" , "para Banho" , "para Beleza" , "para Banho" , "para Beleza" , "para Beleza" , "para Banho" , "para Banho" , "para Banho" , "para Beleza" , "para Banho" , "para Beleza" , "para Beleza" , "para Banho" , "para Banho" , "para Banho" , "para Banho" , "eletrônicos" , "eletrônicos"};
		String mockProdutosGenero [] = {"Unissex" , "Unissex" , "Unissex" , "Feminino" , "Unissex" , "Feminino" , "Feminino" , "Unissex" , "Unissex" , "Unissex" , "Feminino" , "Unissex" , "Feminino" , "Masculino" , "Masculino" , "Masculino" , "Masculino" , "Masculino" , "Masculino" , "Feminino"};		

		
		// 20 Servicos:
		String mockServicosCodigo [] = {"1" , "2" , "3" , "4" , "5" , "6" , "7" , "8" , "9" , "10" , "11" , "12" , "13" , "14" , "15" , "16" , "17" , "18" , "19" , "20"};
		String mockServicosNome [] = {"manicure" , " pedicure" , "design de sobrancelhas" , "corte de cabelos" , "pintura de cabelos" , "remoção de rugas" , " remoção de manchas na pele" , "aplicação de botox" , "tratamento para emagrecimento" , "redução de medidas" , "corte de cabelo" , "modelagem e corte de barba" , "tratamento para quedas de cabelo" , "venda de produtos especializados" , "Spa dos pés" , "manicure" , "pedicure" , "remoção de cravos" , "lipo francesa" , "bichectomia"};
		Double mockServicosPreco [] = {20.0, 50.0, 30.0, 100.0, 80.0, 500.0, 1000.0, 2000.0, 5000.0, 1000.0, 60.0, 60.0, 1000.0, 70.0, 100.0, 100.0, 100.0, 100.0, 1000.0, 1000.0};
		String mockServicosCategoria [] = {"unhas" , "unhas" , "outros" , "cabelos" , "cabelos" , "tratamentos estéticos" , "tratamentos estéticos" , "tratamentos estéticos" , "tratamentos estéticos" , "tratamentos estéticos" , "cabelos" , "outros" , "tratamentos estéticos" , "outros" , "tratamentos estéticos" , "unhas" , "unhas" , "tratamentos estéticos" , "tratamentos estéticos" , "tratamentos estéticos"};
		String mockServicosGenero [] = {"Feminino" , "Feminino" , "Feminino" , "Feminino" , "Feminino" , "Feminino" , "Feminino" , "Feminino" , "Feminino" , "Feminino" , "Masculino" , "Masculino" , "Masculino" , "Masculino" , "Unissex" , "Masculino" , "Masculino" , "Unissex" , "Feminino" , "Feminino"};		

		for (int i = 0; i < 20; i++){
			Produto produtosMock = new Produto(mockProdutosCodigo[i], mockProdutosNome[i], mockProdutosPreco[i], mockProdutosMarca[i], mockProdutosCategoria[i], mockProdutosGenero[i]);
			this.produtos.add(produtosMock);
			
			Servico servicosMock = new Servico(mockServicosCodigo[i], mockServicosNome[i], mockServicosPreco[i], mockServicosCategoria[i], mockServicosGenero[i]);
			this.servicos.add(servicosMock);
		}
		
		// 30 Clients:
		String mockClientesNome [] = {"Miguel", "Davi", "Gabriel", "Arthur", "Lucas", "Matheus", "Pedro", "Guilherme", "Gustavo", "Rafael", "Felipe", "Bernardo", "Enzo", "Nicolas", "João Pedro", "Sophia", "Emma", "Isabella", "Olivia", "Ava", "Emily", "Abigail", "Mia", "Madison", "Elizabeth", "Sofia", "Giulia", "Martina", "Giorgia", "Sara"};			
		String mockClientesEmail [] = {"miguel@gmail.com" , "davi@gmail.com", "gabriel@gmail.com", "arthur@gmail.com", "lucas@gmail.com", "matheus@gmail.com", "pedro@gmail.com", "guilherme@gmail.com", "gustavo@gmail.com", "rafael@gmail.com", "felipe@gmail.com", "bernardo@gmail.com", "enzo@gmail.com", "nicolas@gmail.com", "joão pedro@gmail.com", "sophia@gmail.com", "emma@gmail.com", "isabella@gmail.com", "olivia@gmail.com", "ava@gmail.com", "emily@gmail.com", "abigail@gmail.com", "mia@gmail.com", "madison@gmail.com", "elizabeth@gmail.com", "sofia@gmail.com", "giulia@gmail.com", "martina@gmail.com", "giorgia@gmail.com", "sara@gmail.com"};		
		CPF mockClientesCpf [] = {new CPF("97519775479"), new CPF("326533242916"), new CPF("285719808060"), new CPF("53703309839"), new CPF("341426294310"), new CPF("254472634603"), new CPF("819615375980"), new CPF("432173691391"), new CPF("275242620931"), new CPF("177980942702"), new CPF("935277346930"), new CPF("957289855169"), new CPF("163094891112"), new CPF("68461424679"), new CPF("564045749974"), new CPF("651032564786"), new CPF("990167691905"), new CPF("481520335032"), new CPF("988460568255"), new CPF("276762683312"), new CPF("438508985174"), new CPF("379209396256"), new CPF("285465212570"), new CPF("21037988344"), new CPF("575288021396"), new CPF("196819278358"), new CPF("498936896077"), new CPF("666982770459"), new CPF("672608493305"), new CPF("317926170451")};		
		RG mockClientesRg [] = {new RG("1778324410"), new RG("5429120590"), new RG("7674218321"), new RG("9117709986"), new RG("3926341849"), new RG("1234703263"), new RG("2921675040"), new RG("3714261200"), new RG("5682612981"), new RG("33684736"), new RG("1490263219"), new RG("5476834654"), new RG("6809176758"), new RG("3756878632"), new RG("3137606897"), new RG("5657254659"), new RG("7549152872"), new RG("4856848684"), new RG("535547484"), new RG("9210158723"), new RG("8700188241"), new RG("4751453073"), new RG("249000375"), new RG("6871167982"), new RG("189412393"), new RG("2101975979"), new RG("8384979720"), new RG("6441501791"), new RG("391163055"), new RG("8777569111")};
		String mockClientesGenero [] = {"Masculino", "Masculino", "Masculino", "Masculino", "Masculino", "Masculino", "Masculino", "Masculino", "Masculino", "Masculino", "Masculino", "Masculino", "Masculino", "Masculino", "Masculino", "Feminino", "Feminino", "Feminino", "Feminino", "Feminino", "Feminino", "Feminino", "Feminino", "Feminino", "Feminino", "Feminino", "Feminino", "Feminino", "Feminino", "Feminino"};
		LocalDate mockClientesNascimento [] = {LocalDate.parse("12/01/1991", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("12/02/1990", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("11/03/1991", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("03/03/1987", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("16/04/1988", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("17/05/1957", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("18/06/1961", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("19/01/1973", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("20/01/1999", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("21/10/2000", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("22/12/1997", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("23/11/1989", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("24/10/1988", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("25/09/1984", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("26/08/1982", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("27/09/1984", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("28/07/1985", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("29/08/1995", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("12/06/1992", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("12/06/1996", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("12/12/1949", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("12/11/1950", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("12/09/1968", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("12/08/1993", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("12/09/1995", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("12/08/1992", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("12/07/1993", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("14/06/1994", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("14/07/1995", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("13/01/1996", DateTimeFormatter.ofPattern("dd/MM/yyyy"))};
		Telefone mockClientesTelefone [] = {new Telefone("12","9957992"), new Telefone("12","9859961"), new Telefone("12","9101810"), new Telefone("12","9509087"), new Telefone("12","9457658"), new Telefone("12","9962403"), new Telefone("12","9798545"), new Telefone("12","925785"), new Telefone("12","9693459"), new Telefone("12","9581714"), new Telefone("12","9159600"), new Telefone("12","9289735"), new Telefone("12","9232174"), new Telefone("12","980844"), new Telefone("12","9181073"), new Telefone("12","9258621"), new Telefone("12","9645350"), new Telefone("12","9138160"), new Telefone("12","9701829"), new Telefone("12","9792138"), new Telefone("12","9191779"), new Telefone("12","9761081"), new Telefone("12","9836382"), new Telefone("12","9519110"), new Telefone("12","9492588"), new Telefone("12","9377950"), new Telefone("12","9147665"), new Telefone("12","9687404"), new Telefone("12","9193902"), new Telefone("12","9537200")};
		
		for (int i = 0; i < 30; i++){
			Cliente clienteMock = new Cliente(mockClientesNome[i], mockClientesEmail[i], mockClientesCpf[i], mockClientesRg[i], mockClientesGenero[i], mockClientesNascimento[i], mockClientesTelefone[i]);
			this.clientes.add(clienteMock);
			
			Integer count = 0;
			if (i<20) {
				count = i;
			}
			else {
				count = i -10;
			}
				
			String codigo = LocalDateTime.now().toString().replace("-", "").replace(":", "").replace(".", "");
			Double valorTotal = 0.0;
			Integer quantidadeProdutos = 0;
			ArrayList<Produto> produtosComprados = new ArrayList<>();
				
			while (count > 0)
			{					
				for (Produto produto : produtos) {
					if (Integer.parseInt(produto.getCodigo())==count) {				    	 
						valorTotal = valorTotal + produto.getPreco();
						quantidadeProdutos = quantidadeProdutos + 1;
						produtosComprados.add(produto);
						clienteMock.includeProdutoConsumido(produto);

					}
				}


				count--;
			}
			Transacao transacao = new Transacao(codigo, clienteMock, valorTotal, quantidadeProdutos, produtosComprados);
			this.transacoes.add(transacao);
			
			
			if (i<20) {
				count = i;
			}
			else {
				count = i -10;
			}
			
			String codigoServico = LocalDateTime.now().toString().replace("-", "").replace(":", "").replace(".", "");
			Double valorTotalServico = 0.0;
			Integer quantidadeServicos = 0;
			ArrayList<Servico> servicosComprados = new ArrayList<>();
				
			while (count > 0)
			{					
				for (Servico servico : servicos) {
					if (Integer.parseInt(servico.getCodigo())==count) {				    	 
						valorTotalServico += servico.getPreco();
						quantidadeServicos += + 1;
						servicosComprados.add(servico);
						clienteMock.includeServicoConsumido(servico);

					}
				}


				count--;
			}
			Transacao transacaoServico = new Transacao(codigoServico, clienteMock, valorTotalServico, quantidadeServicos, servicosComprados, LocalDate.now());
			this.transacoes.add(transacaoServico);


		}
		
	}
	
}
