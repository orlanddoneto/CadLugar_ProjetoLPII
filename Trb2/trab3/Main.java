package trab3;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import javax.imageio.IIOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Main {
    public static ArrayList<Pais> paises;
    public static Scanner input;
  
    public static void main(String[] args) {
        input = new Scanner(System.in);
        paises = new ArrayList<Pais>();
        BannerJanela app = new BannerJanela();
		app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		app.setSize(290, 270);
		app.setVisible(true);
		//app.setResizable(false);
    }

    
    public static void carregarArquivo(){
        System.out.println("Digite o nome da Pais que deseja adicionar os Estados: ");
        String nome = input.nextLine();

        Pais pais = procurarPaisPor("nome", nome);
        if(pais == null){
            System.out.println("Pais não encontrado!\n");  
            
        }else{
            boolean res = carregar("estados.txt", pais);
            if(!res){
                System.out.println("Arquivo não carregado\n");  
                return;
            }else{
                System.out.println("Arquivo carregado\n");  
            }
        }
    }
    
    public static Pais procurarPaisPor(String tipo, String valor){
        Pais procurado = null;

        for (Pais p : paises) {
            if(tipo == "nome"){
                if( p.getNome().equals(valor) ){ procurado = p; }
            }else if(tipo == "sigla"){
                if( p.getSigla().equals(valor)){ procurado = p; }
            }else if(tipo == "capital"){
                if( p.getCapital().equals(valor)){ procurado = p; }
            }
        }
        
        return procurado;
    }
    public static boolean carregar(String data, Pais pais){

        BufferedReader content = null;

        String line = "", separator = "; ";

        //ArrayList<Regiao> regioes = pais.getRegioes();

        try {

            content = new BufferedReader(new FileReader(data));
            while ((line = content.readLine()) != null) {
                boolean condition = true;
                String[] state = line.split(separator);
                String nome = state[0];
                String sigla = state[1];
                String capital = state[2];
                Double area = Double.parseDouble(state[4]);
                int populacao = Integer.parseInt(state[5]);
                Float IDH = Float.parseFloat(state[6]);
                Float PIB = Float.parseFloat(state[7]);
                
                Estado novo = new Estado( nome, sigla, area, populacao, PIB, IDH, capital, pais);
                
                for (Regiao regiao : pais.getRegioes()) {
                    //regiao.update();
                    if (state[3].equals(regiao.getNome())) {
                        regiao.addEstado(novo);
                        condition = false;
                    }
                }
                if (condition) {
                    pais.addRegiao(new Regiao(state[3], "BR"));
                    for (Regiao regiao : pais.getRegioes()) {
                        //regiao.update();
                        if (state[3].equals(regiao.getNome())) {
                            regiao.addEstado(novo);
                        }
                    }
                }
            }
        } catch (FileNotFoundException fi) {
            System.out.println("Arquivo de dados não encontrado" + fi.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (content != null) {
                try {
                    content.close();
                } catch (IOException io) {
                    System.out.println("Fatal Error" + io.getMessage());
                }
            }
        }
        return true;
    }

    public static ArrayList<Pais> getPaises(){
        return paises;
    }
    
    public static Pais acharPais() {
		String nome = JOptionPane.showInputDialog( "Digite o nome do país" );
		Pais var = Main.procurarPaisPor("nome", nome);
		if (var instanceof Pais) {
			return var;
		}
		else {
			return null;
		}
		
	}
    
    public static Regiao acharRegiao(Pais pais) {
    	String nome = JOptionPane.showInputDialog( "Digite o nome da região a ser procurada" );
    	Regiao var; 
    	var = pais.procurarRegiaoPor("nome", nome);
    	if (var instanceof Regiao) {
    		return var;
    	}
    	else {
    		return null;
    	}
    	
    }
    
    public static Estado acharEstado(Regiao regiao) {
    	String nome = JOptionPane.showInputDialog( "Digite o nome do Estado a ser procurado" );
    	Estado var; 
    	var = regiao.procurarEstadoPor("nome", nome);
    	if (var instanceof Estado) {
    		return var;
    	}
    	else {
    		return null;
    	}
    	
    }
}
