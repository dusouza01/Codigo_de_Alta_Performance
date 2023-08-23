package aplicacao;

import arvores.ABBint;

public class Exercicio1 {

	public static void main(String[] args) {
		ABBint abb = new ABBint();
		
		abb.root = abb.inserir(abb.root, 6);
		abb.root = abb.inserir(abb.root, 10);
		abb.root = abb.inserir(abb.root, 7);
		abb.root = abb.inserir(abb.root, 4);
		System.out.println("Apresentando os elementos da ABB");
		abb.listaEmOrdem(abb.root);
		

	}

}
