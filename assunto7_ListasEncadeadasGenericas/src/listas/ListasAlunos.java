package listas;

import entidades.Aluno;

public class ListasAlunos {
	private class NO {
		Aluno dado;
		NO prox;

	}

	private NO lista = null;

	public void insere(Aluno elem) {
		// alocar espaco para o NO
		NO novo = new NO();
		novo.dado = elem;
		if (lista == null) {
			novo.prox = null;
			lista = novo;
		} else {
			if (novo.dado.getRm() < lista.dado.getMedia()) {
				novo.prox = lista;
				lista = novo;
			} else {
				// comeca referenciando o mesmo NO que lista
				NO aux = lista;
				boolean achou = false;
				// ou (achou == false)
				while (aux.prox != null && !achou) {
					if (aux.prox.dado.getRm() < novo.dado.getRm()) {
						aux = aux.prox;
					} else {
						achou = true;
					}
				}
				novo.prox = aux.prox;
				aux.prox = novo;

			}
		}
	}

	public boolean remove(int rm) {
		boolean achou = false;
		if (lista != null) {
			if (rm == lista.dado.getRm()) {
				lista = lista.prox;
			} else {
				NO aux = lista;

				while (aux.prox != null && !achou) {
					if (aux.prox.dado.getRm() != rm) {
						aux = aux.prox;
					} else {
						achou = true;
						// pega o sucessor do NO que vai ser retirado
						aux.prox = aux.prox.prox;
					}

				}
			}
		}
		return achou;
	}

	public void apresenta() {
		NO aux = lista;
		System.out.println("\n *** Lista ***");
		while (aux != null) {
			System.out.println("\t" + aux.dado);
			aux = aux.prox;
		}

	}
}
