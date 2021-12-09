package com.wb.io;

import java.util.Scanner;

public class Entrada {
	private Scanner leitor;

	public Entrada() {
		leitor = new Scanner(System.in);
	}

	public double receberNumeroDouble() {
		double numero = leitor.nextDouble();
		return numero;
	}

	public int receberNumeroInteiro() {
		int numero;
		 while (!leitor.hasNextInt()) {
		        System.out.println("Entrada não é um número! \nPor favor, digite um dos números listados acima para selecionar a opção desejada.");
		        leitor.next();
		    }
		    numero = leitor.nextInt();
		return numero;
	}

	public String receberTexto() {
		String texto = leitor.nextLine();
		return texto;
	}

	@Override
	protected void finalize() throws Throwable {
		leitor.close();
	}
}