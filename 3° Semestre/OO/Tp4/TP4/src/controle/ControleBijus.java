package controle;

import modelo.*;

/**
 * Classe que define os atributos e metodos do objeto
 * @author Vera Lucia Bezerra da Silva e Raquel Eucaria
 * @version 1.0 (April 2022)
 */
public class ControleBijus {
	
	private Bijuteria[] biju;
	private int qtdBiju;
	
	
	// ------------  M�todo -----------------

	/**
	 * Importa os dados de Bijuteria
	 * @param d importa valores de Bijuteria
	 */
	public ControleBijus(ControleDados d) {
		biju = d.getBijus();
		qtdBiju = d.getQtdBijus();
	}

	/**
	 * Metodo para listar as bijuterias
	 * @return os nomes das bijuterias
	 */
	public String[] getNome() {
		String[] q = new String[qtdBiju];
		for (int i = 0; i < qtdBiju; i++) {
			q[i] = biju[i].getNome();
		}
		return q;
	}
	
	
	//-------------Gets e sets----------------
	
	public int getQtd() {
		return qtdBiju;
	}
	
	public void setQtd(int qtd) {
		this.qtdBiju = qtd;
	}
	
	public String getNome(int i) {
		return biju[i].getNome();
	}
	
	public int getIdProduto(int i) {
		return biju[i].getIdProduto();
	}
	
	public String getMarca(int i) {
		return biju[i].getMarca();
	}
	
	public double getPreco(int i) {
		return biju[i].getPreco();
	}
	
	public String getDepartamento(int i) {
		return biju[i].getDepartamento();
	}
	
	public String getDescricao(int i) {
		return biju[i].getDescricao();
	}
	
	public String getCor(int i) {
		return biju[i].getCor();
	}
	
	public String getTamanho(int i) {
		return biju[i].getTamanho();
	}
	
	public String getModeloBiju(int i) {
		return biju[i].getModeloBiju();
	}
	
	public Usuario getUsuario(int i) {
		return biju[i].getUsuario();
	}
	
}
