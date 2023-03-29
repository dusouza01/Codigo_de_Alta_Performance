package exercicio4;

import java.util.Scanner;

import pilhas.PilhaInt;

public class DecBin {

	public static void main(String[] args) {

		Scanner le = new Scanner(System.in);
		int decimal, resto;
		PilhaInt pilha = new PilhaInt();
		pilha.init();
		System.out.print("Informe valor em decimal: ");
		decimal = le.nextInt();
		while (decimal != 0) {
			resto = decimal % 2;
			pilha.push(resto);
			decimal = decimal / 2;
			}
		System.out.print("Valor em binario: ");
		pilha.esvazia();
		le.close();

	}

}
