package controle;

import java.util.Date;
import java.util.List;

import modelo.*;

/**
 * Classe que define os atributos e metodos do objeto
 * @author Vera Lucia Bezerra da Silva e Raquel Eucaria
 * @version 1.0 (April 2022)
 */
public class ControleCompra {
	private List<Compra> compras;
	private int qtdComp;

	/**
	 *
	 * @param d referente a controle de dados
	 */
	public ControleCompra(ControleDados d) {
		compras = d.getCompras();
		qtdComp = d.getQtdCompras();
	}

	/**
	 *
	 * @return retorna a quantidade de compras
	 */
	// retorna o n�mero do pedido 
	public int[] getNumeroPedido() {
		int[] q = new int[qtdComp];
		for (int i = 0; i < qtdComp; i++) {
			q[i] = compras.get(i).getNumeroPedido();
		}
		return q;
	}
	
	//-------------Gets e Sets ---------------------
	
	public int getQtd() {
		return qtdComp;
	}
	public void setQtd(int qtd) {
		this.qtdComp = qtd;
	}
	public Date getDataCompra(int i) {
		return compras.get(i).getDataCompra();
	}
	public String getStatusCompra(int i) {
		return compras.get(i).getStatusCompra();
	}
	public int getNumeroPedido(int i) {
		return compras.get(i).getNumeroPedido();
	}
	
	//usuario cliente associado
	public Usuario getUsuario(int i) {
		return compras.get(i).getUsuario();
	}
	
	//itens
	public Carrinho getCarrinho(int i) {
		return compras.get(i).getCarrinho();
	}
	
	
	
}
