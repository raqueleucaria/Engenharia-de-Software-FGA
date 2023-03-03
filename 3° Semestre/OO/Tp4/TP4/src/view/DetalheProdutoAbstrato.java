package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe que define os atributos e metodos do objeto
 * @author Vera Lucia Bezerra da Silva e Raquel Eucaria
 * @version 1.0 (April 2022)
 */
public abstract class DetalheProdutoAbstrato implements ActionListener {

    protected final JFrame janela;
    protected final JButton botaoCarrinho = new JButton("Adicionar ao carrinho");


    public abstract boolean addItemSelecionadoCarrinho();

    /**
     * Metodo para adiciona botao carrinho na janela
     * @param janela janela para adicionar botao no carrinho
     */
    public DetalheProdutoAbstrato(JFrame janela) {
        this.janela = janela;
        botaoCarrinho.addActionListener(this);
        this.janela.add(botaoCarrinho);
    }

    /**
     * Metodo paara deixar janela visivel
     */
    public void mostrar(){
        this.janela.setVisible(true);
    }

    /**
     * Metodo que recebe os eventos de click dos botoes
     * @param e evento de acao do botao
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (botaoCarrinho == e.getSource()) {
            if (addItemSelecionadoCarrinho()) {
                Utilitario.mensagemSucessoCarrinho(this.janela);
            } else {
                Utilitario.mensagemErroAddCarrinho();
            }
        }
    }
}
