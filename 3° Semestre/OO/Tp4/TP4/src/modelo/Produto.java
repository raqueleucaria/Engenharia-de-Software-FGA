package modelo;

/**
 * Classe que define os atributos e metodos do objeto
 * @author Vera Lucia Bezerra da Silva e Raquel Eucaria
 * @version 1.0 (April 2022)
 */
public abstract class Produto {
	protected String nome;
	protected int idProduto;
	protected String marca;
	protected double preco;
	protected String departamento;
	protected String descricao;
	protected String cor;
	protected String tamanho;
	protected Usuario usuario;
	
	// --------- Metodo construtor ----------
	public Produto() {
        super();
    }
	/**
	 * Construtor Produto
	 * @param nome referente ao nome do produto
	 * @param marca referente a marca do produto
	 * @param departamento referente ao departamento do produto (masculino/feminino)
	 * @param descricao referente a descricao do produto
	 * @param cor referente a cor do produto
	 * @param tamanho referente ao tamanho do produto
	 * @param idProduto refente ao id do produto
	 * @param preco refente oa preco do produto em reais
	 * @param usuario refente ao usuario
	 */
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