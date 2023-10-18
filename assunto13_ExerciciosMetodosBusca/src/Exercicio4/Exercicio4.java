package Exercicio4;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Exercicio4 {

	public static void main(String[] args) {
		Scanner le = new Scanner(System.in);
		Produto p1 = new Produto(623, "parafuso", "ABC", 0.75);
		Produto p2 = new Produto(133, "prego", "ABC", 0.5);
		Produto p3 = new Produto(686, "martelo", "XYZ", 34.75);
		Produto p4 = new Produto(543, "prego", "XYZ", 0.25);
		Produto p5 = new Produto(461, "alicate", "W2M", 22.50);

		Produto loja[] = { p1, p2, p3, p4, p5 };

		int opcao;
		do {
			System.out.println(" 0 - encerrar");
			System.out.println(" 1 - pesquisar pelo fabricante");
			System.out.println(" 2 - pesquisar pelo codigo");
			opcao = le.nextInt();
			switch (opcao) {
			case 0:
				System.out.println(" Fechando lojinha...");
				break;
			case 1:
				for (Produto p : loja)
					System.out.println(p.getFabricante());
				System.out.print("Digite fabricante a ser pesquisado: ");
				String fabricante = le.next();
				Produto pesq[] = new Produto[loja.length];
				int ne = buscaSequencialExaustiva(loja, fabricante, pesq);
				if (ne == 0) {
					System.out.println("Nao ha produtos desse fabricante.");
				} else {
					System.out.println("Produtos encontrados");
					for (int i = 0; i < ne; i++) {
						System.out.println(pesq[i]);
					}
				}

				break;
			case 2:
				System.out.println("\n******** Procura por codigo (Sequencial) *********");
				System.out.println("\t Lista de codigos dos produtos\n");
				for (Produto p : loja)
					System.out.print("\t" + p.getCodigo());
				System.out.print("\nDigite o codigo do produto a ser pesquisado: ");
				int codProc = le.nextInt();
				int pos = buscaSequencial(loja, codProc);

				break;
			default:
				System.out.println("Opcao invalida");
			}
		} while (opcao != 0);

	}

	public static int buscaSequencialExaustiva(Produto bd[], String chave, Produto encontrados[]) {
		int i, ne = 0;
		int num = bd.length;
		for (i = 0; i < num; i++) {
			if (bd[i].getFabricante().compareToIgnoreCase(chave) == 0) {
				encontrados[ne] = bd[i];
				/* armazena registro da posição em que a chave foi encontrada */
				ne++;
			}
		}
		return ne;/* registros com a chave procurada */
	}

	public static int buscaSequencial(Produto baseDados[], int chaveproc) {
		int pos = -1;
		for (int i = 0; i < baseDados.length && pos == -1; i++) {
			if ((baseDados[i].getCodigo() == chaveproc))
				pos = i;

		}
		return pos;
	}

}
