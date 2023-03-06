package modelo;

/**
 * Classe que define os atributos e metodos do objeto
 * @author Vera Lucia Bezerra da Silva e Raquel Eucaria
 * @version 1.0 (April 2022)
 */
public class Endereco {
	private int CEP;
	private int lote;
	private String nomeRuaAvenida;
	private String complemento;


	/**
	 * Contrutor Endereco
	 * @param cep referente
	 * @param lote refer
	 * @param nomeRua
	 * @param complemento
	 */
	public Endereco(int cep, int lote, String nomeRua, String complemento) {
		this.CEP = cep;
		this.lote = lote;
		this.nomeRuaAvenida = nomeRua;
		this.complemento = complemento;
	}
	
	@Override
	public String toString() {
		return "\n  CEP: "+ CEP +
				"\n  Lote: " + lote +
				"\n  Nome rua/avenida: " + nomeRuaAvenida +
				"\n  Complemento: " + complemento ;
	}

	// ---------------gets e sets ------------------
	public int getCEP() {
		return CEP;
	}

	public void setCEP(int cEP) {
		CEP = cEP;
	}

	public int getLote() {
		return lote;
	}

	public void setLote(int lote) {
		this.lote = lote;
	}

	public String getNomeRuaAvenida() {
		return nomeRuaAvenida;
	}

	public void setNomeRuaAvenida(String nomeRuaAvenida) {
		this.nomeRuaAvenida = nomeRuaAvenida;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
}