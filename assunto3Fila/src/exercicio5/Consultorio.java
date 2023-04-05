package exercicio5;

import java.util.Scanner;

import filas.FilaString;



public class Consultorio {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		FilaString filaPacientes = new FilaString();
		filaPacientes.init();
		int opcao;

		do {
			System.out.println("0.Encerrar");
			System.out.println("1.Inserir o nome do paciente na fila");
			System.out.println("2.Atender o próximo paciente");
			opcao = teclado.nextInt();
			switch (opcao) {
			case 0:
				// encerrar o atendimento//verificar o estado da fila pra ver se esta vazia
				if(filaPacientes.isEmpty()) {
					System.out.println("Encerrando o atendimento");
				}else {
					System.out.println("Ainda ha pacientes aguardando na fila(Nao posso encerrar)");
					opcao= -1;
				}
				break;
			case 1:
				// insere o RM
				teclado.nextLine();
				System.out.print("Nome do Paciente: ");
				String nome= teclado.nextLine();
				filaPacientes.enqueue(nome);
				break;
			case 2:
				// Situação para atender aluno
				if(filaPacientes.isEmpty()) {
					System.out.println("Não ha pacientes para atendimento!!");
				}else {
					System.out.println("Proximo pacientes a serem atendidos: "+ filaPacientes.dequeue());
				}
				break;

			default:
				System.out.println("Opção invalida");

			}
		} while (opcao != 0);
		teclado.close();
		
		
	}

}
