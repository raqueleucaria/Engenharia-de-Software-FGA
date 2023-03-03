package controle;
import modelo.*;
import java.util.List;

/**
 * Classe que define os atributos e metodos do objeto
 * @author Vera Lucia Bezerra da Silva e Raquel Eucaria
 * @version 1.0 (April 2022)
 */
public class ControleCarrinho {
	private Carrinho[] carrinho;
	private int qtdItens;

	public ControleCarrinho(List<Produto> d) {
//		carrinho = d.();
//		qtdItens = d.getItems();
	}
	// retorna o id vendedor associado ao carrinho
	public int[] getIdVendedor() {
		int[] q = new int[qtdItens];
		for (int i = 0; i < qtdItens; i++) {
			q[i] = carrinho[i].getIdVendedor();
		}
		return q;
	}

	//-------------Gets e Sets ---------------------

	public int getQtd() {
		return qtdItens;
	}
	public void setQtd(int qtd) {
		this.qtdItens = qtd;
	}
	public double getFrete(int i) {
		return carrinho[i].getFrete();
	}
	public Produto getI(int i) {
		return (Produto) carrinho[i].getItems();
	}
	public double getValorCada(int i) {
		return carrinho[i].getValorCada();
	}

	public double getValorTotal(int i) {
		return
		carrinho[i].getValorTotal();
	}



}
