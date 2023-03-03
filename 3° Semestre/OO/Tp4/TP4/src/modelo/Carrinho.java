package modelo;

import modelo.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Classe que define os atributos e metodos do objeto
 * @author Vera Lucia Bezerra da Silva e Raquel Eucaria
 * @version 1.0 (April 2022)
 */
public class Carrinho {
    //-------------Atributos da classe----------------
    private double frete; //frete fixo
    private List<Produto> items = new ArrayList<>();
    private double valorCada;
    private double valorTotal;
    private int idVendedor;

    public Carrinho() {
    }

    /**
     *
     * @return valor do produto, frete e valor total
     */
    public String toString() {
        return " --------- Carrinho ------------" +

                "\nPreco do(s) produto(s): " + valorCada +
                "\nFrete: R$ " + frete + " reais" +
                "\n\n    Valor total: " + valorTotal;
    }

    /**
     *
     * @param produto refere-se a classe Produto
     * @return
     */
    public boolean addItem(Produto produto) {
        Random random = new Random();
        frete = 10.1 * (random.nextInt(3));
        valorCada = produto.getPreco();
        valorTotal = valorCada + frete;
        return this.items.add(produto);
    }

    /**
     *
     * @param produto
     */
    public void removeItem(Produto produto) {
        this.items.remove(produto);
    }

    // -----------gets e sets ------------

    public double getFrete() {
        return frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Produto> getItems() {
        return items;
    }


    public String[] getItemsNames() {
        String[] nomes = new String[this.items.size()];
        for (int i = 0; i < this.items.size(); i++) {
            nomes[i] = this.items.get(i).getNome();
        }
        return nomes;
    }

    public void setItems(List<Produto> items) {
        this.items = items;
    }

    public double getValorCada() {
        return valorCada;
    }

    public void setValorCada(double valorCada) {
        this.valorCada = valorCada;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

}