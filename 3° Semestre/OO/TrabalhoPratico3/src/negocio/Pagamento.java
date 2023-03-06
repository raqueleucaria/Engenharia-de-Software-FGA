package negocio;

public class Pagamento {
	private int numeroCartao;
	private int cvc;
	private int validade;

	// -------------- Metodo construtor ----------
	public Pagamento(int numeroCartao, int cvc, int validade) {
		this.numeroCartao = numeroCartao;
		this.cvc = cvc;
		this.validade = validade;
	}

	@Override
	public String toString() {
		return "\n  Número do Cartão - " + numeroCartao +
				"\n  cvc - " + cvc +
				"\n  Validade - " + validade;
	}

	//----------------- metodos ------------------
	public void incluirPagamento() {
	}

	public void excluirPagamento() {
	}

	public int getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(int numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public int getCvc() {
		return cvc;
	}

	public void setCvc(int cvc) {
		this.cvc = cvc;
	}

	public int getValidade() {
		return validade;
	}

	public void setValidade(int validade) {
		this.validade = validade;
	}
	
	
}
