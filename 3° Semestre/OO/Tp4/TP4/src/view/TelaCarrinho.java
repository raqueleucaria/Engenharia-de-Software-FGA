package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controle.*;
import modelo.Carrinho;
import modelo.Compra;
import modelo.Produto;

/**
 * Classe que define os atributos e metodos do objeto
 * @author Vera Lucia Bezerra da Silva e Raquel Eucaria
 * @version 1.0 (April 2022)
 */
public class TelaCarrinho implements ActionListener, ListSelectionListener {
    private final JFrame janela;
    private final JLabel titulo;
    private final JButton atualizar;
    private final JButton compra;
    private final JList<String> listaItems;
    private final ControleDados dados;
    private final String[] listaCodigos;

	/**
	 * Cria a tela de listagem de item do carrinho
	 * @param controleDados  controle de dados
	 */
    public TelaCarrinho(ControleDados controleDados) {
        dados = controleDados;
        listaCodigos = new String[0];
        janela = new JFrame("Carrinho");
        titulo = new JLabel("Carrinho de compras");
        atualizar = new JButton("Atualizar");
        compra = new JButton("Finalizar compra");

        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setBounds(90, 10, 250, 30);

        atualizar.setBounds(50, 190, 100, 30);
        compra.setBounds(180, 190, 200, 30);
        compra.addActionListener(this);

        listaItems = new JList<>(dados.getCarrinho().getItemsNames());
        listaItems.setBounds(20, 50, 350, 120);
        listaItems.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaItems.setVisibleRowCount(10);

        janela.setLayout(null);
        janela.add(titulo);
        janela.add(listaItems);
        janela.add(atualizar);
        janela.add(compra);
        janela.setSize(400, 320);
        janela.setLocationRelativeTo(null);
    }

	/**
	 * Medoto para deixar janela visivel
	 **/
	public void mostrar() {
		janela.setVisible(true);
	}
    /**
     * Metodo que recebe os eventos de click dos botoes.
     * As acoes tratadas sao comprar da lista
     * @param e evento de acao do botao
     */
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        //Comprar
        if (src == compra) {
            Compra compra = new Compra(new Date(), "concluida", 123, dados.getCarrinho());
            dados.getCompras().add(compra);
            janela.dispose();
            dados.getDados().setCarrinho(new Carrinho());
        }

    }
    /**
     * Quando mudar valor selecionado mostrar uma nova tela de Datalhe de carinho
     * @param e evendo de acao do botao
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        System.out.println("item selecionado");
    }
}

