package com.wb.negocio;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Servico;

public class ProcuraCodigoServico extends ProcuraServico {
    
    private List<Servico> servicos;

    public ProcuraCodigoServico(List<Servico> servicos) {
        this.servicos = servicos;
    }

    @Override
    public Servico procurar(){
        
        System.out.print("\n Insira o Código do Serviço: ");
        Servico servicoProcurado = null;
        Entrada entrada = new Entrada();
        String codigo = entrada.receberTexto();

        for (Servico servico : servicos) {
            if (servico.getCodigo().equals(codigo)) {
            	servicoProcurado = servico;
            }
        }
        if (servicoProcurado == null) System.out.println("\nO Código informado não está cadastrado, verifique o código ou cadastre esse novo serviço.");
    return servicoProcurado;
    }
}

