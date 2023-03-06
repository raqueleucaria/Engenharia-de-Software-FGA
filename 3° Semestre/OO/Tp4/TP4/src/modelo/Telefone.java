package modelo;
/**
 * Classe que define os atributos e metodos do objeto
 * @author Vera Lucia Bezerra da Silva e Raquel Eucaria
 * @version 1.0 (April 2022)
 */
public class Telefone {
	private int ddd;
	private int numero;
	/**
	 * Contrutor telefone
	 * @param ddd referente ao ddd de telefone
	 * @param numero referente ao numero de telefone
	 */
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