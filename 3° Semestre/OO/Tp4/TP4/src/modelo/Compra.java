package modelo;

import java.util.Calendar;
import java.util.Date;

/**
 * Classe que define os atributos e metodos do objeto
 * @author Vera Lucia Bezerra da Silva e Raquel Eucaria
 * @version 1.0 (April 2022)
 */
public class Compra {
    private Date dataCompra;
    private String statusCompra;
    private int numeroPedido;

    private Usuario usuario;
    private Carrinho carrinho;

    /**
     * Contrutor Compra
     * @param dataCompra referente a data de compra
     * @param statusCompra referente os status da compra
     * @param numeroPedido referente ao numero de compra
     * @param carrinho referente ao carrinho com produtos selecionados para compra
     */
    public Compra(Date dataCompra, String statusCompra, int numeroPedido, Carrinho carrinho) {
        this.dataCompra = dataCompra;
        this.statusCompra = statusCompra;
        this.numeroPedido = numeroPedido;
        this.carrinho = carrinho;
    }

    /**
     *
     * @return
     */
    public String toString() {
        return numeroPedido + " - " + dataCompra.toGMTString() + " - " +  (carrinho != null ? carrinho.getValorTotal() : "");
    }

    //------------------------ metodos -----------------------
    public void confirmar() {
    }

    public void cancelar() {
    }

    public void editarEndereco() {
    }


    // -------------------gets e sets -----------------------
    public Date getDataCompra() {
        return dataCompra;
    }

    public String getStatusCompra() {
        return statusCompra;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }


}