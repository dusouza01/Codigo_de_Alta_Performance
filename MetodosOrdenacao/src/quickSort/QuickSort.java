package quickSort;

import java.util.Random;


public class QuickSort {

	public static int comparacoes = 0;
	public static int trocas = 0;
	
	
	public static void main(String[] args) {

		Random gerador = new Random();
		final int N = 100;    // define o tamanho do vetor a ser ordenado


		//cria a estrutura de dados (vetor) com N elementos   gera vetor fora de ordem
		int vetor[] = new int[N];
		int i;
		System.out.println("Criando vetor com "+ N + " elementos: ");
		for(i = 0; i <N; i++) {
			vetor[i] = gerador.nextInt(50000); 
			//System.out.println(vetor[i]);
		}
		System.out.println();	

		System.out.println("Ordenando o vetor com Quicksort... ");
		quickSort(vetor,0, N-1);
		System.out.println("Numero de Trocas: "+ trocas);
		System.out.println("Numero de Comparacoes: "+ comparacoes);
	//	System.out.println("\n\nComparacoes realizadas: "+ comparacoes + "\n Trocas efetuadas: "+trocas);

		
		System.out.println("\n*********** Vetor Ordenado *********");
	//	for(i = 0; i <n; i++) 
	//		System.out.println(i +"\t"+ vetor[i]);

		System.out.println("Ordenando o vetor com Quicksort... ");
		quickSort(vetor,0, N-1);
		System.out.println("Numero de Trocas: "+ trocas);
		System.out.println("Numero de Comparacoes: "+ comparacoes);
	}

	public static int particiona (int x[], int li, int ls)
	{
		int pivo,abaixo,temp,acima;
		pivo=x[ls];
		acima=ls;
		abaixo=li;
		while(abaixo<acima)
		{
			comparacoes++;
			while(x[abaixo]<pivo && abaixo<ls) {
				abaixo++;
				comparacoes++;
			}
			while (x[acima]>=pivo && acima > abaixo) {
				comparacoes++;
				acima--;
			}
			if (abaixo<acima){
				trocas++;
				temp=x[abaixo];
				x[abaixo]=x[acima];
				x[acima]=temp;
			}
		}
		trocas++;
		x[ls]=x[acima];
		x[acima]=pivo;
		return acima;
	}


	public static void quickSort(int x[],int li,int ls)
	{
		int j;
		if (li<ls){
			j = particiona(x, li, ls);
			quickSort(x, li, j-1);
			quickSort(x, j+1,ls);
		}
	}


}
