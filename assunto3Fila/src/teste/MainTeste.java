package teste;

import filas.FilaInt;

public class MainTeste {

	public static void main(String[] args) {

		FilaInt fila = new FilaInt();
		fila.init();

		fila.enqueue(66);

		fila.enqueue(17);

		fila.enqueue(23);
		fila.enqueue(30);

		if (fila.isEmpty()) {
			System.out.println("Fila vazia!!");
		} else {
			System.out.println("Valor retirado: " + fila.dequeue());
		}

		if (fila.isEmpty()) {
			System.out.println("Fila vazia!!");
		} else {
			System.out.println("Valor retirado: " + fila.dequeue());

		}
		
		

	}

}
