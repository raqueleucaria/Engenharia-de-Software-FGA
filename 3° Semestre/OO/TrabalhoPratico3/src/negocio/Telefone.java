package negocio;

public class Telefone {
	private int ddd;
	private int numero;
	
	// --------- Metodo construtor ----------
	public Telefone(int ddd, int numero) {
		this.ddd = ddd;
		this.numero = numero;
	}
	
	@Override
	public String toString() {
		return "(" + ddd + ") " + numero;
	}
	
	//-------------- metodos ----------------
	public void cadastrarTel() {
	}
	
	public void editarTel() {
	}
	
	public void excluirTel() {
	}

	
	// -----------gets e sets ------------
	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
}