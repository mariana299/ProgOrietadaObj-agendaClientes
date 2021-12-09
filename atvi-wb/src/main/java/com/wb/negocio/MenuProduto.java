package com.wb.negocio;


import com.wb.io.Entrada;
import com.wb.modelo.Empresa;
import com.wb.modelo.Produto;

public class MenuProduto extends Execucao{
	private Empresa empresa;

	public MenuProduto(Empresa empresa) {
		this.empresa = empresa;
		
	}

	@Override
	public void executar() {
		
		boolean execucaoProdutos = true;
		while (execucaoProdutos) {
			System.out.println("\n\n🛍MENU PRODUTOS👙🛒");				
			System.out.println("\nEscolha a operação a ser realizada:");
			System.out.println("1 - ➕Cadastrar Novo Produto");
			System.out.println("2 - 🧐Listar Produtos Cadastrados");
			System.out.println("3 - 📝Editar Produto");
			System.out.println("4 - ❌Deletar Produto");
			System.out.println("0 - 🔙Voltar ao Menu Principal");
			
			Entrada entradaProduto = new Entrada();
			int operacaoProduto = entradaProduto.receberNumeroInteiro();
			
			switch (operacaoProduto) {
				case 0:
					execucaoProdutos = false;
					break;
				case 1:
					Cadastro cadastroProduto = new CadastroProduto(empresa.getProdutos());
					cadastroProduto.cadastrar();
					break;
				case 2:
					Listagem listagemProduto = new ListarTodosProdutos(empresa.getProdutos());
					listagemProduto.listar();
					break;
				case 3:
					ProcuraProduto procuraProdutoEdit = new ProcuraCodigoProduto(empresa.getProdutos());
					Produto produtoProcuradoEdit = procuraProdutoEdit.procurar();
					if (produtoProcuradoEdit != null) {
						Edicao edicaoProduto = new EdicaoProduto(produtoProcuradoEdit);
						edicaoProduto.editar();
					}
					break;
				case 4:
					ProcuraProduto procuraProdutoRemove = new ProcuraCodigoProduto(empresa.getProdutos());
					Produto produtoProcuradoRemove = procuraProdutoRemove.procurar();
					if (produtoProcuradoRemove != null) {
						empresa.getProdutos().remove(produtoProcuradoRemove);
						System.out.println("\n✅ Produto removido");
					}
					break;
			}
			
		}
		

	}

}
