package negocio;

public class Blusa extends Produto{
	private String modeloBlusa;
	
	// ---------------- Metodo construtor -------------
	public Blusa (int idProduto,String nome,String marca, double preco, String departamento, String descricao, String cor, String tamanho,/*, byte[] foto*/ String modeloBlusa, Usuario usuario) {
		this.idProduto = idProduto;
		this.nome = nome;
		this.marca = marca;
		this.preco = preco;
		this.departamento = departamento;
		this.descricao = descricao;
		this.cor = cor;
		this.tamanho = tamanho;
		this.usuario = usuario;
		
		this.modeloBlusa = modeloBlusa;
		//protected Image fotoProduto[];
	}
	
	@Override
	public String toString() {
		int idVendedor = 0;
		idVendedor += usuario.getIdUsuario();
		return 	" --------- Produto: BLUSA ------------" +
				"\nID Produto: " + idProduto +
				"\nNome do produto: " + nome +
				"\nMarca: "+ marca +
				"\nPreço: "+ preco + 
				"\nDepartamento: " + departamento +
				"\nDescrição: "+ descricao +
				"\nCor: "+ cor + 
				"\nTamanho: " + tamanho +
				"\nModelo Blusa: "+ modeloBlusa+
		
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
	public String getModeloBlusa() {
		return modeloBlusa;
	}

	public void setModeloBlusa(String modeloBlusa) {
		this.modeloBlusa = modeloBlusa;
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
	
	

	
