package com.wb.negocio;


import com.wb.io.Entrada;
import com.wb.modelo.Cliente;
import com.wb.modelo.Empresa;

public class MenuCliente extends Execucao{
	private Empresa empresa;

	public MenuCliente(Empresa empresa) {
		this.empresa = empresa;
		
	}

	@Override
	public void executar() {
		
		boolean execucaoClientes = true;
		while (execucaoClientes) {
			System.out.println("\n\n🧝MENU CLIENTES 🧖");
			System.out.println("\nEscolha a operação a ser realizada:");
			System.out.println("1 - ➕Cadastrar Novo Cliente");
			System.out.println("2 - 🧐Listar Clientes Cadastrados");
			System.out.println("3 - 📝Editar Cliente");
			System.out.println("4 - ❌Deletar Cliente");
			System.out.println("0 - 🔙Voltar ao Menu Principal");
			
			Entrada entradaCliente = new Entrada();
			int operacaoCliente = entradaCliente.receberNumeroInteiro();
			
			switch (operacaoCliente) {
				case 0:
					execucaoClientes = false;
					break;
				case 1:
					Cadastro cadastroCliente = new CadastroCliente(empresa.getClientes());
					cadastroCliente.cadastrar();
					break;
				case 2:
					Listagem listagemCliente = new ListarTodosClientes(empresa.getClientes());
					listagemCliente.listar();
					break;
				case 3:
					ProcuraCliente procuraClienteEdit = new ProcuraCpf(empresa.getClientes());
					Cliente clienteProcuradoEdit = procuraClienteEdit.procurar();
					if (clienteProcuradoEdit != null) {
						Edicao edicaoCliente = new EdicaoCliente(clienteProcuradoEdit);
						edicaoCliente.editar();
					}
					break;
				case 4:
					ProcuraCliente procuraClienteRemove = new ProcuraCpf(empresa.getClientes());
					Cliente clienteProcuradoRemove = procuraClienteRemove.procurar();
					if (clienteProcuradoRemove != null) {
						empresa.getClientes().remove(clienteProcuradoRemove);
						System.out.println("\n✅ Cliente removido");
					}
					break;
			}
		}

	}

}
