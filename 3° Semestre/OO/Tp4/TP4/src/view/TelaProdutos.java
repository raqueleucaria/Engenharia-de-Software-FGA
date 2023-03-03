package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import controle.*;

/**
 * Classe que define os atributos e metodos do objeto
 * @author Vera Lucia Bezerra da Silva e Raquel Eucaria
 * @version 1.0 (April 2022)
 */
public class TelaProdutos implements ActionListener {
    private final JFrame janela;
    private final JLabel titulo;
    private final JButton blusa;
    private final JButton biju;
    private final JButton calca;
    private final ControleDados dados;

    /**
     * Metodo para cnstrucao da tela de produtos
     * @param controleDados  importa valores de ControleDados
     */
    public TelaProdutos(ControleDados controleDados) {
        this.dados = controleDados;

        janela = new JFrame("Controle Produtos");
        titulo = new JLabel("Produtos");
        blusa = new JButton("Blusas");
        biju = new JButton("Bijuteria");
        calca = new JButton("Calca");

        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setBounds(150, 10, 150, 30);
        blusa.setBounds(145, 70, 100, 30);
        biju.setBounds(145, 120, 100, 30);
        calca.setBounds(145, 170, 100, 30);

        janela.setLayout(null);

        janela.add(titulo);
        janela.add(blusa);
        janela.add(biju);
        janela.add(calca);

        janela.setSize(400, 300);
        janela.setLocationRelativeTo(null);

        blusa.addActionListener(this);
        calca.addActionListener(this);
        biju.addActionListener(this);
    }

    /**
     * Metodo para deixar tela visivel
     */
    public void mostrar() {
        this.janela.setVisible(true);
    }

    /**
     * Metodo que recebe os eventos de click dos botoes.
     * As acoes tratadas sao nos botoes blusa , bijuterias e calca
     * @param e evento de acao do botao
     */
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == blusa)
            new TelaBlusa().mostrarDados(dados, 1);

        if (src == biju)
            new TelaBijuteria(dados).mostrar();

        if (src == calca)
            new TelaCalca().mostrarDados(dados, 3);
    }

}
