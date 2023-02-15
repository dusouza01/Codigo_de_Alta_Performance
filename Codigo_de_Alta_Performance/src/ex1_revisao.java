import java.util.Scanner;

public class ex1_revisao {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int alunos;
		int rm[];
		double n1[];
		double n2[];
		double media[];
		double aprov[];
		

		System.out.print("Quantidade de alunos-->");
		alunos = teclado.nextInt();

		rm = new int[alunos];
		n1 = new double[alunos];
		n2 = new double[alunos];
		media = new double[alunos];
		aprov = new double[alunos];

		for (int i = 0; i < alunos; i++) {
			System.out.print("RM -->");
			rm[i] = teclado.nextInt();
			if (rm[i] < 0) {
				break;
			}

			System.out.println("Informe as notas!!!");
			System.out.print("Nota 1 -->");
			n1[i] = teclado.nextDouble();
			media[i] = 0;
			System.out.print("Nota 2 -->");
			n2[i] = teclado.nextDouble();

			media[i] += (n1[i] + n2[i]) / 2;

		}

		for (int i = 0; i < media.length; i++) {
			System.out.println("RM" + rm[i] + " Media-> " + media[i]);

		}
		System.out.println();
		System.out.println("Parabens,voces foram aprovados!!!!");
		
		for (int i = 0; i < aprov.length; i++) {
			if(media[i]>6) {
				aprov[i]=rm[i];
				System.out.println("RM"+aprov[i]);
				
			}
			
		}
		
	}

}
