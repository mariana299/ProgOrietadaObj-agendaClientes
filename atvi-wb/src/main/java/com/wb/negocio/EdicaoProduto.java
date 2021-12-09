package com.wb.negocio;

import com.wb.io.Entrada;
import com.wb.modelo.Produto;

public class EdicaoProduto extends Edicao{
    private Produto produto;

    public EdicaoProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public void editar() {
        System.out.println("\n MENU EDITAR PRODUTO");
        boolean execucao = true;
        while (execucao) {
            System.out.println("\n Qual atributo deseja editar?\n");
			System.out.println("1 - Código");
			System.out.println("2 - Nome");
			System.out.println("3 - Preço");
			System.out.println("4 - Marca");
			System.out.println("5 - Categoria");
			System.out.println("6 - Gênero");
            System.out.println("0 - Sair");

			Entrada entrada = new Entrada();
			int operacao = entrada.receberNumeroInteiro();
            switch (operacao) {
            	case 0:
            		execucao = false;
            		break;
                case 1:
                    Entrada entradaCodigo = new Entrada();
                    System.out.print("\n Informe o novo código: ");
                    String codigo = entradaCodigo.receberTexto();
                    produto.setCodigo(codigo);
                    System.out.println("\n✅ Código editado\n");
                    break;
                case 2:
                	Entrada entradaNome = new Entrada();
                    System.out.print("\n Informe o novo nome: ");
                    String nome = entradaNome.receberTexto();
                    produto.setNome(nome);
                    System.out.println("\n✅ Nome editado\n");
                    break;
                case 3:
                	Entrada entradaPreco = new Entrada();
                    System.out.print("\n Informe o novo preço: ");
                    Double preco = entradaPreco.receberNumeroDouble();
                    produto.setPreco(preco);
                    System.out.println("\n✅ Preço editado\n");
                    break;
                case 4:
                	Entrada entradaMarca = new Entrada();
                    System.out.print("\n Informe a nova marca: ");
                    String marca = entradaMarca.receberTexto();
                    produto.setMarca(marca);
                    System.out.println("\n✅ Marca editada\n");
                    break;
                case 5:
                    String categoria = "";
                    boolean execCategoria = true;
                    while (execCategoria) {
                        System.out.println("\n Informe a nova Categoria: ");
                        System.out.println("1 - para Banho");
                		System.out.println("2 - para Cuidados Pessoais");
                		System.out.println("3 - para Beleza");
                		System.out.println("4 - eletrônicos ");
                		System.out.println("5 - vestuários");
                		System.out.println("6 - outros");
                        int operacaoCategoria = entrada.receberNumeroInteiro();
                        switch (operacaoCategoria) {
                            case 1:
                                categoria = "para Banho";
                                execCategoria = false;
                                break;
                            case 2:
                            	categoria = "para Cuidados Pessoais";
                                execCategoria = false;
                                break;
                            case 3:
                            	categoria = "para Beleza";
                                execCategoria = false;
                                break;
                            case 4:
                            	categoria = "eletrônicos";
                                execCategoria = false;
                                break;
                            case 5:
                            	categoria = "vestuários";
                                execCategoria = false;
                                break;
                            case 6:
                            	categoria = "outros";
                                execCategoria = false;
                                break;
                            default:
                                break;
                        }
                    }
                    produto.setCategoria(categoria);
                    System.out.println("\n✅ Categoria editada");
                    break;
                
                case 6:
                	 String genero = "";
                     boolean execGenero = true;
                     while (execGenero) {
                         System.out.println("\n Informe o novo Gênero: ");
                         System.out.print("1- Masculino");
                         System.out.print("2 - Feminino");
                         System.out.print("3 - Unissex");
                         int operacaoGenero = entrada.receberNumeroInteiro();
                         switch (operacaoGenero) {
                             case 1:
                                 genero = "Masculino";
                                 execGenero = false;
                                 break;
                             case 2:
                                 genero = "Feminino";
                                 execGenero = false;
                                 break;
                             case 3:
                                 genero = "Unissex";
                                 execGenero = false;
                                 break;
                             default:
                                 break;
                         }
                     }
                     produto.setGenero(genero);
                     System.out.println("\n✅ Gênero editado");
                     break;
                default:
                    System.out.println("\n Operação não realizada\n");
            }
        }
    }
    
}
