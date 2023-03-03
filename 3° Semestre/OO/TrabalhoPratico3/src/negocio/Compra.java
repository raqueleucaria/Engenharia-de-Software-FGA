package negocio;

public class Compra {
    private String dataCompra; //Mudar para Date depois
    private String statusCompra;
    private int numeroPedido;

    private Usuario usuario;
    private Carrinho carrinho;


    public Compra(String dataCompra, String statusCompra, int numeroPedido, Usuario usuario, Carrinho carrinho) {
        this.dataCompra = dataCompra;
        this.statusCompra = statusCompra;
        this.numeroPedido = numeroPedido;
        this.usuario = usuario;
        this.carrinho = carrinho;
    }

    public String toString() {
        return " ------------ Compra ------------------" +
                "\nNúmero Pedido: " + numeroPedido +
                "\n\nData da Compra: " + dataCompra +
                "\nStatus: " + statusCompra +

//                "\n\nVendedor: " + carrinho.datarVendedor() +
                "\nCliente: " + usuario.getIdUsuario() + " - " + usuario.getNome() + "\n\n" +

                carrinho.resumirProdutos() +
                "\nPreço do(s) produto(s): " + carrinho.getValorTotalProdutos() +
                "\nFrete: R$ " + this.carrinho.getFrete() + " reais" +
                "\n\n    Valor total: " + carrinho.getValorTotal();
    }

    //------------------------ metodos -----------------------
    public void confirmar() {
    }

    public void cancelar() {
    }

    public void editarEndereco() {
    }


    // -------------------gets e sets -----------------------
    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getStatusCompra() {
        return statusCompra;
    }

    public void setStatusCompra(String statusCompra) {
        this.statusCompra = statusCompra;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
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