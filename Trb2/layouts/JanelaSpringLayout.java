package layouts;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class JanelaSpringLayout extends JDialog implements ActionListener{
	private JLabel nome;
	private JLabel email;
	private JTextField textNome;
	private JTextField textEmail;
	private JButton enviar;
	private SpringLayout layout;
	
	public JanelaSpringLayout() {
		setTitle("Exemplo SpringLayout");
		setModal(false); //para desabilitar a janela que chamou
		nome = new JLabel("Nome:");
		email = new JLabel("E-mail:");
		textNome = new JTextField(20);
		textEmail = new JTextField(20);
		enviar = new JButton("Enviar");
		layout = new SpringLayout(); //3 linhas e 2 colunas
		
		enviar.addActionListener(this);
		
		setLayout(layout);
		
		//posicionando o label nome
		layout.putConstraint(SpringLayout.NORTH, nome, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, nome, 10, SpringLayout.WEST, this);

		//posicionando o text nome
		layout.putConstraint(SpringLayout.NORTH, textNome, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, textNome, 10, SpringLayout.EAST, nome);

		//posicionando o label email
		layout.putConstraint(SpringLayout.NORTH, email, 10, SpringLayout.SOUTH, nome);
		layout.putConstraint(SpringLayout.WEST, email, 8, SpringLayout.WEST, this);

		//posicionando o text email
		layout.putConstraint(SpringLayout.NORTH, textEmail, 10, SpringLayout.SOUTH, nome);
		layout.putConstraint(SpringLayout.WEST, textEmail, 10, SpringLayout.EAST, email);		
		

		//posicionando o botao
		layout.putConstraint(SpringLayout.NORTH, enviar, 10, SpringLayout.SOUTH, textEmail);
		layout.putConstraint(SpringLayout.EAST, enviar, 0, SpringLayout.EAST, textEmail);
		
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



/*
if (i==0) {
	layout.putConstraint(SpringLayout.NORTH, itens[i], 10, SpringLayout.NORTH, this);
	layout.putConstraint(SpringLayout.WEST, itens[i], 10, SpringLayout.WEST, this);

}
else {
	layout.putConstraint(SpringLayout.NORTH, itens[i], 10, SpringLayout.SOUTH, itens[i-1]);
	layout.putConstraint(SpringLayout.WEST, itens[i], 10, SpringLayout.WEST, this);
*/
