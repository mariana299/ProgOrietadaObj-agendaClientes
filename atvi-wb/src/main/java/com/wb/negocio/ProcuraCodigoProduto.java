package com.wb.negocio;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Produto;

public class ProcuraCodigoProduto extends ProcuraProduto {
    
    private List<Produto> produtos;

    public ProcuraCodigoProduto(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public Produto procurar(){
        
        System.out.print("\n Insira o Código do Produto: ");
        Produto produtoProcurado = null;
        Entrada entrada = new Entrada();
        String codigo = entrada.receberTexto();

        for (Produto produto : produtos) {
            if (produto.getCodigo().equals(codigo)) {
            	produtoProcurado = produto;
            }
        }
        if (produtoProcurado == null) System.out.println("\nO Código informado não está cadastrado, verifique o código ou cadastre esse novo produto.");
    return produtoProcurado;
    }
}

