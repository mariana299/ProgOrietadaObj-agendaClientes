package com.wb.negocio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.wb.io.Entrada;
import com.wb.modelo.CPF;
import com.wb.modelo.RG;
import com.wb.modelo.Telefone;
import com.wb.modelo.Cliente;

public class EdicaoCliente extends Edicao{
    private Cliente cliente;

    public EdicaoCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public void editar() {
        System.out.println("\n MENU EDITAR CLIENTE");
        boolean execucao = true;
        while (execucao) {
            System.out.println("\n Qual atributo deseja editar?\n");
			System.out.println("1 - Nome");
			System.out.println("2 - Email");
			System.out.println("3 - CPF");
			System.out.println("4 - RG");
			System.out.println("5 - Telefone");
			System.out.println("6 - Gênero");
			System.out.println("7 - Data de Nascimento");
            System.out.println("0 - Sair");

			Entrada entrada = new Entrada();
			int operacao = entrada.receberNumeroInteiro();
            switch (operacao) {
            	case 0:
            		execucao = false;
            		break;
                case 1:
                    Entrada entradaNome = new Entrada();
                    System.out.print("\n Informe o novo nome: ");
                    String nome = entradaNome.receberTexto();
                    cliente.nome = nome;
                    System.out.println("\n✅ Nome editado\n");
                    break;
                case 2:
                    Entrada entradaEmail = new Entrada();
                    System.out.print("\nInforme o novo email: ");
                    String email = entradaEmail.receberTexto();
                    cliente.email = email;
                    System.out.println("\n✅ Email editado\n");
                    break;
                case 3:
                    Entrada entradaCpf = new Entrada();
                    System.out.print("\nInforme o novo CPF: ");
                    String valorCpf = entradaCpf.receberTexto();
                    CPF cpf = new CPF(valorCpf);
                    cliente.setCpf(cpf);
                    System.out.println("\n✅ CPF editado");
                    break;
                case 4:
                    Entrada entradaRg = new Entrada();
                    System.out.print("\nInforme o novo Rg: ");
                    String valorRg = entradaRg.receberTexto();
                    RG rg = new RG(valorRg);
                    cliente.setRg(rg);
                    System.out.println("\n✅ RG editado");
                    break;
                case 5:
                    Entrada entradaTelefoneDdd = new Entrada();
                    System.out.print("\nInforme o DDD do novo telefone: ");
                    String telefoneDdd = entradaTelefoneDdd.receberTexto();
                    Entrada entradaTelefoneNumero = new Entrada();
                    System.out.print("\nInforme o novo Numero de Telefone: ");
                    String telefoneNumero = entradaTelefoneNumero.receberTexto();
                    Telefone telefone = new Telefone(telefoneDdd, telefoneNumero);
                    cliente.setTelefone(telefone);
                    System.out.println("\n✅ Telefone editado");
                    break;
                case 6:
                    String genero = "";
                    boolean exec = true;
                    while (exec) {
                        System.out.println("\n Informe o novo Gênero: ");
                        System.out.print("1- Masculino");
                        System.out.print("2 - Feminino");
                        int operacaoGenero = entrada.receberNumeroInteiro();
                        switch (operacaoGenero) {
                            case 1:
                                genero = "Masculino";
                                exec = false;
                                break;
                            case 2:
                                genero = "Feminino";
                                exec = false;
                                break;
                            default:
                                break;
                        }
                    }
                    cliente.setGenero(genero);
                    System.out.println("\n✅ Gênero editado");
                    break;
                
                case 7:
                	Entrada entradaDataNascimento = new Entrada();
                    System.out.print("\nInforme a nova Data de Nascimento: ");
                    String dataNasc = entradaDataNascimento.receberTexto();
                    
                	DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            		LocalDate dataNascFormatada = LocalDate.parse(dataNasc, formato);
            		cliente.setDataNascimento(dataNascFormatada);
            		execucao = false;
                    break;
                default:
                    System.out.println("\n Operação não realizada\n");
            }
        }
    }
    
}
