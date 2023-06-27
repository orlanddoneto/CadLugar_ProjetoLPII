package layouts;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JanelaPrincipal extends JFrame implements ListSelectionListener, ActionListener{
	private JMenuBar menuBar;
	private JMenu menuAbrir;
	private JMenuItem [] itens;
	private JLabel statusBar;
	private JList listBar;
	private JTextArea descricao;
	private final String [] conteudo = {
		"FlowLayout: É o gerenciador de layout mais simples, dispõe os objetos sequencialmente da esquerda para a direita na ordem em que foram adicionados",
		"GridLayout: Divide o container em uma grade de modo que os componentes podem ser colocados em linhas e colunas.",
		"BoxLayout: Permite colocar uma única linha ou coluna de componentes com mais flexibilidade do que o GridLayout.",
		"SpringLayout: Permite posicionar componentes em posições exatas ou relativas com extrema precisão, porém requer um posicionamento em baixo nível.",
		"BorderLayout: Organiza os componentes em cinco áreas:\r\n"+"Norte, Sul, Leste, Oeste e Centro."
	};
		
	public JanelaPrincipal() {
		super("Exemplo Layout");
		String [] menuText = {"FlowLayout", "GridLayout", "BoxLayout", "SpringLayout", "BorderLayout"};
		itens = new JMenuItem[menuText.length];
		menuAbrir = new JMenu("Abrir");
		menuBar = new JMenuBar();
		
		//criando os itens do menu
		for(int i = 0; i < menuText.length; i++) {
			itens[i] = new JMenuItem(menuText[i]);
			itens[i].addActionListener(this);
			menuAbrir.add(itens[i]);
		}
		menuBar.add(menuAbrir);				//adicionando o menu na barra de menu
		add(menuBar, BorderLayout.NORTH);	//adicionando a barra de menu na janela usando BorderLayout

		statusBar = new JLabel("Selecione uma opção no menu ou no painel lateral.");
		add(statusBar, BorderLayout.SOUTH);
		
		listBar = new JList(menuText);
		listBar.setPreferredSize(new Dimension(150,400));
		listBar.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
		listBar.addListSelectionListener(this);
		add(new JScrollPane(listBar), BorderLayout.WEST);
		
		descricao = new JTextArea("Selecione um item ao lado para ver a descrição ou selecione no menu para visualizar uma janela de exemplo.");
		descricao.setLineWrap(true);
		descricao.setWrapStyleWord(true);
		descricao.setEditable(false);
		add(descricao, BorderLayout.CENTER);
	}

	@Override
	public void valueChanged(ListSelectionEvent event) {
		descricao.setText(conteudo[listBar.getSelectedIndex()]);
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == itens[0]) {
			JanelaFlowLayout janela = new JanelaFlowLayout();
			janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			janela.setSize(600, 400);
			janela.setVisible(true);
		}
		else if(event.getSource() == itens[1]) {
			JanelaGridLayout janela = new JanelaGridLayout();
			janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			janela.setSize(600, 400);
			janela.setVisible(true);
		}
		else if(event.getSource() == itens[2]) {
			JanelaBoxLayout janela = new JanelaBoxLayout();
			janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			janela.setSize(600, 400);
			janela.setVisible(true);
		}
		else if(event.getSource() == itens[3]) {
			JanelaSpringLayout janela = new JanelaSpringLayout();
			janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			janela.setSize(600, 400);
			janela.setVisible(true);
		}		
		else if(event.getSource() == itens[4]) {
			JOptionPane.showMessageDialog(this, "A janela principal está utilizando o BorderLayout", "BorderLayout", JOptionPane.INFORMATION_MESSAGE);
		}				
	}
	
}
