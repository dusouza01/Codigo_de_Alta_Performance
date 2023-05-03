package exercicio1;

import java.util.Scanner;

import filas.FilaInt;

public class Exercicio1 {

	public static void main(String[] args) {
		Scanner le = new Scanner (System.in);
		FilaInt fila = new FilaInt();
		fila.init();
		
		System.out.print("Informe valor positivo (negativo encerra): ");
		int valor = le.nextInt();
		while (valor>=0) {
			fila.enqueue(valor);
			System.out.print("Informe valor positivo (negativo encerra): ");
			valor = le.nextInt();
		}
		
		while (!fila.isEmpty()) {
			System.out.println("Valor retirado: "+ fila.dequeue());
		}
		le.close();

	}

}
