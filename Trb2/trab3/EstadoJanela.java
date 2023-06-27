package trab3;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JDialog;

public class EstadoJanela extends JDialog implements ActionListener {
	private JLabel nome;
	private JLabel sigla;
	private JLabel capital;
	private JLabel PIB;
	private JLabel IDH;
	private JLabel populacao;
	private JLabel area;
	private JTextField textNome;
	private JTextField textSigla;
	private JTextField textCapital;
	private JTextField textPIB;
	private JTextField textIDH;
	private JTextField textPopulacao;
	private JTextField textArea;
	private JButton enviar;
	private FlowLayout layout;
	private static Pais pais;
	private static Regiao regiao;
	private static Estado novo;
	private ArrayList <String> vazio = new ArrayList<>();
	public EstadoJanela(){
		
		try {
			setResizable(false);
			pais = Main.acharPais();
			regiao = Main.acharRegiao(pais);
			if (regiao == null || pais == null) {
				throw new Exception("Campos nulos");
			}
			vazio.add("");
			vazio.add(" ");
			setTitle("Cadastro de Estado");
			setModal(true); //para desabilitar a janela que chamou
			nome = new JLabel("Nome do Estado:");
			sigla = new JLabel("Sigla do Estado:");
			capital = new JLabel("Capital do Estado:");
			PIB = new JLabel("PIB do Estado");
			IDH = new JLabel("IDH do Estado");
			populacao = new JLabel("População do Estado");
			area = new JLabel("Area do Estado");
			textNome = new JTextField(20);
			textSigla = new JTextField(20);
			textCapital = new JTextField(20);
			textPIB = new JTextField(20);
			textIDH = new JTextField(20);
			textPopulacao = new JTextField(20);
			textArea = new JTextField(20);
			enviar = new JButton("Enviar");
			layout = new FlowLayout();
			enviar.addActionListener(this);
			
			setLayout(layout);
			add(nome);
			add(textNome);
			add(sigla);
			add(textSigla);
			add(capital);
			add(textCapital);
			add(PIB);
			add(textPIB);
			add(IDH);
			add(textIDH);
			add(populacao);
			add(textPopulacao);
			add(area);
			add(textArea);
			add(enviar);
		}
		catch(Exception erro) {
			JOptionPane.showMessageDialog(rootPane, "País ou Região não encontrado(a)!");
			
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String estado, sigla, capital;
			float pib = 0.0f, idh = 0.0f;
			int pop;
			Double area; 
			estado = textNome.getText();
			sigla = textSigla.getText();
			capital = textCapital.getText();
			try {
				pib = Float.parseFloat(textPIB.getText());
				idh = Float.parseFloat(textIDH.getText());
				pop = Integer.parseInt(textPopulacao.getText());
				area = Double.parseDouble(textArea.getText());
				if(vazio.contains(estado) || vazio.contains(sigla) || vazio.contains(capital)|| vazio.contains(pib)|| vazio.contains(idh)
						|| vazio.contains(pop)|| vazio.contains(area)) {
					throw new Exception("CamposVazios");
				}
				
				if (estado.chars().allMatch( Character::isDigit )||sigla.chars().allMatch( Character::isDigit ) 
						||capital.chars().allMatch( Character::isDigit )) {
					throw new Exception("TemNumero");
				}
				
				novo = new Estado( estado, sigla, area, pop, pib, idh, capital, pais);
				regiao.addEstado(novo);
				if (regiao.getEstados().contains(novo)) {
					this.dispose();
				}
			}
			catch(NumberFormatException error) {
				JOptionPane.showMessageDialog(rootPane, "É necessário que todos os campos sejam preenchidos corretamente!");
			}
				
		}
		catch(Exception Erro) {
			JOptionPane.showMessageDialog(rootPane, "É necessário que todos os campos sejam preenchidos corretamente!");
		}
		
	}
	
	public Pais getPais() {
		return pais;
	}
	public Regiao getRegiao() {
		return regiao;
	}
	
	public Estado getEstado() {
		return novo;
	}

}
