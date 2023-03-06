package modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Classe que define os atributos e metodos do objeto
 * @author Vera Lucia Bezerra da Silva e Raquel Eucaria
 * @version 1.0 (April 2022)
 */

public class Dados {
	//-------------Atributos da classe----------------
	private  List<Usuario> usuarios = new ArrayList<>();
	private int qtdUsuarios = 0;
	private Bijuteria [] bijus = new Bijuteria[15];
	private int qtdBijus = 0;
	private Blusa[] blusas = new Blusa[15];
	private int qtdBlusas = 0;
	private Calca[] calcas = new Calca[15];
	private int qtdCalcas = 0;
	private Carrinho carrinho = new Carrinho();
	private List<Compra> compras = new ArrayList<>();
	private int qtdCompras = 0;
	private  Telefone[] tels = new Telefone[15];
	private int qtdTels = 0;
	private  Endereco[] ends = new Endereco[15];
	private int qtdEnds = 0;
	private  Pagamento[] pagamentos = new Pagamento[15];
	private int qtdPags = 0;

	/**
	 * Método para inserir e/ou editar um usuario.
	 * @param u refere-se a classe Usuario
	 */
	public boolean inserirEditarUsuario(Usuario u) {
		return this.usuarios.add(u);
	}

	/**
	 * Método para inserir e/ou editar uma blusa.
	 * @param blusa refere-se a classe Blusa.
	 * @param posicao variavel que informa a posicao da blusa.
	 */
	public void inserirEditarBlusa(Blusa blusa, int posicao) {
		this.blusas[posicao] = blusa;
		if (posicao == qtdBlusas)
			qtdBlusas++;
	}
	/**
	 * Método para inserir e/ou editar uma calca
	 * @param c refere-se a classe Calca
	 * @param posicao variavel que informa a posicao de calca
	 */
	public void inserirEditarCalca(Calca c, int posicao) {
		this.calcas[posicao] = c;
		if (posicao == qtdCalcas)
			qtdCalcas++;
	}
	/**
	 * Método para inserir e/ou editar Bijuteria
	 * @param b refere-se a classe Bijuteria
	 * @param posicao variavel que informa a posicao de bijuteria.
	 */
	public void inserirEditarBiju(Bijuteria b, int posicao) {
		this.bijus[posicao] = b;
		if (posicao == qtdBijus)
			qtdBijus++;
	}
		/**
	 	* Dados pré cadastrados no banco de dados.
	 	*/
		public void preDados() {
			
			Date d = Calendar.getInstance().getTime();
			
			//usuarios[0] = (new Usuario(1, "Nome"+1,111,new Telefone(11, 91111),new Pagamento(511, 111, 3011),new Endereco(711, 1,"Rua"+1, "Complemento"+1)));
			this.usuarios.add(new Usuario(1, "Nome "+1,111,new Telefone(11, 91111),new Pagamento(511, 111, 3011),new Endereco(711, 1,"Rua"+1, "Complemento"+1)));
			this.usuarios.add(new Usuario(2, "Nome "+2,222,new Telefone(22, 92222),new Pagamento(522, 222, 3022),new Endereco(722, 2,"Rua"+2, "Complemento"+2)));
			
	        calcas[0] = (new Calca(1, "Calca "+1,"Marca "+1, 1,"Departamento "+1, "Descricao "+1, "Cor "+1,"Tamanho "+1, "Modelo Blusa "+1,usuarios.get(0) ));
	        calcas[1] = (new Calca(2, "Calca "+2,"Marca "+2, 2,"Departamento "+2, "Descricao "+2, "Cor "+2,"Tamanho "+2, "Modelo Blusa "+2,usuarios.get(0) ));

	        blusas[0] = (new Blusa(1, "Blusa "+1,"Marca "+1, 1,"Departamento "+1, "Descricao "+1, "Cor "+1,"Tamanho "+1, "Modelo Calca "+1,usuarios.get(0) ));
	        blusas[1] = (new Blusa(2, "Blusa "+2,"Marca "+2, 2,"Departamento "+2, "Descricao "+2, "Cor "+2,"Tamanho "+2, "Modelo Calca "+2,usuarios.get(0) ));

	        bijus[0] = (new Bijuteria(1, "Bijuteria "+1,"Marca "+1, 1,"Departamento "+1, "Descricao "+1, "Cor "+1,"Tamanho "+1, "Modelo Bijuteria "+1,usuarios.get(0) ));
	        bijus[1] = (new Bijuteria(2, "Bijuteria "+2,"Marca "+2, 2,"Departamento "+2, "Descricao "+2, "Cor "+2,"Tamanho "+2, "Modelo Bijuteria "+2,usuarios.get(0)));

			Carrinho carrinhoCompra1 =  new Carrinho();
			carrinhoCompra1.addItem(calcas[0]);
			carrinhoCompra1.addItem(bijus[0]);

			Carrinho carrinhoCompra2 =  new Carrinho();
			carrinhoCompra2.addItem(calcas[0]);
			carrinhoCompra2.addItem(bijus[0]);

	        compras.add(new Compra(d, "Status "+0, 0, carrinhoCompra1));
	        compras.add(new Compra(d, "Status "+1, 1, carrinhoCompra2));

	        qtdBijus = 2;
	        qtdUsuarios = 2;
	        qtdCalcas = 2;
	        qtdBlusas = 2;
	        qtdCompras = 2;
	    }

	//----------------gets e sets-------------------
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public int getQtdUsuarios() {
		return qtdUsuarios;
	}

	public void setQtdUsuarios(int qtdUsuarios) {
		this.qtdUsuarios = qtdUsuarios;
	}

	public Bijuteria[] getBijus() {
		return bijus;
	}

	public void setBijus(Bijuteria[] bijus) {
		this.bijus = bijus;
	}

	public int getQtdBijus() {
		return qtdBijus;
	}

	public void setQtdBijus(int qtdBijus) {
		this.qtdBijus = qtdBijus;
	}

	public Blusa[] getBlusas() {
		return blusas;
	}

	public void setBlusas(Blusa[] blusas) {
		this.blusas = blusas;
	}

	public int getQtdBlusas() {
		return qtdBlusas;
	}

	public void setQtdBlusas(int qtdBlusas) {
		this.qtdBlusas = qtdBlusas;
	}

	public Calca[] getCalcas() {
		return calcas;
	}

	public void setCalcas(Calca[] calcas) {
		this.calcas = calcas;
	}

	public int getQtdCalcas() {
		return qtdCalcas;
	}

	public void setQtdCalcas(int qtdCalcas) {
		this.qtdCalcas = qtdCalcas;
	}

	public Carrinho getCarrinho() {
		return this.carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public int getQtdItensCarrs() {
		return this.carrinho.getItems().size();
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public int getQtdCompras() {
		return qtdCompras;
	}

	public void setQtdCompras(int qtdCompras) {
		this.qtdCompras = qtdCompras;
	}

	public Telefone[] getTels() {
		return tels;
	}

	public void setTels(Telefone[] tels) {
		this.tels = tels;
	}

	public int getQtdTels() {
		return qtdTels;
	}

	public void setQtdTels(int qtdTels) {
		this.qtdTels = qtdTels;
	}

	public Endereco[] getEnds() {
		return ends;
	}

	public void setEnds(Endereco[] ends) {
		this.ends = ends;
	}

	public int getQtdEnds() {
		return qtdEnds;
	}

	public void setQtdEnds(int qtdEnds) {
		this.qtdEnds = qtdEnds;
	}

	public Pagamento[] getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(Pagamento[] pagamentos) {
		this.pagamentos = pagamentos;
	}

	public int getQtdPags() {
		return qtdPags;
	}

	public void setQtdPags(int qtdPags) {
		this.qtdPags = qtdPags;
	}

}
