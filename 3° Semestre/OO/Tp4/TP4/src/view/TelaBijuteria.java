package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
import modelo.*;
import modelo.Blusa;

/**
 * Classe que define os atributos e metodos do objeto
 * @author Vera Lucia Bezerra da Silva e Raquel Eucaria
 * @version 1.0 (April 2022)
 */
public class TelaBijuteria implements ActionListener, ListSelectionListener {
    private final JFrame janela;
    private final JLabel titulo;
    private final JButton cadastro;
    private final JButton atualiza;
    private final JButton busca;
    private final JTextField nomeBusca;
    private final ControleDados dados;
    private final JList<String> listaBijusCadastradas;
    private final String[] listaCodigos;

    /**
     * @param controleDados dados referentes a bijuterias
     */
    public TelaBijuteria(ControleDados controleDados) {
        dados = controleDados;


        listaCodigos = new ControleBijus(dados).getNome();
        listaBijusCadastradas = new JList<String>(listaCodigos);
        janela = new JFrame("Bijuterias");
        titulo = new JLabel("Bijuterias Cadastradas");

        cadastro = new JButton("Cadastrar");
        atualiza = new JButton("Atualizar");
        busca = new JButton("Pesquisar");
        nomeBusca = new JTextField();


        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setBounds(90, 10, 250, 30);
        listaBijusCadastradas.setBounds(20, 50, 350, 120);
        listaBijusCadastradas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaBijusCadastradas.setVisibleRowCount(10);

        cadastro.setBounds(20, 190, 100, 30);
        atualiza.setBounds(120, 190, 80, 30);
        nomeBusca.setBounds(20, 240, 230, 30);
        busca.setBounds(270, 240, 100, 30);


        janela.setLayout(null);

        janela.add(titulo);
        janela.add(listaBijusCadastradas);
        janela.add(cadastro);
        janela.add(atualiza);
        janela.add(nomeBusca);
        janela.add(busca);


        janela.setSize(400, 320);
        janela.setLocationRelativeTo(null);

        cadastro.addActionListener(this);
        atualiza.addActionListener(this);
        busca.addActionListener(this);
        listaBijusCadastradas.addListSelectionListener(this);
    }

    /**
     * Metodo que recebe os eventos de click dos botoes.
     * As acoes tratadas sao cadastro,atualizar ou buscar bijuterias da lista
     * @param e evento de acao do botao
     */
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        //Cadastrar
        if (src == cadastro)
            new DetalheBlusa(1, dados, 0).mostrar();

        //Atualizar
        if (src == atualiza) {
            listaBijusCadastradas.setListData(new ControleBijus(dados).getNome());
            listaBijusCadastradas.updateUI();
        }

        //buscar
        if (src == busca) {
            String digitado = nomeBusca.getText();
            int i = 0;
            List<String> resultado = new ArrayList<>(0);
            boolean encontrou = false;

            for (Bijuteria bijuteria : dados.getDados().getBijus()) {
                if (bijuteria == null) {
                    continue;
                }
                String nome = bijuteria.getNome();
                if (nome.toUpperCase().contains(digitado.toUpperCase())) {
                    resultado.add(nome);
                    encontrou = true;
                }

            }
            if (encontrou) {
                listaBijusCadastradas.setListData(resultado.toArray(new String[0]));
                listaBijusCadastradas.updateUI();

            } else {
                mensagemErroBusca();
            }
        }
    }

    /**
     * Quando muda valor selecionado mostrar uma nova tela de Datalhe de bijuteria
     * @param e
     */
    public void valueChanged(ListSelectionEvent e) {
        Object src = e.getSource();
        if (e.getValueIsAdjusting() && src == listaBijusCadastradas) {
            new DetalheBijuteria(2, dados, listaBijusCadastradas.getSelectedIndex()).mostrar();
        }
    }

    /**
     * Exibe uma janela com mensagem de erro ao tentar buscar bijuteria.
     */
    public void mensagemErroBusca() {
        JOptionPane.showMessageDialog(null, "Bijuteria nao encontrada.\n ", null,
                JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Metodo para deixar jenela visivel
     */
    public void mostrar(){
        this.janela.setVisible(true);
    }
}
