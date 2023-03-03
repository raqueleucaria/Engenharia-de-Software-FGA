package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controle.*;


/**
 * Classe que contem as informações da view
 * @author Vera Lucia Bezerra da Silva e Raquel Eucaria
 * @version 1.0 (April 2022)
 */
public class TelaMenuPrincipal implements ActionListener {
	private final JFrame janela;
	private final JLabel titulo;
	private final JButton usuario;
	private final JButton carrinho;
	private final JButton compra;
	private final JButton produtos;
	public final ControleDados dados;

	/**
	 * Metodo para contrucao da janela do menu principal
	 */
	public TelaMenuPrincipal() {
		janela = new JFrame("Controle Brecho");
		titulo = new JLabel("Menu Principal");
		usuario = new JButton("Usuarios");
		carrinho = new JButton("Carrinho");
		compra = new JButton("Compra");
		produtos = new JButton("Produtos");
		dados = new ControleDados();

		usuario.addActionListener(this);
		carrinho.addActionListener(this);
		produtos.addActionListener(this);
		compra.addActionListener(this);

		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(125, 20, 150, 30);
		usuario.setBounds(145, 70, 100, 30);
		produtos.setBounds(145, 110, 100, 30);
		carrinho.setBounds(80, 170, 100, 30);
		compra.setBounds(200, 170, 100, 30);

		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(usuario);
		janela.add(carrinho);
		janela.add(produtos);
		janela.add(compra);
		
		janela.setSize(400, 300);
		janela.setLocationRelativeTo(null);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Metodo para deixar janela visivel
	 */
	public void mostrar() {
		janela.setVisible(true);
	}
	
	public static void main(String[] args) {
		new TelaMenuPrincipal().mostrar();
	}

	/**
	 * Metodo que recebe os eventos de click dos botoes.
	 * As acoes tratadas sao nos botoes usuario, produtos carrinho e compra
	 * @param e evento de acao do botao
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == usuario)
			new TelaUsuario(dados).mostrar();
		
		if (src == produtos)
			new TelaProdutos(dados).mostrar();

		if (src == carrinho)
			new TelaCarrinho(dados).mostrar();

		if (src == compra)
			new TelaCompra(dados).mostrar();

	}
}
