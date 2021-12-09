package com.wb.negocio;


import com.wb.io.Entrada;
import com.wb.modelo.Empresa;
import com.wb.modelo.Servico;

public class MenuServico extends Execucao{
	private Empresa empresa;

	public MenuServico(Empresa empresa) {
		this.empresa = empresa;
		
	}

	@Override
	public void executar() {
		
		boolean execucaoServicos = true;
		while (execucaoServicos) {
			System.out.println("\n\n💅MENU SERVIÇOS💇👸");				
			System.out.println("\nEscolha a operação a ser realizada:");
			System.out.println("1 - ➕Cadastrar Novo Serviço");
			System.out.println("2 - 🧐Listar Serviços Cadastrados");
			System.out.println("3 - 📝Editar Serviço");
			System.out.println("4 - ❌Deletar Serviço");
			System.out.println("0 - 🔙Voltar ao Menu Principal");
			
			Entrada entradaServico = new Entrada();
			int operacaoServico = entradaServico.receberNumeroInteiro();
			
			switch (operacaoServico) {
				case 0:
					execucaoServicos = false;
					break;
				case 1:
					Cadastro cadastroServico = new CadastroServico(empresa.getServicos());
					cadastroServico.cadastrar();
					break;
				case 2:
					Listagem listagemServico = new ListarTodosServicos(empresa.getServicos());
					listagemServico.listar();
					break;
				case 3:
					ProcuraServico procuraServicoEdit = new ProcuraCodigoServico(empresa.getServicos());
					Servico servicoProcuradoEdit = procuraServicoEdit.procurar();
					if (servicoProcuradoEdit != null) {
						Edicao edicaoServico = new EdicaoServico(servicoProcuradoEdit);
						edicaoServico.editar();
					}
					break;
				case 4:
					ProcuraServico procuraServicoRemove = new ProcuraCodigoServico(empresa.getServicos());
					Servico servicoProcuradoRemove = procuraServicoRemove.procurar();
					if (servicoProcuradoRemove != null) {
						empresa.getServicos().remove(servicoProcuradoRemove);
						System.out.println("\n✅ Servico removido");
					}
					break;
			}
			
		}

	}

}
