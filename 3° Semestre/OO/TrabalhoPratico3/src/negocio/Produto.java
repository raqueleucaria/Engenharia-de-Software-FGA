package negocio;

import java.awt.Image;

public abstract class Produto {
	protected String nome;
	protected int idProduto;
	protected String marca;
	protected double preco;
	protected String departamento;
	protected String descricao;
	protected String cor;
	protected String tamanho;
	//protected byte[] fotoProduto;
	protected Usuario usuario;
	
	// --------- Metodo construtor ----------
	public Produto() {
        super();
    }

    public Produto(String nome, String marca, String departamento, String descricao, String cor, String tamanho, int idProduto, double preco/*, byte[] fotoProduto*/, Usuario usuario) {
        this.nome = nome;
        this.marca = marca;
        this.departamento = departamento;
        this.descricao = descricao;
        this.cor = cor;
        this.tamanho = tamanho;
        this.idProduto = idProduto;
        this.preco = preco;
    
        this.usuario = usuario;
      //this.fotoProduto = fotoProduto;
    }
	
	//-------------- metodos ----------------
    public void cadastrar() {
	}
	
	public void editar() {
		
	}
	public void filtrar() {
		
	}
	
	public void deletar() {
		
	}
	
	public void adicionarItem() {
		
	}
	
	// --------------gets e sets ------------
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}


	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}