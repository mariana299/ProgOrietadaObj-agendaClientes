package com.wb.negocio;


import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Produto;


public class CadastroProduto extends Cadastro {
	private List<Produto> produtos;
	private Entrada entrada;

	public CadastroProduto(List<Produto> produtos) {
		this.produtos = produtos;
		this.entrada = new Entrada();
	}

	@Override
	public void cadastrar() {
		System.out.println("\nInício do cadastro do produto\n");
		
		System.out.println("\nPor favor, informe o código do produto:");
		String codigo = entrada.receberTexto();
		
		System.out.println("\nPor favor, informe o nome do produto:");
		String nome = entrada.receberTexto();
		
		System.out.println("\nPor favor, informe a marca do produto:");
		String marca = entrada.receberTexto();
		
		System.out.println("\nPor favor, informe o preço do produto:");
		Double preco = entrada.receberNumeroDouble();
				
		System.out.println("\nPor favor, selecione a categoria:");
		String categoria = null;
		System.out.println("1 - para Banho");
		System.out.println("2 - para Cuidados Pessoais");
		System.out.println("3 - para Beleza");
		System.out.println("4 - eletrônicos ");
		System.out.println("5 - vestuários");
		System.out.println("6 - outros");
		Entrada entradaCategoria = new Entrada();
		int operacaoCategoria = entradaCategoria.receberNumeroInteiro();
		switch (operacaoCategoria) {
			case 1:
				categoria = "para Banho";
				break;
			case 2:
				categoria = "para Cuidados Pessoais";
				break;
			case 3:
				categoria = "para Beleza";
				break;
			case 4:
				categoria = "eletrônicos";
				break;
			case 5:
				categoria = "vestuários";
				break;
			case 6:
				categoria = "outros";
				break;
			default:
				System.out.println("\nOperação não realizada");	
		}
		
		System.out.println("\nPor favor, informe o genero do produto:");
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
				genero = "Unissex";
				break;
			default:
				System.out.println("\nOperação não realizada");
		}
		
		Produto produto = new Produto(codigo, nome, preco, marca, categoria, genero);
		this.produtos.add(produto);
		System.out.println("\n✅Produto cadastrado");
	}
}