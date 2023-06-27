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

public class RegiaoJanela extends JDialog implements ActionListener {
	private JLabel nome;
	private JLabel sigla;
	private JTextField textNome;
	private JTextField textSigla;
	private JButton enviar;
	private FlowLayout layout;
	private static Pais pais;
	private ArrayList <String> vazio = new ArrayList<>();
	
	public RegiaoJanela(Pais nacao) {
		setResizable(false);
		setTitle("Cadastro de Região");
		vazio.add("");
		vazio.add(" ");
		if (nacao!=null) { // nem precisa dessa comparação, já que foi tratado na exception em PrincipalJanela.
			setModal(true); //para desabilitar a janela que chamou
			nome = new JLabel("Nome da região:");
			sigla = new JLabel("Sigla da região:");
			textNome = new JTextField(20);
			textSigla = new JTextField(20);
			enviar = new JButton("Enviar");
			layout = new FlowLayout();
			
			enviar.addActionListener(this);
			
			setLayout(layout);
			add(nome);
			add(textNome);
			add(sigla);
			add(textSigla);
			add(enviar);
			pais = nacao;
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String regiao, sigla;
			regiao = textNome.getText();
			sigla = textSigla.getText();
			if(vazio.contains(regiao) || vazio.contains(sigla)) {
				throw new Exception("CamposNulos");
			}
			if (regiao.chars().allMatch( Character::isDigit )||sigla.chars().allMatch( Character::isDigit )) {
				throw new Exception("TemNumero");
			}
			
			Regiao novo = new Regiao( regiao, sigla );
			pais.addRegiao(novo);
			if (pais.getRegioes().contains(novo)) {
				this.dispose();
			}
		}
		
		catch(Exception Erro) {
			JOptionPane.showMessageDialog(rootPane, "É necessário que todos os campos sejam preenchidos corretamente!");
		}
		
		
		
	}
	
	
	
	
}
