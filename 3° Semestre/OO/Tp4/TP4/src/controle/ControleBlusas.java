package controle;

import modelo.*;

/**
 * Classe que define os atributos e metodos do objeto
 * @author Vera Lucia Bezerra da Silva e Raquel Eucaria
 * @version 1.0 (April 2022)
 */
public class ControleBlusas {
	
	private Blusa[] blu;
	private int qtdBlusa;
	

	/**
	 * Metodo para lista blusas
	 * @param d importa os dados de Blusas
	 */
	public ControleBlusas(ControleDados d) {
		blu = d.getBlusas();
		qtdBlusa = d.getQtdBlusas();
	}
	
	public String[] getNome() {
		String[] q = new String[qtdBlusa];
		for (int i = 0; i < qtdBlusa; i++) {
			q[i] = blu[i].getNome();
		}
		return q;
	}
	
	
	//-------------Gets e sets----------------
	
	public int getQtd() {
		return qtdBlusa;
	}
	
	public void setQtd(int qtd) {
		this.qtdBlusa = qtd;
	}
	
	public String getNome(int i) {
		return blu[i].getNome();
	}
	
	public int getIdProduto(int i) {
		return blu[i].getIdProduto();
	}
	
	public String getMarca(int i) {
		return blu[i].getMarca();
	}
	
	public double getPreco(int i) {
		return blu[i].getPreco();
	}
	
	public String getDepartamento(int i) {
		return blu[i].getDepartamento();
	}
	
	public String getDescricao(int i) {
		return blu[i].getDescricao();
	}
	
	public String getCor(int i) {
		return blu[i].getCor();
	}
	
	public String getTamanho(int i) {
		return blu[i].getTamanho();
	}
	
	public String getModeloBlusa(int i) {
		return blu[i].getModeloBlusa();
	}
	
	public Usuario getUsuario(int i) {
		return blu[i].getUsuario();
	}
	
}
