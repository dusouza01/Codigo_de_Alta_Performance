package teste;

import java.util.Scanner;

import listas.ListaIntCrescente;

public class MainTeste {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		ListaIntCrescente lista = new ListaIntCrescente();

		System.out.print("Informe um valor positivo para inserir ou negativo para encerrar: ");
		int valor = teclado.nextInt();
		while (valor >= 0) {
			lista.insere(valor);
			lista.apresenta();
			System.out.println("Informe um valor positivo para inserir ou negativo para encerrar: ");
			valor = teclado.nextInt();

		}

		System.out.print("\n\nInforme um valor positivo para remover ou negativo para encerrar: ");
		valor = teclado.nextInt();
		while (valor >= 0) {
			if (!lista.remove(valor)) {
				System.out.println("Valor nao encontrado na lista ");

			} else {
				lista.apresenta();
			}

			lista.remove(valor);
			lista.apresenta();
			System.out.println("Informe um valor positivo para remover ou negativo para encerrar: ");
			valor = teclado.nextInt();

		}

		teclado.close();
	}

}
