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

public class PaisJanela extends JDialog implements ActionListener {
	private JLabel nome;
	private JLabel sigla;
	private JLabel capital;
	private JTextField textNome;
	private JTextField textSigla;
	private JTextField textCapital;
	private JButton enviar;
	private FlowLayout layout;
	private ArrayList <String> vazio = new ArrayList<>();
	
	
	PaisJanela(){
		setResizable(false);
		vazio.add("");
		vazio.add(" ");
		setTitle("Cadastro de País");
		setModal(true); //para desabilitar a janela que chamou
		nome = new JLabel("Nome do país:");
		sigla = new JLabel("Sigla do país:");
		capital = new JLabel("Capital do país:");
		textNome = new JTextField(20);
		textSigla = new JTextField(20);
		textCapital = new JTextField(20);
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
		add(enviar);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			String pais, sigla, capital;
			pais = textNome.getText();
			sigla = textSigla.getText();
			capital = textCapital.getText(); 
			if(vazio.contains(pais) || vazio.contains(capital) || vazio.contains(sigla)) {
				throw new Exception("CamposNulos");
			}
			if (pais.chars().allMatch( Character::isDigit )||sigla.chars().allMatch( Character::isDigit )||capital.chars().allMatch( Character::isDigit )) {
				throw new Exception("TemNumero");
			}
			else {
				Pais novo = new Pais( pais, sigla, capital);
				Main.paises.add(novo);
				if (Main.getPaises().contains(novo)) {
					
					this.dispose();
				}
			}
		}
		catch(Exception CamposNulos) {
			JOptionPane.showMessageDialog(rootPane, "É necessário que todos os campos sejam preenchidos corretamente!");
		}
		
		
	}
	
}
