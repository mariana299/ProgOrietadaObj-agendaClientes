package com.wb.negocio;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;

public class ProcuraCpf extends ProcuraCliente {
    
    private List<Cliente> clientes;

    public ProcuraCpf(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public Cliente procurar(){
        
        System.out.print("\n Insira o CPF do cliente: ");
        Cliente clienteProcurado = null;
        Entrada entrada = new Entrada();
        String cpf = entrada.receberTexto();

        for (Cliente cliente : clientes) {
            if (cliente.getCpf().getValor().equals(cpf)) {
            	clienteProcurado = cliente;
            }
        }
        if (clienteProcurado == null) System.out.println("\nO CPF informado não está cadastrado, verifique o CPF ou cadastre esse CPF como um novo cliente.");
    return clienteProcurado;
    }
}
