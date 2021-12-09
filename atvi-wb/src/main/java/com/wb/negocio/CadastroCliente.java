package com.wb.negocio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.CPF;
import com.wb.modelo.Cliente;
import com.wb.modelo.RG;
import com.wb.modelo.Telefone;

public class CadastroCliente extends Cadastro {
	private List<Cliente> clientes;
	private Entrada entrada;
	

	public CadastroCliente(List<Cliente> clientes) {
		this.clientes = clientes;
		this.entrada = new Entrada();
	}
	

	@Override
	public void cadastrar() {
		System.out.println("\nInício do cadastro do cliente:");
		System.out.println("\nPor favor, informe o nome do cliente:");
		String nome = entrada.receberTexto();
		System.out.println("\nPor favor, informe o email do cliente:");
		String email = entrada.receberTexto();
		System.out.println("\nPor favor, informe o número do CPF:");
		String valorCpf = entrada.receberTexto();
		System.out.println("\nPor favor, informe o número do RG:");
		String valorRg = entrada.receberTexto();
		System.out.println("\nPor favor, informe a data de nascimento, no padrão dd/mm/yyyy:");
		String dataNasc = entrada.receberTexto();
		System.out.println("\nPor favor, informe o DDD do telefone:");
		String ddd = entrada.receberTexto();
		System.out.println("\nPor favor, o número do telefone:");
		String telefone = entrada.receberTexto();
		boolean execucao = true;
		String genero = null;
		while (execucao) {
			System.out.println("\nPor favor, insira o gênero");
			System.out.println("1 - Feminino");
			System.out.println("2 - Masculino");
			Entrada entrada = new Entrada();
			int operacao = entrada.receberNumeroInteiro();
			switch (operacao) {
			case 1:
				execucao = false;
				genero = "Feminino";
				break;
			case 2:
				execucao = false;
				genero = "Masculino";
				break;
			default:
				System.out.println("\nOperação não entendida");
				break;
			}
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataNascFormatada = LocalDate.parse(dataNasc, formato);
		
		Cliente cliente = new Cliente(nome, email, new CPF(valorCpf), new RG(valorRg), genero, dataNascFormatada, new Telefone(ddd, telefone));
		this.clientes.add(cliente);
		System.out.println("\n✅Cliente adicionado no sistema.");
		}
	}
}