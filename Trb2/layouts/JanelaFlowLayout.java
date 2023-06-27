package layouts;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class JanelaFlowLayout extends JDialog implements ActionListener{
	
	private JLabel nome;
	private JLabel email;
	private JTextField textNome;
	private JTextField textEmail;
	private JButton enviar;
	private FlowLayout layout;
	
	public JanelaFlowLayout() {
		setTitle("Exemplo FlowLayout");
		setModal(true); //para desabilitar a janela que chamou
		nome = new JLabel("Nome:");
		email = new JLabel("E-mail:");
		textNome = new JTextField(20);
		textEmail = new JTextField(20);
		enviar = new JButton("Enviar");
		layout = new FlowLayout();
		
		enviar.addActionListener(this);
		
		setLayout(layout);
		add(nome);
		add(textNome);
		add(email);
		add(textEmail);
		add(enviar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showConfirmDialog(this, "Seu e-mail é: "+textEmail.getText(), "Olá "+textNome.getText(), JOptionPane.YES_NO_OPTION);
	}
}
