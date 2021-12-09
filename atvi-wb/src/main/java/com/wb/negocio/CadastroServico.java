package com.wb.negocio;


import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Servico;


public class CadastroServico extends Cadastro {
	private List<Servico> servicos;
	private Entrada entrada;

	public CadastroServico(List<Servico> servicos) {
		this.servicos = servicos;
		this.entrada = new Entrada();
	}

	@Override
	public void cadastrar() {
		System.out.println("\nInício do cadastro de serviço\n");
		
		System.out.println("\nPor favor, informe o código do serviço:");
		String codigo = entrada.receberTexto();
		
		System.out.println("\nPor favor, informe o nome do serviço:");
		String nome = entrada.receberTexto();
		
		System.out.println("\nPor favor, informe o preço do serviço:");
		Double preco = entrada.receberNumeroDouble();
				
		System.out.println("\nPor favor, selecione a categoria:");
		String categoria = null;
		System.out.println("1 - unhas");
		System.out.println("2 - cabelos");
		System.out.println("3 - tratamentos estéticos");
		System.out.println("4 - outros");
		Entrada entradaCategoria = new Entrada();
		int operacaoCategoria = entradaCategoria.receberNumeroInteiro();
		switch (operacaoCategoria) {
			case 1:
				categoria = "unhas";
				break;
			case 2:
				categoria = "cabelos";
				break;
			case 3:
				categoria = "tratamentos estéticos";
				break;
			case 4:
				categoria = "outros";
				break;
			default:
				System.out.println("\nOperação não realizada");	
		}
		
		System.out.println("\nPor favor, informe o genero do serviço:");
		String genero = null;
		System.out.println("1 - Feminino");
		System.out.println("2 - Masculino");
		System.out.println("3 - Unissex");
		Entrada entrada = new Entrada();
		int operacao = entrada.receberNumeroInteiro();
		switch (operacao) {
			case 1:
				genero = "Feminino";
				break;
			case 2:
				genero = "Masculino";
				break;
			case 3:
				genero = "Unisex";
				break;
			default:
				System.out.println("\nOperação não realizada");
		}
		
		Servico servico = new Servico(codigo, nome, preco, categoria, genero);
		this.servicos.add(servico);
		System.out.println("\n✅Serviço cadastrado");
	}
}