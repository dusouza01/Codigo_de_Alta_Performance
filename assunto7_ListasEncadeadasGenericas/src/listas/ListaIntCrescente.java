package listas;

public class ListaIntCrescente {
	private class NO {
		int dado;
		NO prox;

	}

	private NO lista = null;

	public void insere(int elem) {
		// alocar espaco para o NO
		NO novo = new NO();
		novo.dado = elem;
		if (lista == null) {
			novo.prox = null;
			lista = novo;
		} else {
			if (novo.dado < lista.dado) {
				novo.prox = lista;
				lista = novo;
			} else {
				// comeca referenciando o mesmo NO que lista
				NO aux = lista;
				boolean achou = false;
				// ou (achou == false)
				while (aux.prox != null && !achou) {
					if (aux.prox.dado < novo.dado) {
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

	public boolean remove(int valor) {
		boolean achou = false;
		if (lista != null) {
			if (valor == lista.dado) {
				lista = lista.prox;
			} else {
				NO aux = lista;

				while (aux.prox != null && !achou) {
					if (aux.prox.dado != valor) {
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
