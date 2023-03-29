package filas;

public class FilaInt {

	public final int N = 3;

	int dados[] = new int[N];
	int ini,fim,cont;
	
	public void init() {
		ini=fim=0;
		cont=0;
		
	}
	public boolean isEmpty() {
		if(cont==0) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isFull() {
		if(cont==N) {
			return true;
		}else {
			return false;
		}
	}
	
	public void enqueue(int elem) {
		if(isFull()) {
			System.out.println("Fila cheia");
			
		}else {
			dados[fim]=elem;
			fim=(fim+1)% N;
			cont=cont+1;
		}
		
	}
	public int dequeue() {
		int elem=dados[ini];
		ini = (ini+1)%N;
		cont=cont-1;
		return elem;
		
	}
	

}
