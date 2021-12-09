package com.wb.negocio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;
import com.wb.modelo.Produto;
import com.wb.modelo.ProdutoQtddConsumo;

public class ListarProdutosMaisConsumidosGenero extends Listagem {
	private List<Produto> produtos;
	private List<Cliente> clientes;
	private Entrada entrada;

	public ListarProdutosMaisConsumidosGenero(List<Produto> produtos, List<Cliente> clientes) {
		this.produtos = produtos;
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
                
		List<Produto> listaoProdutosConsumidos = new ArrayList<>();
		for (Cliente cliente : clientes) {
			if (cliente.getGenero().equals(genero)) {
				listaoProdutosConsumidos.addAll(cliente.getProdutosConsumidos());
			}
		}
		
		List<ProdutoQtddConsumo> listaoProdutosQtddConsumida = new ArrayList<>();
		for (Produto produto : produtos) {
			int ocorrencias = Collections.frequency(listaoProdutosConsumidos, produto);
			ProdutoQtddConsumo produtoQtddConsumo = new ProdutoQtddConsumo(produto, ocorrencias);
			listaoProdutosQtddConsumida.add(produtoQtddConsumo);
		}

		listaoProdutosQtddConsumida.sort(Comparator.comparing(ProdutoQtddConsumo::getQtddConsumo).reversed());

		System.out.println("\nPor favor, informe a quatidade de produtos que deseja listar:\n");
		Entrada entrada = new Entrada();
		int quantidadeProdutos = entrada.receberNumeroInteiro();
		int count = 0;
		System.out.println("\nLista dos Produtos Mais Consumidos pelo público " + genero + ":\n");
		for (ProdutoQtddConsumo item : listaoProdutosQtddConsumida) {
			if (count < quantidadeProdutos)
			{
				System.out.println("\nCódigo: " + item.getProduto().getCodigo());
				System.out.println("Nome: " + item.getProduto().getNome());
				System.out.println("Preço: R$" + item.getProduto().getPreco());
				System.out.println("Marca: " + item.getProduto().getMarca());
				System.out.println("Quantidade de itens: " + item.getQtddConsumo());
				System.out.println("Total consumido em valor R$:" + item.getQtddConsumo()*item.getProduto().getPreco());
				System.out.println("--------------------------------------");
				count++;
			}
		}
	}
}