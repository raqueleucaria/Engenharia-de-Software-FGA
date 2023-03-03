package negocio;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private double frete = 30.0; //frete fixo
    private double valorTotalProdutos;

    private List<Produto> produtos = new ArrayList<>();

    public Carrinho() {
    }

    public Carrinho(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public String toString() {
        return " --------- Carrinho ------------" +
                resumirProdutos() +
                "\nPreço do(s) produto(s): " + this.valorTotalProdutos +
                "\nFrete: R$ " + this.getFrete() + " reais" +
                "\n\nValor total: " + this.getValorTotal();
    }

    //------------------ metodos ----------------
    public String resumirProdutos() {
        String resumo = "\n--------- Lista de produtos no carrinho ---------\n";

        for (Produto produto : this.produtos) {
            resumo += "\nNome: " + produto.nome + "\nPreço: " + produto.preco + "\nTamanho: " + produto.tamanho + "\n";
        }
        return resumo;
    }

    public void comprar() {
    }

    public void deletarItem() {
    }

    public void adicionarProduto(Produto produto) {
        this.valorTotalProdutos += produto.preco;
        this.produtos.add(produto);
    }


    public void removerProduto(Produto produto) {
        this.valorTotalProdutos -= produto.preco;
        this.produtos.remove(produto);
    }

    // -----------gets e sets ------------
    public double getFrete() {
        return frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }

    public double getValorTotal() {
        return valorTotalProdutos + frete;
    }

    public double getValorTotalProdutos() {
        return valorTotalProdutos;
    }

}