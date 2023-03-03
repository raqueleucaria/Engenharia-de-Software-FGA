package modelo;

/**
 * Classe que define os atributos e metodos do objeto
 * @author Vera Lucia Bezerra da Silva e Raquel Eucaria
 * @version 1.0 (April 2022)
 */

public class Usuario {
	private int idUsuario;
	private String nome;
	private int cpf;
	private Telefone telefone;
	private Pagamento pagamento;
	private Endereco endereco;

	/**
	 * Construtor Cliente
	 * @param idUsuario refere-se ao id do usuario.
	 * @param nome refere-se ao nome do usuario.
	 * @param cpf refere-se ao cpf do usuario.
	 * @param telefone refere-se ao  telefone do usuario.
	 * @param endereco refere-se oa endereco do usuario.
	 */
	public Usuario(int idUsuario, String nome,int cpf, Telefone telefone, Pagamento pagamento, Endereco endereco/*, byte[] fotoPerfil*/) {
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.pagamento = pagamento;
		this.endereco = endereco;


		
		
		
	}
	
	public String toString() {	
		return "--------------Usuario--------------"+
				"\nID Usuario: " + idUsuario +
				"\nNome do aluno: " + nome +
				"\nCPF: "+ cpf +
				"\nTelefone: "+ telefone + 
				"\nPagamento: " + pagamento +
				"\nEndereco: "+ endereco;
	}
	
	public int toStringID() {
		return idUsuario;
	}
	
	//-------------- metodos ----------------
	public String cadastrarUsuario(String n){
		return this.nome = n;
	}
		
	public void editarUsuario(String e) {
		this.nome = e;
	}
	public void buscarUsuario() {
		
	}
	public void excluirUsuario() {
		
	}
		
		
		
	// -----------gets e sets ------------

	public int getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	
	

}