package arvores;

public class ABBint {

	private class ARVORE {
		int dado;
		ARVORE esq, dir;
	}

	public ARVORE root = null;

	public ARVORE inserir(ARVORE p, int info) {

		if (p == null) {
			p = new ARVORE();
			p.dado = info;
			p.esq = null;
			p.dir = null;
		} else if (info < p.dado)
			p.esq = inserir(p.esq, info);
		else
			p.dir = inserir(p.dir, info);
		return p;
	}

	public int contaNos(ARVORE p, int cont) {
		if (p != null) {
			cont++;
			cont = contaNos(p.esq, cont);
			cont = contaNos(p.dir, cont);
		}
		return cont;
	}

	public void listaEmOrdem(ARVORE p) {
		if (p != null) {
			listaEmOrdem(p.esq);
			System.out.print(" " + p.dado);
			listaEmOrdem(p.dir);
		}
	}

	public boolean consulta(ARVORE p, int info) {
		if (p != null) {
			if (info == p.dado) {
				return true;
			} else {
				if (info < p.dado) {
					return consulta(p.esq, info);
				} else {
					return consulta(p.dir, info);
				}
			}
		}
		return false;
	}

	public int contaConsulta(ARVORE p, int info, int cont) {
		if (p != null) {
			cont++;
			if (info == p.dado) {
				return cont;
			} else {
				if (info < p.dado) {
					cont = contaConsulta(p.esq, info, cont);
				} else {
					cont = contaConsulta(p.dir, info, cont);
				}
			}
		}
		return cont;
	}

	public ARVORE removeValor(ARVORE p, int info) {
		if (p != null) {
			if (info == p.dado) {
				if (p.esq == null && p.dir == null)
					return null;
				if (p.esq == null) {
					return p.dir;
				} else {
					if (p.dir == null) {
						return p.esq;
					} else {
						ARVORE aux, ref;
						ref = p.dir;
						aux = p.dir;
						while (aux.esq != null)
							aux = aux.esq;
						aux.esq = p.esq;
						return ref;
					}
				}
			} else {
				if (info < p.dado)
					p.esq = removeValor(p.esq, info);
				else
					p.dir = removeValor(p.dir, info);
			}
		}
		return p;
	}

}
