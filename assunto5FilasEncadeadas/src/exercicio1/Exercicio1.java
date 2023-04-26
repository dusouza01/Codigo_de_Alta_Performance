package exercicio1;

import java.util.Scanner;

import filas.FilaInt;

public class Exercicio1 {
	
	public static void main(String[]args) {
		Scanner teclado = new Scanner(System.in);
		FilaInt fila = new FilaInt();
		fila.init();
		
		
		System.out.print("informe valor positivo (negativo encerra):");
		
		int valor = teclado.nextInt();
		
		while(valor>=0) {
			fila.enqueue(valor);
			System.out.print("Informe um valor positivo (negativo encerra):");
			valor = teclado.nextInt();
			
		}
		
		while(!fila.IsEmpty()) {
			System.out.println();
			System.out.println("Valor retirado: " + fila.dequeue());
		}
		teclado.close();
		
	}

}
