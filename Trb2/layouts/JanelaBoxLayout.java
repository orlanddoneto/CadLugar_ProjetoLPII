package layouts;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JanelaBoxLayout extends JDialog implements ActionListener{

	private JLabel nome;
	private JLabel email;
	private JTextField textNome;
	private JTextField textEmail;
	private JButton enviar;
	
	public JanelaBoxLayout() {
		setTitle("Exemplo BoxLayout");
		setModal(true); //para desabilitar a janela que chamou
		JPanel pane1 = new JPanel();
		JPanel pane2 = new JPanel();
		nome = new JLabel("Nome:");
		email = new JLabel("E-mail:");
		textNome = new JTextField(20);
		textEmail = new JTextField(20);
		enviar = new JButton("Enviar");

	    Box box = Box.createVerticalBox(); // create box vertical
		
		enviar.addActionListener(this);
		
		pane1.add(nome);
		pane1.add(textNome);
		pane2.add(email);
		pane2.add(textEmail);
		box.add(pane1);
		box.add(pane2);
		box.add(enviar);
		
		add(box);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showConfirmDialog(this, "Seu e-mail é: "+textEmail.getText(), "Olá "+textNome.getText(), JOptionPane.YES_NO_OPTION);
	}
}
