package supermercado;

public class Produto {
	int codigo;
	String desc;
	double preco;
	
	
	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", desc=" + desc + ", preco=" + preco + "]";
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public double getPreco() {
		return preco;
	}


	public void setPreco(double preco) {
		this.preco = preco;
	}


	public Produto(int codigo, String desc, double preco) {
		super();
		this.codigo = codigo;
		this.desc = desc;
		this.preco = preco;
	}
	
	

}
