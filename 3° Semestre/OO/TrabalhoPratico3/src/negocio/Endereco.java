package negocio;

public class Endereco {
	private int CEP;
	private int lote;
	private String nomeRuaAvenida;
	private String complemento;
	
	
	// -------------- Metodo construtor -------------
	public Endereco(int cep, int lote, String nomeRua, String complemento) {
		this.CEP = cep;
		this.lote = lote;
		this.nomeRuaAvenida = nomeRua;
		this.complemento = complemento;
	}
	
	@Override
	public String toString() {
		return "\n  CEP - "+ CEP +
				"\n  Lote - " + lote +
				"\n  Nome da rua/avenida - " + nomeRuaAvenida +
				"\n  Complemento - " + complemento ;
	}
	
	
	//------------------- metodos ------------------

	public void cadastrarEnd() {
	}
	
	public void editarEnd() {
	}
	
	public void excluirEnd() {
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