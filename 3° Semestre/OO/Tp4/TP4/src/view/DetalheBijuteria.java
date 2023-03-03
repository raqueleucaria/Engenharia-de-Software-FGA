package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import controle.ControleDados;

/**
 * Classe que define os atributos e metodos do objeto
 * @author Vera Lucia Bezerra da Silva e Raquel Eucaria
 * @version 1.0 (April 2022)
 */
public class DetalheBijuteria extends DetalheProdutoAbstrato  implements ActionListener {
	private final JLabel labelID;
	private final JTextField valorID;
	private final JLabel labelNome;
	private final JTextField valorNome;
	private final JLabel labelMarca;
	private final JTextField valorMarca;
	private final JLabel labelPreco ;
	private final JTextField valorPreco;
	private final JLabel labelDepartamento;
	private final JTextField valorDepartamento;
	private final JLabel labelDescricao ;
	private final JTextField valorDescricao;
	private final JLabel labelCor;
	private final JTextField valorCor;
	private final JLabel labelTamanho ;
	private final JTextField valorTamanho;
	private final JLabel labelModelo ;
	private final JTextField valorModelo;
	private final JButton botaoExcluir ;
	private final JButton botaoSalvar;
	private final String[] novoDado = new String[9];
	private final ControleDados dados;
	private int posicao;
	private int opcao;

	/**
	 * Mostra janela com elementos para cadastrar dados de bijuteria
	 * @param opcao referente a opcao selecionada
	 * @param controleDados importa valores de ControleDados
	 * @param posicao refernte a posicao da bijuteria
	 */
	public DetalheBijuteria(int opcao, ControleDados controleDados, int posicao) {
		super(new JFrame());

		this.opcao = opcao;
		this.posicao = posicao;
		dados = controleDados;

		//Nome na aba
		if (opcao == 1)
			this.janela.setTitle("Cadastro Calca");
		if (opcao == 2)
			this.janela.setTitle("Detalhe Calca");

		labelID = new JLabel("ID: ");
		labelNome = new JLabel("Nome: ");
		labelMarca = new JLabel("Marca: ");
		labelPreco = new JLabel("Preco: ");
		labelDepartamento = new JLabel("Departamento: ");
		labelDescricao = new JLabel("Descricao: ");
		labelCor = new JLabel("Cor: ");
		labelTamanho = new JLabel("Tamanho: ");
		labelModelo = new JLabel("Modelo Bijuteria: ");

		botaoExcluir = new JButton("Excluir");
		 botaoSalvar = new JButton("Salvar");

		// Mostrar dados cadastrados
		if(opcao == 2) {
			valorID = new JTextField(String.valueOf(dados.getBijus()[posicao].getIdProduto()), 200);
			valorNome = new JTextField(dados.getBijus()[posicao].getNome(), 200);
			valorMarca = new JTextField(dados.getBijus()[posicao].getMarca(), 200);
			valorPreco = new JTextField(String.valueOf(dados.getBijus()[posicao].getPreco()), 200);
			valorDepartamento = new JTextField(dados.getBijus()[posicao].getDepartamento(), 200);
			valorDescricao = new JTextField(dados.getBijus()[posicao].getDescricao(), 200);
			valorCor = new JTextField(dados.getBijus()[posicao].getCor(), 200);
			valorTamanho = new JTextField(String.valueOf(dados.getBijus()[posicao].getTamanho()), 200);
			valorModelo = new JTextField(dados.getBijus()[posicao].getModeloBiju(), 200);

			// Inserir dados
		}else {
			valorID = new JTextField(200);
			valorNome = new JTextField(200);
			valorMarca = new JTextField(200);
			valorPreco = new JTextField(200);
			valorDepartamento = new JTextField(200);
			valorDescricao = new JTextField(200);
			valorCor = new JTextField(200);
			valorTamanho = new JTextField(200);
			valorModelo = new JTextField(200);
			botaoSalvar.setBounds(245, 300, 115, 30);
		}
		labelNome.setBounds(30, 20, 150, 25);
		valorNome.setBounds(130, 20, 230, 25);
		labelID.setBounds(30, 50, 150, 25);
		valorID.setBounds(130, 50, 230, 25);
		labelMarca.setBounds(30, 110, 150, 25);
		valorMarca.setBounds(130, 110, 230, 25);
		labelPreco.setBounds(30, 140, 150, 25);
		valorPreco.setBounds(130, 140, 230, 25);
		labelDepartamento.setBounds(30, 170, 150, 25);
		valorDepartamento.setBounds(130, 170, 230, 25);
		labelDescricao.setBounds(30, 230, 150, 25);
		valorDescricao.setBounds(130, 230, 230, 25);
		labelCor.setBounds(30, 230, 150, 25);
		valorCor.setBounds(130, 230, 230, 25);
		labelTamanho.setBounds(30, 80, 150, 25);
		valorTamanho.setBounds(130, 80, 230, 25);
		labelModelo.setBounds(30, 200, 150, 25);
		valorModelo.setBounds(130, 200, 230, 25);


		if(opcao == 2) {
			botaoSalvar.setBounds(10, 300, 115, 30);
			botaoExcluir.setBounds(130, 300, 80, 30);
			botaoCarrinho.setBounds(210,300,180,30);
			this.janela.add(botaoExcluir);
		}
		this.janela.add(labelNome);
		this.janela.add(valorNome);
		this.janela.add(labelID);
		this.janela.add(valorID);
		this.janela.add(labelMarca);
		this.janela.add(valorMarca);
		this.janela.add(labelPreco);
		this.janela.add(valorPreco);
		this.janela.add(labelDepartamento);
		this.janela.add(valorDepartamento);
		this.janela.add(labelDescricao);
		this.janela.add(valorDescricao);
		this.janela.add(labelCor);
		this.janela.add(valorCor);
		this.janela.add(labelTamanho);
		this.janela.add(valorTamanho);
		this.janela.add(labelModelo);
		this.janela.add(valorModelo);

		this.janela.add(botaoSalvar);
		this.janela.add(botaoExcluir);
		this.janela.setLayout(null);

		this.janela.setSize(400, 400);
		janela.setLocationRelativeTo(null);

		botaoSalvar.addActionListener(this);
	}

	/**
	 * Metodo para adicionar itens ao carrinho
	 * @return true se item adicionado com sucesso ou false se error ao adicionar item
	 */
	@Override
	public boolean addItemSelecionadoCarrinho() {
		return dados.getCarrinho().addItem(dados.getBijus()[posicao]);
	}

	/**
	 * Metodo que recebe os eventos de click dos botoes.
	 * As acoes tratadas sao salvar ou excluir bijuteria da lista
	 * @param e evento de acao do botao
	 */
	// chama funcoes la em controle de dados
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		Object src = e.getSource();
		if (src == botaoSalvar) {
			try {
				boolean res;
				if (opcao == 1)
					novoDado[0] = Integer.toString(dados.getQtdBlusas());
				else
					novoDado[0] = Integer.toString(posicao);
				
				novoDado[1] = valorNome.getText();
				novoDado[2] = valorMarca.getText();
				novoDado[3] = valorPreco.getText();
				novoDado[4] = valorDepartamento.getText();
				novoDado[5] = valorDescricao.getText();
				novoDado[6] = valorCor.getText();
				novoDado[7] = valorTamanho.getText();
				novoDado[8] = valorModelo.getText();
				
				res = dados.inserirEditarBijus(novoDado); 
				
				if (res) {
					Utilitario.mensagemSucessoCadastro(janela);
				} else
					Utilitario.mensagemErroCadastro();

			} catch (NullPointerException | NumberFormatException exc1) {
				Utilitario.mensagemErroCadastro();
			}
		}
		if (src == botaoExcluir) {
			boolean res = false;
			if (opcao == 2) {
				res = dados.removerBiju(posicao); 
				if (res)
					Utilitario.mensagemSucessoExclusao(janela);
				else
					Utilitario.mensagemErroExclusao();
			}


	}
}

}
