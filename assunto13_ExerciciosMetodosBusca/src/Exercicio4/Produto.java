package Exercicio4;

public class Produto {

	int codigo;
	String produto, fabricante;
	double preco;
	
	public Produto(int codigo, String produto, String fabricante, double preco) {
		super();
		this.codigo = codigo;
		this.produto = produto;
		this.fabricante = fabricante;
		this.preco = preco;
	}
	public int getCodigo() {
		return codigo;
	}
	public String getProduto() {
		return produto;
	}
	
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", produto=" + produto + ", fabricante=" + fabricante + ", preco=" + preco
				+ "]";
	}
	
}
