package view;

import javax.swing.*;

/**
 * Classe com metodos utilitarios para construcao de telas usando Java Swing
 */
public class Utilitario {

    /**
     * Exibe uma janela com mensagem de item excluido com sucesso.
     * Se o parametro janela nao for nulo, tenta fechar a janela.
     * @param janela janela a ser feichada apos a exibicao da mensagem
     */
    public static void mensagemSucessoExclusao(JFrame janela) {
        JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", "Sucesso",
                JOptionPane.INFORMATION_MESSAGE);
        if (janela != null) {
            janela.dispose();
        }
    }

    /**
     * Exibe uma janela com mensagem de item cadastrado com sucesso.
     * Se o parametro janela nao for nulo, tenta fechar a janela.
     * @param janela janela a ser feichada apos a exibicao da mensagem
     */
    public static void mensagemSucessoCadastro(JFrame janela) {
        JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", "Sucesso",
                JOptionPane.INFORMATION_MESSAGE);
        if (janela != null) {
            janela.dispose();
        }
    }

    /**
     * Exibe uma janela com mensagem de erro ao cadastrar item.
     */
    public static void mensagemErroCadastro() {
        JOptionPane.showMessageDialog(null,
                "ERRO AO SALVAR OS DADOS!\n " + "Pode ter ocorrido um dos dois erros a seguir:  \n"
                        + "1. Nem todos os campos foram preenchidos \n"
                        + "2. Tamanho ou preco nao contem apenas numeros",
                "Erro", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Exibe uma janela com mensagem de erro ao adicionar item no carrinho.
     */
    public static void mensagemErroAddCarrinho() {
        JOptionPane.showMessageDialog(null,
                "erro ao adicionar produto no carrinho",
                "Erro", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Exibe uma janela com mensagem de erro ao tentar excluir item.
     */
    public static void mensagemErroExclusao() {
        JOptionPane.showMessageDialog(null, "Ocorreu um erro ao excluir o dado.\n ",
                "Erro", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Exibe uma janela com mensagem de sucesso do item adicionado ao carrinho.
     * Se o parametro janela nao for nulo, tenta fechar a janela.
     * @param janela janela a ser feichada apos a exibicao da mensagem
     */
    public static void mensagemSucessoCarrinho(JFrame janela) {
        JOptionPane.showMessageDialog(janela, "Produto adicionado ao carrinho.", "Sucesso",
                JOptionPane.INFORMATION_MESSAGE);
        if (janela != null) {
            janela.dispose();
        }
    }

}
