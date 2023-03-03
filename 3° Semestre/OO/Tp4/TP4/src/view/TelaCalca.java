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
import modelo.Calca;

/**
 * Classe que define os atributos e metodos do objeto
 * @author Vera Lucia Bezerra da Silva e Raquel Eucaria
 * @version 1.0 (April 2022)
 */
public class TelaCalca implements ActionListener, ListSelectionListener{
	
	private JFrame janela;
	private JLabel titulo;
	private JButton cadastro;
	private JButton atualiza;
	private JButton busca;
	private JTextField nomeBusca;
	private ControleDados dados;
	private JList<String> listaCalcasCadastradas;
	private String[] listaCodigos = new String[10];

	/**
	 * Metodo que mosta tela de blusas para cadastrar
 	 * @param d referente a dados de calca
	 * @param op referente a opcao selecionada
	 */
	public void mostrarDados(ControleDados d, int op) {
		dados = d;
		
		if(op == 3) {
			listaCodigos = new ControleCalcas(dados).getNome();
			listaCalcasCadastradas = new JList<String>(listaCodigos);
			janela = new JFrame("Calcas");
			titulo = new JLabel("Calcas Cadastradas");
			
			cadastro = new JButton("Cadastrar");
			atualiza = new JButton("Atualizar");
			busca = new JButton("Pesquisar");
			nomeBusca = new JTextField();

			
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaCalcasCadastradas.setBounds(20, 50, 350, 120);
			listaCalcasCadastradas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaCalcasCadastradas.setVisibleRowCount(10);

			cadastro.setBounds(70, 190, 100, 30);
			atualiza.setBounds(200, 190, 100, 30);
			nomeBusca.setBounds(20, 240, 230, 30);
			busca.setBounds(270, 240, 100, 30);
			
			janela.setLayout(null);

			janela.add(titulo);
			janela.add(listaCalcasCadastradas);
			janela.add(cadastro);
			janela.add(atualiza);
			janela.add(nomeBusca);
			janela.add(busca);
			
			janela.setSize(400, 320);
			janela.setLocationRelativeTo(null);
			janela.setVisible(true);
			
			cadastro.addActionListener(this);
			atualiza.addActionListener(this);
			busca.addActionListener(this);
			listaCalcasCadastradas.addListSelectionListener(this);
		}else {

			JOptionPane.showMessageDialog(null, "Opcao invalida!", null, JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Metodo que recebe os eventos de click dos botoes.
	 * As acoes tratadas sao cadastro, atualizar ou buscar calca da lista
	 * @param e evento de acao do botao
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		
		//Cadastrar
		if (src == cadastro)
			new DetalheCalca(1, dados, 0).mostrar();
		
		//Atualizar
		if (src == atualiza) { 
			listaCalcasCadastradas.setListData(new ControleCalcas(dados).getNome());
			listaCalcasCadastradas.updateUI();
		}
		
		//buscar
		if (src == busca) { 
			String digitado = nomeBusca.getText();
			int i = 0;
			List<String> resultado = new ArrayList<>(0);
			boolean encontrou = false;

			for(Calca calca : dados.getDados().getCalcas()){
				if(calca == null){
					continue;
				}
				String nome = calca.getNome();
				if(nome.toUpperCase().contains(digitado.toUpperCase())){
					resultado.add(nome);
					encontrou = true;
				}
			}
			if(encontrou){
				listaCalcasCadastradas.setListData(resultado.toArray(new String[0]));
				listaCalcasCadastradas.updateUI();
			} else{
				mensagemErroBusca();
			}
		}
	}
	/**
	 * Quando mudar valor selecionado mostrar uma nova tela de Datalhe de bijuteria
	 * @param e
	 */
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		if (e.getValueIsAdjusting() && src == listaCalcasCadastradas) {
			new DetalheCalca(2, dados, listaCalcasCadastradas.getSelectedIndex()).mostrar();
		}
	}
	/**
	 * Exibe uma janela com mensagem de erro quando calca nao for encontrada
	 */
	public void mensagemErroBusca() {
		JOptionPane.showMessageDialog(null,"Calca nao encontrada.\n " , null,
				JOptionPane.ERROR_MESSAGE);
	}
}
