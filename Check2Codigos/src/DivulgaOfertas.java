import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DivulgaOfertas {

	public static void main(String[] args) {

		// NOME: Vitor da Silva Avellar RM 93495
		// NOME: Osvaldo Sandoli José RM 93220
		// NOME: Lucas Dias Morosini RM 94523
		// NOME: Eduardo de Souza Oliveira RM 94251

		Scanner le = new Scanner(System.in);

		int opcao, op, numeroConta;
		String nome, cpfCnpj;
		String tipoConta = null;
		double saldo;
		ArvoreBinaria clientePessoaFisica = new ArvoreBinaria();
		ArvoreBinaria clientePessoaJuridica = new ArvoreBinaria();

		do {
			System.out.println(" 0 - Encerrar o programa");
			System.out.println(" 1 - Inscrição cliente");
			System.out.println(" 2 - Oferta de novo serviço e/ou aplicação");
			System.out.println(" 3 - Entrar no Submenu");
			opcao = le.nextInt();
			switch (opcao) {
			case 1:
				System.out.print("Digite nome: ");
				nome = le.next();
				System.out.print("Digite cpf: ");
				cpfCnpj = le.next();
				System.out.print("Digite número da conta: ");
				numeroConta = le.nextInt();
				do {
					System.out.print("Digite 1- Pessoa Física 2- Pessoa Jurídica: ");
					op = le.nextInt();
					switch (op) {
					case 1:
						tipoConta = "Física";
						break;
					case 2:
						tipoConta = "Jurídica";
						break;
					default:
						System.out.println("Opção inválida ");
						op = -1;
					}
				} while (op == -1);
				System.out.print("Informe saldo em aplicações R$: ");
				saldo = le.nextDouble();
				if (tipoConta.equals("Física")) {
					clientePessoaFisica.inserir(new Cliente(nome, cpfCnpj, numeroConta, tipoConta, saldo));
				} else if (tipoConta.equals("Jurídica")) {
					clientePessoaJuridica.inserir(new Cliente(nome, cpfCnpj, numeroConta, tipoConta, saldo));
				}
				break;
			case 2:
				System.out.print("Qual tipo de conta a oferta se destina? ");
				do {
					System.out.print("Digite 1- Pessoa Física 2- Pessoa Jurídica: ");
					op = le.nextInt();
					switch (op) {
					case 1:
						tipoConta = "Física";
						break;
					case 2:
						tipoConta = "Jurídica";
						break;
					default:
						System.out.println("Opção inválida ");
						op = -1;
					}
				} while (op == -1);
				System.out.print("Qual o valor de saldo mínimo exigido: R$ ");
				double saldoMinimo = le.nextDouble();

				ArvoreBinaria clientesAptos = null;
				if (tipoConta.equals("Física")) {
					clientesAptos = clientePessoaFisica;
				} else if (tipoConta.equals("Jurídica")) {
					clientesAptos = clientePessoaJuridica;
				}

				// Gerar lista de clientes aptos em ordem decrescente de saldo
				// Fazendo um percurso in-order reverso
				List<Cliente> listaClientesAptos = new ArrayList<>();
				gerarListaClientesAptos(clientesAptos.root, saldoMinimo, listaClientesAptos);

				// Retirar e processar clientes
				while (!listaClientesAptos.isEmpty()) {
					Cliente clienteSelecionado = listaClientesAptos.get(0);
					System.out.println("Contatar cliente: " + clienteSelecionado.nome);
					System.out.print("O cliente aceita a oferta? (Digite 'sim' ou 'nao'): ");
					String resposta = le.next();
					if (resposta.equalsIgnoreCase("sim")) {
						System.out.println("Oferta aceita pelo cliente: " + clienteSelecionado.nome);
						// Remover o cliente da árvore
						if (clientesAptos == clientePessoaFisica) {
							clientePessoaFisica.remover(clienteSelecionado);
						} else if (clientesAptos == clientePessoaJuridica) {
							clientePessoaJuridica.remover(clienteSelecionado);
						}
					} else if (resposta.equalsIgnoreCase("nao")) {
						System.out.println("Oferta recusada pelo cliente: " + clienteSelecionado.nome);
					} else {
						System.out.println("Resposta inválida.");
					}
					listaClientesAptos.remove(0); // Remove o cliente processado
				}
				break;

			case 3:
				System.out.println("Submenu: ");
				System.out.println("1 - Consulta cliente buscando pelo CPF ou CNPJ");
				System.out.println("2 - Atualização do saldo do cliente buscando pelo número da conta");
				System.out.println("3 - Apresenta a quantidade de clientes armazenados na ABB");
				System.out
						.println("4 - Apresenta a quantidade de clientes com saldo acima de um valor a ser consultado");
				System.out.println("5 - Voltar ao menu principal");
				int subOpcao = le.nextInt();
				switch (subOpcao) {
				case 1:
					System.out.print("Digite o CPF ou CNPJ do cliente: ");
					String cpfCnpjSearch = le.next();
					if (clientePessoaFisica.root != null) {
						System.out.println("Informações do cliente buscado: ");
						clientePessoaFisica.pesquisaCPF(clientePessoaFisica.root, cpfCnpjSearch);
					} else if (clientePessoaJuridica.root != null) {
						System.out.println("Informações do cliente buscado: ");
						clientePessoaJuridica.pesquisaCPF(clientePessoaJuridica.root, cpfCnpjSearch);
					} else {
						System.out.println("Nenhum cliente cadastrado.");
					}
					break;
				case 2:
					System.out.print("Digite o número da conta do cliente: ");
					int numeroContaSearch = le.nextInt();
					System.out.print("Digite o novo saldo: ");
					double newSaldo = le.nextDouble();
					if (clientePessoaFisica.root != null) {
						clientePessoaFisica.atualizaPeloNumeroConta(clientePessoaFisica.root, numeroContaSearch,
								newSaldo);
					} else if (clientePessoaJuridica.root != null) {
						clientePessoaJuridica.atualizaPeloNumeroConta(clientePessoaJuridica.root, numeroContaSearch,
								newSaldo);
					} else {
						System.out.println("Nenhum cliente cadastrado.");
					}
					break;
				case 3:
					System.out.println("Quantidade de clientes armazenados na ABB de pessoa física: "
							+ clientePessoaFisica.contaNo(clientePessoaFisica.root));
					System.out.println("Quantidade de clientes armazenados na ABB de pessoa jurídica: "
							+ clientePessoaJuridica.contaNo(clientePessoaJuridica.root));
					break;
				case 4:
					System.out.print("Digite o valor a ser consultado: ");
					double balance = le.nextDouble();
					System.out.println(
							"Quantidade de clientes com saldo acima de " + balance + " na ABB de pessoa física: "
									+ clientePessoaFisica.contagemAcima(clientePessoaFisica.root, balance));
					System.out.println(
							"Quantidade de clientes com saldo acima de " + balance + " na ABB de pessoa jurídica: "
									+ clientePessoaJuridica.contagemAcima(clientePessoaJuridica.root, balance));
					break;
				case 5:
					break;
				default:
					System.out.println("Opção inválida.");
					break;
				}
				break;
			}
		} while (opcao != 0);

		System.out.println("Clientes que sobraram no armazenamento: ");
		mostraClientes(clientePessoaJuridica, clientePessoaFisica);
		le.close();
	}
	
	public static void mostraClientes(ArvoreBinaria clientePessoaJuridica, ArvoreBinaria clientePessoaFisica) {
	    System.out.println("Da ABB de Pessoa Física:");
	    if (clientePessoaFisica.root != null) {
	        clientePessoaFisica.ordem(clientePessoaFisica.root);
	    } else {
	        System.out.println("Nenhum cliente cadastrado na ABB de Pessoa Física.");
	    }
	    
	    System.out.println("\nDa ABB de Pessoa Jurídica:");
	    if (clientePessoaJuridica.root != null) {
	        clientePessoaJuridica.ordem(clientePessoaJuridica.root);
	    } else {
	        System.out.println("Nenhum cliente cadastrado na ABB de Pessoa Jurídica.");
	    }
	}

	public static void gerarListaClientesAptos(No root, double saldoMinimo, List<Cliente> listaClientesAptos) {
		if (root != null) {
			gerarListaClientesAptos(root.dir, saldoMinimo, listaClientesAptos); // Percorrer a subárvore direita
																				// primeiro
			if (root.cliente.saldo >= saldoMinimo) {
				listaClientesAptos.add(root.cliente); // Adicionar cliente apto à lista
			}
			gerarListaClientesAptos(root.esq, saldoMinimo, listaClientesAptos); // Percorrer a subárvore esquerda
		}
	}
}