package aula2;

public class ListaEncadeada {
	
	public static void main(String[]args) {
		
		NO lista = new NO();
		System.out.println(lista);
		lista.dado=1;
		//nao tem sucessor, "null" é quando esta apontado para o "chao".
		lista.prox = null;
		System.out.println("\t dado: "+ lista.dado+"\t prox: " + lista.prox);
		
		// "novo" -> referencia para o novo NO 
		NO novo = new NO();
		System.out.println("novo" + novo);
		novo.dado = 2;
		novo.prox=null;
		
		lista.prox = novo;
		
		NO novo2 = new NO();
		
		System.out.println(novo2);
		
		novo2.dado=3;
		novo.prox = novo2;
		
		System.out.println("\tlista dado: "+ lista.dado+"\t prox: " + lista.prox);
		System.out.println("\t novo dado: "+ novo.dado+"\t prox: " + novo.prox);
		System.out.println("\tnovo2 dado: "+ novo2.dado+"\t prox: " + novo2.prox);
		
		
		
		
		
		
	}

}
