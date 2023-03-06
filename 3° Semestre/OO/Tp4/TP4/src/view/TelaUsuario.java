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
import modelo.Usuario;

/**
 * Classe que define os atributos e metodos do objeto
 * @author Vera Lucia Bezerra da Silva e Raquel Eucaria
 * @version 1.0 (April 2022)
 */
public class TelaUsuario implements ActionListener, ListSelectionListener {
    private final JFrame janela;
    private final JLabel titulo;
    private final JButton cadastro;
    private final JButton atualiza;
    private final JButton busca;
    private final JTextField nomeBusca;
    private final ControleDados dados;
    private final JList<String> listaUsuariosCadastrados;
    private final String[] listaCodigos;

    /**
     * * Mostra janela com usuarios cadastrados
     * @param controleDados importa valores de ControleDados
     */
    public TelaUsuario(ControleDados controleDados) {
        dados = controleDados;

        janela = new JFrame("Usuarios");
        listaCodigos = new ControleUsuarios(dados).getNomes();
        listaUsuariosCadastrados = new JList<String>(listaCodigos);
        titulo = new JLabel("Usuarios Cadastrados");

        cadastro = new JButton("Cadastrar");
        atualiza = new JButton("Atualizar");
        busca = new JButton("Pesquisar");
        nomeBusca = new JTextField();


        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setBounds(90, 10, 250, 30);
        listaUsuariosCadastrados.setBounds(20, 50, 350, 120);
        listaUsuariosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaUsuariosCadastrados.setVisibleRowCount(10);

        cadastro.setBounds(70, 190, 100, 30);
        atualiza.setBounds(200, 190, 100, 30);
        nomeBusca.setBounds(20, 240, 230, 30);
        busca.setBounds(270, 240, 100, 30);

        janela.setLayout(null);

        janela.add(titulo);
        janela.add(listaUsuariosCadastrados);
        janela.add(cadastro);
        janela.add(atualiza);
        janela.add(nomeBusca);
        janela.add(busca);

        janela.setSize(400, 320);
        janela.setLocationRelativeTo(null);

        cadastro.addActionListener(this);
        atualiza.addActionListener(this);
        busca.addActionListener(this);
        listaUsuariosCadastrados.addListSelectionListener(this);
    }

    /**
     * Metodo para deixar janela visivel
     */
    public void mostrar() {
        janela.setVisible(true);
    }

    /**
     * Metodo que recebe os eventos de click dos botoes.
     * As acoes tratadas sao cadastro,atualizar ou buscar usuario da lista
     * @param e evento de acao do botao
     */
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        //Cadastrar
        if (src == cadastro) {
            new DetalheUsuario(1, dados, 0).mostrar();
        }

        //Atualizar
        if (src == atualiza) {
            listaUsuariosCadastrados.setListData(new ControleUsuarios(dados).getNomes());
            listaUsuariosCadastrados.updateUI();
        }

        //buscar
        if (src == busca) {
            String digitado = nomeBusca.getText();
            int i = 0;
            List<String> resultado = new ArrayList<>(0);
            boolean encontrou = false;

            for (Usuario usuario : dados.getDados().getUsuarios()) {
                if (usuario == null) {
                    continue;
                }
                String nome = usuario.getNome();
                if (nome.toUpperCase().contains(digitado.toUpperCase())) {
                    resultado.add(nome);
                    encontrou = true;
                }
                if (encontrou) {
                    listaUsuariosCadastrados.setListData(resultado.toArray(new String[0]));
                    listaUsuariosCadastrados.updateUI();
                }

            }
        }
    }

    /**
     *Quando mudar valor selecionado mostrar uma nova tela de Datalhe de carinho
     * @param e eente de acoes do botao
     */
    public void valueChanged(ListSelectionEvent e) {
        Object src = e.getSource();
        if (e.getValueIsAdjusting() && src == listaUsuariosCadastrados) {
            new DetalheUsuario(2, dados, listaUsuariosCadastrados.getSelectedIndex()).mostrar();
        }
    }
 }

