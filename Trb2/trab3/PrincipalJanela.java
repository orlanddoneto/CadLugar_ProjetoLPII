package trab3;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



public class PrincipalJanela extends JFrame implements ListSelectionListener, ActionListener {
	 
	private JTextArea console;
	private JTextField campo;
	private JMenuItem [] itens;
	private JMenuBar menuBar;
	private SpringLayout layout;
	private JMenu menuAbrir;
	private JScrollPane barra;
	
	public PrincipalJanela() {
		String [] menuText = {"Cadastrar Pais", "Cadastrar Região", "Cadastrar Estado", "Carregar Arquivo", 
				"Dados Pais", "Dados Região", "Dados Estado"};
		menuBar = new JMenuBar();
		itens = new JMenuItem[menuText.length];
		layout = new SpringLayout();
		menuAbrir = new JMenu("Operações");
		
		for(int i = 0; i < menuText.length; i++) {
			itens[i] = new JMenuItem(menuText[i]);
			itens[i].addActionListener(this);
			menuAbrir.add(itens[i]);
		}
		menuBar.add(menuAbrir);
		add(menuBar,BorderLayout.NORTH);
		
		
		console = new JTextArea("Clique em Operações");
		console.setLineWrap(true); // QUEBRA LINHA AUTOMATICA
		console.setWrapStyleWord(true);
		console.setEditable(false);
		//console.setPreferredSize(new Dimension(150,400));
		barra = new JScrollPane(console);
		add(barra, BorderLayout.CENTER);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == itens[0]) {
			int tam1 = Main.getPaises().size();
			PaisJanela janela = new PaisJanela();
			janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			janela.setSize(260, 250);
			janela.setVisible(true);
			
			int tam2 = Main.getPaises().size();
			if (tam2>tam1)
				console.setText("País Cadastrado!");
			
		}
		else if (e.getSource() == itens[1]) {
			try {
				Pais nacao = Main.acharPais();
				int tam1 = nacao.getRegioes().size();
				RegiaoJanela janela = new RegiaoJanela(nacao);
				janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				janela.setSize(260, 250);
				janela.setVisible(true);
				int tam2 = nacao.getRegioes().size();
				if (tam2>tam1) {
					console.setText("Região Cadastrada!");
				}
			}
			catch(NullPointerException erro) {
				JOptionPane.showMessageDialog(rootPane, "País não encontrado!");
			
			}
			
			
		}
		
		
		else if (e.getSource() == itens[2]) {
			EstadoJanela janela = new EstadoJanela();
			try {
				
				janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				janela.setSize(260, 550);
				janela.setVisible(true);
				if(janela.getRegiao().getEstados().contains(janela.getEstado())) {
					console.setText("Estado Cadastrado!");
				}
			}
			catch(NullPointerException erro) {
				janela.dispose();
				JOptionPane.showMessageDialog(rootPane, "Não foi possível realizar o cadastramento de Estado");
				
			}
			
			
			
		}
		else if (e.getSource() == itens[3]) {
			
			Pais pais2 = Main.acharPais();
			if (pais2 == null) {
				console.setText("Pais não encontrado!");
			}
			else {
				boolean res = Main.carregar("C:\\Users\\Cliente\\eclipse-workspace\\Trab2LPII\\Trb2\\trabalho\\estados.txt", pais2);
				if (!res) {
					console.setText("Arquivo não carregado");
				}
				else {
					console.setText("Arquivo Carregado");
					
				}
			}

		}
		
		else if (e.getSource() == itens[4]) {
			Pais pais = Main.acharPais();
			if (pais == null) {
				console.setText("País não encontrado");
			}
			else {
				console.setText("Informações do País"+ "\n");
				for ( String info : pais.getInformacao()) {
					console.append(info);
				}
			}
		}
		
		else if (e.getSource() == itens[5]) {
			try {
				Pais pais = Main.acharPais();
				if (pais == null) {
					console.setText("País não encontrado");
				}
				Regiao regiao = Main.acharRegiao(pais);
				if (regiao == null) {
					console.setText("Região não encontrada");
				}
				
				else {
					console.setText("Informações da Região"+"\n");
					for (String info : regiao.getInformacao()) {
						console.append(info);
					}
				}
			}
			catch(NullPointerException erro) {
				JOptionPane.showMessageDialog(rootPane, "Não foi possível completar a busca. Insira dados válidos");
				
			}
			
			
			
			
		}
		else if (e.getSource() == itens[6]) {
			try {
				Pais pais = Main.acharPais();
				if (pais == null) {
					console.setText("País não encontrado");
				}
				Regiao regiao = Main.acharRegiao(pais);
				if (regiao == null) {
					console.setText("Região não encontrada");
				}
				Estado estado = Main.acharEstado(regiao);
				if (estado == null) {
					console.setText("Estado não encontrado");
				}
				
				else {
					console.setText("Informações do Estado"+"\n");
					for (String info: estado.getInformacao()) {
						console.append(info);
					}
				}
			}
			catch(NullPointerException erro) {
				JOptionPane.showMessageDialog(rootPane, "Não foi possível completar a busca. Insira dados válidos");
				
			}
			
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		
		
	}
	
	
	
	
}
