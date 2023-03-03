package modelo;

/**
 * Classe que define os atributos e metodos do objeto
 * @author Vera Lucia Bezerra da Silva e Raquel Eucaria
 * @version 1.0 (April 2022)
 */
public class Bijuteria extends Produto{
	//-------------Atributos da classe----------------
	private String modeloBijuteria;


	public Bijuteria() {
		super();
	}

	/**
	 * Construtor Bijuteria.
	 * @param idProduto referente ao id do produto Bijuteria.
	 * @param nome referente ao nome da bijuteria.
	 * @param marca referente a marc da bijuteria.
	 * @param preco referente ao preco da bijuteria em reais.
	 * @param departamento refernte ao departamento da bijteria (masculino ou feminino)
	 * @param descricao referente a descricao (caracteristicas) da bijuteria.
	 * @param cor referente a cor da bijuteria.
	 * @param modeloBijuteria referente ao modelo da bijuteria.
	 */
	public Bijuteria(int idProduto,String nome,String marca, double preco, String departamento, String descricao, String cor, String tamanho, String modeloBijuteria, Usuario usuario) {
		// ---------------- Metodo construtor -------------
		this.idProduto = idProduto;
		this.nome = nome;
		this.marca = marca;
		this.preco = preco;
		this.departamento = departamento;
		this.descricao = descricao;
		this.cor = cor;
		this.tamanho = tamanho;
		this.usuario = usuario;
		this.modeloBijuteria = modeloBijuteria;
	}
	@Override
	public String toString() {
		int idVendedor = 0;
		idVendedor += usuario.getIdUsuario();
		return 	" --------- Produto: BIJUTERIA ------------" +
				"\nID Produto: " + idProduto +
				"\nNome do produto: " + nome +
				"\nMarca: "+ marca +
				"\nPreco: "+ preco +
				"\nDepartamento: " + departamento +
				"\nDescricao: "+ descricao +
				"\nCor: "+ cor + 
				"\nTamanho: " + tamanho +
				"\nModelo Bijuteria: "+ modeloBijuteria +
	
				"\n\nID Vendedor: " + idVendedor;

	}

	//---------------Metodos--------------------------
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
	
	//---------------gets e sets---------------------
	
	public String getModeloBiju() {
		return modeloBijuteria;
	}

	public void setModeloBiju(String modeloBijuteria) {
		this.modeloBijuteria = modeloBijuteria;
	}
	
	
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