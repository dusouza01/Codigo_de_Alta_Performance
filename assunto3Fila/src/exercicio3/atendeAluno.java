package exercicio3;


//-----------------!!!--------------
//LEMBRAR DE FAZER O EX4
//-----------------!!!-------------
import java.util.Scanner;

import filas.FilaInt;

public class atendeAluno {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		FilaInt filaAlunos = new FilaInt();
		filaAlunos.init();
		int rm, opcao;

		do {
			System.out.println("0.Encerrar");
			System.out.println("1.Inserir aluno na fila");
			System.out.println("2.Atender o próximo aluno");
			opcao = teclado.nextInt();
			switch (opcao) {
			case 0:
				// encerrar o atendimento//verificar o estado da fila pra ver se esta vazia
				if(filaAlunos.isEmpty()) {
					System.out.println("Encerrando o atendimento");
				}else {
					System.out.println("Ainda ha alunos aguardando na fila(Nao posso encerrar)");
					opcao= -1;
				}
				break;
			case 1:
				// insere o RM
				System.out.print("Informe o RM: ");
				rm = teclado.nextInt();
				filaAlunos.enqueue(rm);
				break;
			case 2:
				// Situação para atender aluno
				if(filaAlunos.isEmpty()) {
					System.out.println("Não ha alunos para atendimento!!");
				}else {
					System.out.println("Proximo aluno a ser atendido: "+ filaAlunos.dequeue());
				}
				break;

			default:
				System.out.println("Opção invalida");

			}
		} while (opcao != 0);
		teclado.close();

	}

}
