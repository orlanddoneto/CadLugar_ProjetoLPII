package trab3;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Font;

public class BannerJanela extends JDialog implements ActionListener {
	private ImageIcon brasil;
	private ImageIcon usa;
	private ImageIcon japao;
	private ImageIcon maranhao;
	private ImageIcon minas;
	private ImageIcon inglaterra;
	private ImageIcon portugal;
	private ImageIcon saoPaulo;
	private JLabel Ibrasil;
	private JLabel Iusa;
	private JLabel Ijapao;
	private JLabel Imaranhao;
	private JLabel nome;
	private JLabel Iminas;
	private JLabel Iinglaterra;
	private JLabel Iportugal;
	private JLabel IsaoPaulo;
	private JButton start;
	private FlowLayout layout;
	BannerJanela(){
		brasil = new ImageIcon(getClass().getResource("bandeiraBrasil.gif"));
		brasil.setImage(brasil.getImage().getScaledInstance(50, 50, 10));
		Ibrasil = new JLabel(brasil);
		
		usa = new ImageIcon(getClass().getResource("bandeiraUsa.gif"));
		usa.setImage(usa.getImage().getScaledInstance(50, 50, 10));
		Iusa = new JLabel(usa);
		
		japao = new ImageIcon(getClass().getResource("japao.gif"));
		japao.setImage(japao.getImage().getScaledInstance(50, 50, 10));
		Ijapao = new JLabel(japao);
		
		maranhao = new ImageIcon(getClass().getResource("maranhao.gif"));
		maranhao.setImage(maranhao.getImage().getScaledInstance(50, 50, 10));
		Imaranhao = new JLabel(maranhao);
		
		minas = new ImageIcon(getClass().getResource("minas.gif"));
		minas.setImage(minas.getImage().getScaledInstance(50, 50, 10));
		Iminas = new JLabel(minas);
		
		inglaterra = new ImageIcon(getClass().getResource("inglaterra.gif"));
		inglaterra.setImage(inglaterra.getImage().getScaledInstance(50, 50, 10));
		Iinglaterra = new JLabel(inglaterra);
		
		portugal = new ImageIcon(getClass().getResource("portugal.gif"));
		portugal.setImage(portugal.getImage().getScaledInstance(50, 50, 10));
		Iportugal = new JLabel(portugal);
		
		
		saoPaulo = new ImageIcon(getClass().getResource("saoPaulo.gif"));
		saoPaulo.setImage(saoPaulo.getImage().getScaledInstance(50, 50, 10));
		IsaoPaulo = new JLabel(saoPaulo);
		
		nome = new JLabel("  CadLugar  ");
		nome.setFont(new Font("Courier New",Font.CENTER_BASELINE,35));
		
		start = new JButton("Iniciar");
		start.addActionListener(this);
		
		layout = new FlowLayout();
		setLayout(layout);
		
		add(Ibrasil,CENTER_ALIGNMENT);
		add(Iusa);
		add(Ijapao);
		add(Imaranhao);
		add(nome);
		add(Iminas);
		add(Iinglaterra);
		add(Iportugal);
		add(IsaoPaulo);
		add(start);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
		PrincipalJanela app = new PrincipalJanela();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(350, 360);
		app.setVisible(true);
		
	}
}
