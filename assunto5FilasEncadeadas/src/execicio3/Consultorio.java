package execicio3;

import java.util.Scanner;

import filas.FilaString;

public class Consultorio {

	public static void main(String[] args) {
		Scanner le = new Scanner(System.in);
		FilaString filaPacientes = new FilaString();
		filaPacientes.init();
		int opcao;
		do {
			System.out.println("0- Encerrar atendimento");
			System.out.println("1- Inserir paciente na fila");
			System.out.println("2- Atender o próximo paciente");
			opcao = le.nextInt();
			switch (opcao) {
			case 0:
				//encerra atendimento
				if (filaPacientes.isEmpty())
					System.out.println("Encerrado o atendimento");
				else {
					System.out.println("Ainda ha pacientes aguardando na fila");
					opcao = -1;
				}
				break;
			case 1:
				//insere
				le.nextLine();
				System.out.print("Nome do paciente: ");
				String nome = le.nextLine();
				filaPacientes.enqueue(nome);
				break;
			case 2:
				//atende 
				if (filaPacientes.isEmpty())
					System.out.println("Nao ha pacientes aguardando para atendimento");
				else
					System.out.println("Proximo paciente a ser atendido: "+ filaPacientes.dequeue());
				break;
			default:
				System.out.println("Opcao Invalida");
			}

		} while (opcao != 0);
		le.close();

	}

}
