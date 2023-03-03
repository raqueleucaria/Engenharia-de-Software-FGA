package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controle.ControleDados;
import modelo.Endereco;
import modelo.Usuario;

/**
 * Classe que define os atributos e metodos do objeto
 * @author Vera Lucia Bezerra da Silva e Raquel Eucaria
 * @version 1.0 (April 2022)
 */
public class DetalheUsuario implements ActionListener {
    private final JFrame janela;
    private final JLabel labelNome;
    private final JTextField valorNome;
    private final JLabel labelCPF;
    private final JTextField valorCPF;
    private final JLabel labelTelefone;
    private final JTextField valorTelefone;
    private final JTextField valorTelefoneDD;
    private final JLabel labelTelefoneDD;
    private final JLabel labelPagamento;
    private final JTextField valorPagamento;

    private final JLabel labelEndereco;
    private final JTextField valorEndereco;
    private final JLabel labelCEP;
    private final JTextField valorCEP;
    private final JLabel labelLote;
    private final JTextField valorLote;
    private final JLabel labelComplemento;
    private final JTextField valorComplemento;

    private final JButton botaoExcluir;
    private final JButton botaoSalvar;
    private final ControleDados dados;
    private int posicao;
    private int opcao;


    /**
     * Mostra janela com elementos para cadastrar dados de bijuteria
     *
     * @param opcao         referente a opcao selecionada
     * @param controleDados importa valores de ControleDados
     * @param posicao       refernte a posicao da bijuteria
     */
    public DetalheUsuario(int opcao, ControleDados controleDados, int posicao) {
        this.opcao = opcao;
        this.posicao = posicao;
        dados = controleDados;
        janela = new JFrame();

        //Nome na aba
        if (opcao == 1) {
            janela.setTitle("Cadastro Usuario");
        }
        if (opcao == 2) {
            janela.setTitle("Detalhe Usuario");
        }

        labelNome = new JLabel("Nome: ");
        labelCPF = new JLabel("CPF: ");
        labelTelefone = new JLabel("Telefone: ");
        labelTelefoneDD = new JLabel("DDD: ");
        labelPagamento = new JLabel("Pagamento: ");

        labelEndereco = new JLabel("Endereco:");
        labelComplemento = new JLabel("Complemento: ");
        labelLote = new JLabel("Lote: ");
        labelCEP = new JLabel("CEP: ");

        botaoExcluir = new JButton("Excluir");
        botaoSalvar = new JButton("Salvar");


        // Mostrar dados cadastrados
        if (opcao == 2) {
            Usuario usuarioSelecionado = dados.getUsuarios().get(posicao);
            valorNome = new JTextField(usuarioSelecionado.getNome(), 200);
            valorCPF = new JTextField(String.valueOf(usuarioSelecionado.getCpf()), 200);
            valorPagamento = new JTextField(valueOf(usuarioSelecionado.getPagamento()), 200);

            if (usuarioSelecionado.getTelefone() != null) {
                valorTelefone = new JTextField(valueOf(usuarioSelecionado.getTelefone().getNumero()), 200);
                valorTelefoneDD = new JTextField(valueOf(usuarioSelecionado.getTelefone().getDdd()), 200);
            } else {
                valorTelefone = new JTextField(200);
                valorTelefoneDD = new JTextField(200);
            }

            Endereco endereco = usuarioSelecionado.getEndereco();
            if (endereco != null) {
                valorEndereco = new JTextField(endereco.getNomeRuaAvenida(), 200);
                valorComplemento = new JTextField(endereco.getComplemento(), 200);
                valorLote = new JTextField(valueOf(endereco.getLote()), 200);
                valorCEP = new JTextField(valueOf(endereco.getCEP()), 200);
            } else {
                valorEndereco = new JTextField(200);
                valorComplemento = new JTextField(200);
                valorLote = new JTextField(200);
                valorCEP = new JTextField(200);
            }

            // Inserir dados
        } else {
            valorNome = new JTextField(200);
            valorCPF = new JTextField(200);
            valorTelefone = new JTextField(200);
            valorTelefoneDD = new JTextField(200);
            valorPagamento = new JTextField(200);

            valorEndereco = new JTextField(200);
            valorComplemento = new JTextField(200);
            valorLote = new JTextField(200);
            valorCEP = new JTextField(200);

            botaoSalvar.setBounds(245, 300, 115, 30);
        }

        labelNome.setBounds(30, 20, 150, 25);
        valorNome.setBounds(130, 20, 230, 25);

        labelCPF.setBounds(30, 50, 150, 25);
        valorCPF.setBounds(130, 50, 230, 25);

        labelTelefoneDD.setBounds(30, 80, 150, 25);
        valorTelefoneDD.setBounds(130, 80, 230, 25);

        labelTelefone.setBounds(30, 110, 150, 25);
        valorTelefone.setBounds(130, 110, 230, 25);

        labelEndereco.setBounds(30, 140, 150, 25);
        valorEndereco.setBounds(130, 140, 230, 25);
        labelComplemento.setBounds(30, 170, 150, 25);
        valorComplemento.setBounds(130, 170, 230, 25);
        labelLote.setBounds(30, 200, 150, 25);
        valorLote.setBounds(130, 200, 230, 25);
        labelCEP.setBounds(30, 230, 150, 25);
        valorCEP.setBounds(130, 230, 230, 25);

        labelPagamento.setBounds(30, 260, 150, 25);
        valorPagamento.setBounds(130, 260, 230, 25);

        if (opcao == 2) {
            botaoSalvar.setBounds(100, 300, 115, 30);
            botaoExcluir.setBounds(240, 300, 115, 30);
            this.janela.add(botaoExcluir);
        }
        this.janela.add(labelNome);
        this.janela.add(valorNome);
        this.janela.add(labelCPF);
        this.janela.add(valorCPF);
        this.janela.add(labelTelefoneDD);
        this.janela.add(valorTelefoneDD);
        this.janela.add(labelTelefone);
        this.janela.add(valorTelefone);
        this.janela.add(labelPagamento);
        this.janela.add(valorPagamento);
        this.janela.add(labelEndereco);
        this.janela.add(valorEndereco);
        this.janela.add(labelComplemento);
        this.janela.add(valorComplemento);
        this.janela.add(labelLote);
        this.janela.add(valorLote);
        this.janela.add(labelCEP);
        this.janela.add(valorCEP);
        this.janela.add(botaoSalvar);


        this.janela.setLayout(null);

        this.janela.setSize(400, 400);
        janela.setLocationRelativeTo(null);
        this.janela.setVisible(true);

        botaoSalvar.addActionListener(this);
        botaoExcluir.addActionListener(this);
    }

    // chama funcoees la em controle de dados
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == botaoSalvar) {
            try {
                boolean res;
                final String[] novoDado = new String[10];
                if (opcao == 1)
                    novoDado[0] = String.valueOf(dados.getUsuarios().size());
                else
                    novoDado[0] = Integer.toString(posicao);

                novoDado[1] = valorNome.getText();
                novoDado[2] = valorCPF.getText();
                novoDado[3] = valorTelefoneDD.getText();
                novoDado[4] = valorTelefone.getText();
                novoDado[5] = valorPagamento.getText();
                novoDado[6] = valorEndereco.getText();
                novoDado[7] = valorComplemento.getText();
                novoDado[8] = valorLote.getText();
                novoDado[9] = valorCEP.getText();

                if (!Validador.validaCPF(novoDado[2])) {
                    mensagemErroCadastro();
                    return;
                }

                if (!Validador.validaTelefone(novoDado[3] + novoDado[4])) {
                    mensagemErroCadastro();
                    return;
                }

                res = dados.inserirEditarUsuario(novoDado);

                if (res) {
                    mensagemSucessoCadastro();
                } else {
                    mensagemErroCadastro();
                }
            } catch (NullPointerException | NumberFormatException ex) {
                ex.printStackTrace();
                mensagemErroCadastro();
            }
        }
        if (src == botaoExcluir) {
            boolean res = false;
            if (opcao == 2) {
                res = dados.removerUsuario(posicao);
                if (res)
                    mensagemSucessoExclusao();
                else
                    mensagemErroExclusao();
            }

        }

    }

    /**
     * Exibe uma janela com mensagem de usuario excluido com sucesso.
     */
    public void mensagemSucessoExclusao() {
        JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", null,
                JOptionPane.INFORMATION_MESSAGE);
        janela.dispose();
    }

    /**
     * Exibe uma janela com a mensagem de usuario cadastrado com sucesso
     */
    public void mensagemSucessoCadastro() {
        JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null,
                JOptionPane.INFORMATION_MESSAGE);
        janela.dispose();
    }

    /**
     * Exibe uma mensagem de erro com possiveis erros cometidos ao cadastrar usuario
     */
    public void mensagemErroCadastro() {
        JOptionPane.showMessageDialog(null,
                "ERRO AO SALVAR OS DADOS!\n " + "Pode ter ocorrido um dos dois erros a seguir:  \n"
                        + "1. Nem todos os campos foram preenchidos \n"
                        + "2. CPF, Telefone, Pagamento e Endereco nao contem apenas numeros",
                null, JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Exibe uma mensagem de erro ao tentar excluir usuario
     */
    public void mensagemErroExclusao() {
        JOptionPane.showMessageDialog(null, "Ocorreu um erro ao excluir o dado.\n ",
                null, JOptionPane.ERROR_MESSAGE);
    }

    public String valueOf(Object obj) {
        return (obj == null) ? "" : obj.toString();
    }

    /**
     * Para daixar janela visivel
     */
    public void mostrar() {
        janela.setVisible(true);
    }
}