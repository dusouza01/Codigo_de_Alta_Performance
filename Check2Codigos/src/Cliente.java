import java.util.List;

public class Cliente {
	String nome;
	String cpfCnpj;
	int numeroConta;
	String tipoConta;
	double saldo;

	public Cliente(String nome, String cpfCnpj, int numeroConta, String tipoConta, double saldo) {

		this.nome = nome;
		this.cpfCnpj = cpfCnpj;
		this.numeroConta = numeroConta;
		this.tipoConta = tipoConta;
		this.saldo = saldo;

	}

}

class No {
	Cliente cliente;
	No esq, dir;

	public No(Cliente cliente) {
		this.cliente = cliente;
		this.esq = null;
		this.dir = null;
	}
}

class ArvoreBinaria {
	No root;

	public ArvoreBinaria() {
		this.root = null;
	}

	public void inserir(Cliente cliente) {
		this.root = inserirRec(this.root, cliente);
	}

	private No inserirRec(No root, Cliente cliente) {
		if (root == null) {
			root = new No(cliente);
			return root;
		}

		if (cliente.saldo < root.cliente.saldo) {
			root.esq = inserirRec(root.esq, cliente);
		} else if (cliente.saldo > root.cliente.saldo) {
			root.dir = inserirRec(root.dir, cliente);
		}

		return root;
	}

	public void remover(Cliente cliente) {
		this.root = removerRec(this.root, cliente);
	}

	private No removerRec(No root, Cliente cliente) {
		if (root == null) {
			return root;
		}

		if (cliente.saldo < root.cliente.saldo) {
			root.esq = removerRec(root.esq, cliente);
		} else if (cliente.saldo > root.cliente.saldo) {
			root.dir = removerRec(root.dir, cliente);
		} else {
			// Nó com o valor a ser removido encontrado
			if (root.esq == null) {
				return root.dir;
			} else if (root.dir == null) {
				return root.esq;
			}

			// Nó com dois filhos, encontrar o sucessor in-order e substituir o nó a ser
			// removido
			root.cliente = encontrarMinimo(root.dir).cliente;

			// Remover o sucessor in-order
			root.dir = removerRec(root.dir, root.cliente);
		}
		return root;
	}

	private No encontrarMinimo(No root) {
		No atual = root;
		while (atual.esq != null) {
			atual = atual.esq;
		}
		return atual;
	}

	public void gerarListaClientesAptos(No root, double saldoMinimo, List<Cliente> listaClientesAptos) {
		if (root != null) {
			gerarListaClientesAptos(root.dir, saldoMinimo, listaClientesAptos); // Percorrer a subárvore direita
																				// primeiro
			if (root.cliente.saldo >= saldoMinimo) {
				listaClientesAptos.add(root.cliente); // Adicionar cliente apto à lista
			}
			gerarListaClientesAptos(root.esq, saldoMinimo, listaClientesAptos); // Percorrer a subárvore esquerda
		}
	}

	public void ordem(No root) {
		if (root != null) {
			ordem(root.esq);
			System.out.println("Nome: " + root.cliente.nome + ", Saldo: " + root.cliente.saldo);
			ordem(root.dir);
		}
	}

	public void pesquisaCPF(No root, String cpfCnpj) {
		if (root != null) {
			pesquisaCPF(root.esq, cpfCnpj);
			if (root.cliente.cpfCnpj.equals(cpfCnpj)) {
				System.out.println("Nome: " + root.cliente.nome);
				System.out.println("CPF/CNPJ: " + root.cliente.cpfCnpj);
				System.out.println("Número da Conta: " + root.cliente.numeroConta);
				System.out.println("Tipo de Conta: " + root.cliente.tipoConta);
				System.out.println("Saldo em Aplicações: " + root.cliente.saldo);
			}
			pesquisaCPF(root.dir, cpfCnpj);
		}
	}

	public void atualizaPeloNumeroConta(No root, int numeroConta, double novoSaldo) {
		if (root != null) {
			atualizaPeloNumeroConta(root.esq, numeroConta, novoSaldo);
			if (root.cliente.numeroConta == numeroConta) {
				System.out.println("Informações do cliente antes da atualização:");
				System.out.println("Nome: " + root.cliente.nome);
				System.out.println("CPF/CNPJ: " + root.cliente.cpfCnpj);
				System.out.println("Número da Conta: " + root.cliente.numeroConta);
				System.out.println("Tipo de Conta: " + root.cliente.tipoConta);
				System.out.println("Saldo em Aplicações: " + root.cliente.saldo);
				root.cliente.saldo = novoSaldo;
				System.out.println("Informações do cliente após a atualização:");
				System.out.println("Nome: " + root.cliente.nome);
				System.out.println("CPF/CNPJ: " + root.cliente.cpfCnpj);
				System.out.println("Número da Conta: " + root.cliente.numeroConta);
				System.out.println("Tipo de Conta: " + root.cliente.tipoConta);
				System.out.println("Saldo em Aplicações: " + root.cliente.saldo);
			}
			atualizaPeloNumeroConta(root.dir, numeroConta, novoSaldo);
		}
	}

	public int contaNo(No root) {
		if (root == null) {
			return 0;
		}
		return 1 + contaNo(root.esq) + contaNo(root.dir);
	}

	public int contagemAcima(No root, double balance) {
		if (root == null) {
			return 0;
		}
		if (root.cliente.saldo > balance) {
			return 1 + contagemAcima(root.esq, balance) + contagemAcima(root.dir, balance);
		} else {
			return contagemAcima(root.esq, balance) + contagemAcima(root.dir, balance);
		}
	}

}
