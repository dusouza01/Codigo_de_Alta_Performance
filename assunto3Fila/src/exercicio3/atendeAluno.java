package exercicio3;


import java.util.Scanner;

import filas.FilaInt;

public class atendeAluno {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		FilaInt filaAlunos=new FilaInt();
		int rm,opcao;
		
		do {
			System.out.println("0.Encerrar");
			System.out.println("1.Inserir aluno na fila");
			System.out.println("2.Atender o próximo aluno");
			opcao=teclado.nextInt();
			switch(opcao) {
			case 0:
				//encerra
				break;
			case 1:
				//insere
				break;
			case 2:
				//atende
				break;
				
			default:
			
			
			
			
			
			}
		}while(opcao!=0);


		
		
	}

}
