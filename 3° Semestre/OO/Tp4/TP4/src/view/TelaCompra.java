package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controle.*;
import modelo.Compra;
/**
 * Classe que define os atributos e metodos do objeto
 * @author Vera Lucia Bezerra da Silva e Raquel Eucaria
 * @version 1.0 (April 2022)
 */
public class TelaCompra {
    private final JFrame janela;
    private final JLabel titulo;
    private final JButton atualiza;
    private final JButton busca;
    private final ControleDados dados;
    private final JLabel data;
    private final JTextField dataCompra;
    private final JTextField numeroBusca;
    private final JLabel pedido;
    private final JTextField numeroPedido;
    private final JTable tabela;

    /**
     *
     * @param controleDados referente a dodos de compra
     */
    public TelaCompra(ControleDados controleDados) {
        dados = controleDados;

        data = new JLabel("Data da compra:");
        pedido = new JLabel("Numero Pedido:");

        // converte os dados em matrix para serem exibidos na tabela
        String[][] dadosTabela = new String[dados.getCompras().size()][3];
        for (int i = 0; i < dados.getCompras().size(); i++) {
            Compra compra = dados.getCompras().get(i);
            String valor = compra.getCarrinho() != null ? String.valueOf(compra.getCarrinho().getValorTotal()) : "";
            dadosTabela[i] = new String[]{String.valueOf(compra.getNumeroPedido()), compra.getDataCompra().toString(), valor};
        }

        tabela = new JTable(dadosTabela, new String[]{"Codigo", "Data", "Valor Total"});
        janela = new JFrame("Compras");
        titulo = new JLabel("Consultar compras");

        numeroPedido = new JTextField(200);
        dataCompra = new JTextField(200);
        numeroBusca = new JTextField();
        busca = new JButton("Pesquisar");
        atualiza = new JButton("Atualizar");

        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setBounds(90, 10, 250, 30);

        data.setBounds(30, 40, 150, 25);
        dataCompra.setBounds(130, 40, 230, 25);
        pedido.setBounds(30, 70, 150, 25);
        numeroPedido.setBounds(130, 70, 230, 25);
        numeroBusca.setBounds(20, 240, 230, 30);
        busca.setBounds(270, 240, 100, 30);
        atualiza.setBounds(150, 190, 100, 30);

        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setBounds(20, 50, 350, 120);

        janela.setLayout(null);

        janela.add(titulo);
        janela.add(scroll);

        janela.setSize(400, 320);
        janela.setLocationRelativeTo(null);
    }

    /**
     * Metodo para deixar janela visivel
     */
    public void mostrar() {
        janela.setVisible(true);
    }

}