package modelo;

import java.util.Date;

/**
 * Classe que define os atributos e metodos do objeto
 * @author Vera Lucia Bezerra da Silva e Raquel Eucaria
 * @version 1.0 (April 2022)
 */
public class Pagamento {
	private int numeroCartao;
	private int cvc;
	private int validade;

	/**
	 * Construtor Pagamento
	 * @param numeroCartao referente ao numero do cartão
	 * @param cvc referente ao codido do cartao
	 * @param validade referene a data de validade do cartao
	 */
	public Pagamento(int numeroCartao, int cvc, int validade) {
		this.numeroCartao = numeroCartao;
		this.cvc = cvc;
		this.validade = validade;
	}
	
	@Override
	public String toString() {
		return "\n  Nr. Cartao - " + numeroCartao +
				"\n  cvc - "+ cvc +
				"\n  Val. - " + validade;
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
