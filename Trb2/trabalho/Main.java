package trabalho;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import javax.imageio.IIOException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
//https://replit.com/@Juniorsss/LP2-Trabalho2#README.txt
class Main {
    public static ArrayList<Pais> paises;
    public static Scanner input;
  
    public static void main(String[] args) {
        input = new Scanner(System.in);
        paises = new ArrayList<Pais>();
        menuPrincipal();
    }
  
    public static void menuPrincipal(){
        int opcao = -1;
      
        while(opcao != 0){
            System.out.println("\n\n--- Menu ---\n");
            System.out.println("1 - Cadastrar Pais\n");
            System.out.println("2 - Cadastrar Regiao\n");
            System.out.println("3 - Cadastrar Estado\n");
            System.out.println("4 - Carregar Arquivo\n");
            System.out.println("5 - Informações do Pais\n");
            System.out.println("6 - Informações da Regiao\n");
            System.out.println("7 - Informações do Estado\n::::");
            opcao = input.nextInt();
            input.nextLine();

            switch(opcao){
                case 1:
                    cadastrarPais();
                    break;
                case 2:
                    cadastrarRegiao();
                    break;
                case 3:
                    cadastrarEstado();
                    break;
                case 4: 
                    carregarArquivo();
                    break;
                case 5: 
                    informacaoPais();
                    break;
                case 6:
                    informacaoRegiao();
                    break;
                case 7: 
                    informacaoEstado();
                    break;
                default:
                    System.out.println("Digite Um Valor Válido\n");
            }
            
        }
    }
  
    public static void cadastrarPais(){
        String nome, sigla, capital;
        
        System.out.println("Digite o nome do País: ");
        nome = input.nextLine();
        System.out.println("Digite o sigla do País: ");
        sigla = input.nextLine();
        System.out.println("Digite a capital do País: ");
        capital = input.nextLine();

        Pais novo = new Pais( nome, sigla, capital);
      
        paises.add(novo);

        System.out.println("País adicionado !\n\n");
    }
  
    public static void cadastrarRegiao(){
        String nome, sigla;
        
        System.out.println("Digite o nome do Pais que deseja adicionar a Região: ");
        nome = input.nextLine();

        Pais pais = procurarPaisPor("nome", nome);
        if(pais == null){
            System.out.println("Pais não encontrado!\n");  
            return;
        }
    
        System.out.println("Digite o nome da Região: ");
        nome = input.nextLine();
        System.out.println("Digite a sigla da Região: ");
        sigla = input.nextLine();

        Regiao novo = new Regiao( nome, sigla );
       
        pais.addRegiao(novo);

        System.out.println("Região adicionada !\n\n");
    }

    public static void cadastrarEstado(){
        String nome, sigla, capital;
        Regiao regiao;
        float PIB, IDH;
        double area;
        int populacao;
        
        System.out.println("Digite o nome da Pais que deseja adicionar o Estado: ");
        nome = input.nextLine();

        Pais pais = procurarPaisPor("nome", nome);
        if(pais == null){
            System.out.println("Pais não encontrado!\n");  
            return;
        }else{
            System.out.println("Digite o nome da Regiao que deseja adicionar o Estado: ");
            nome = input.nextLine();
    
            regiao = pais.procurarRegiaoPor("nome", nome);
            if(regiao == null){
                System.out.println("Regiao não encontrado!\n");  
                return;
            }
        }
    
        System.out.println("Digite o nome da Estado: ");
        nome = input.nextLine();
        System.out.println("Digite a sigla da Estado: ");
        sigla = input.nextLine();
        System.out.println("Digite a capital do País: ");
        capital = input.nextLine();
        System.out.println("Digite a área da Estado: ");
        area = input.nextDouble();
        System.out.println("Digite o PIB da Estado: ");
        PIB = input.nextFloat();
        System.out.println("Digite o IDH da Estado: ");
        IDH = input.nextFloat();
        System.out.println("Digite a população da Estado: ");
        populacao = input.nextInt();

        Estado novo = new Estado( nome, sigla, area, populacao, PIB, IDH, capital, pais);
       
        regiao.addEstado(novo);

        System.out.println("Estado adicionada !\n\n");
    }

    public static void informacaoPais(){
        String opcs[] = {"nome", "sigla", "capital"};
        
        System.out.println("Procurar por: ");
        System.out.println("1 - Nome ");
        System.out.println("2 - Sigla ");
        System.out.println("3 - Capital ");
        int op = input.nextInt();

        System.out.println("Digite " + opcs[op-1]);    
        input.nextLine();
        String valor = input.nextLine();
        
        Pais pais = procurarPaisPor( opcs[op-1], valor);
        if(pais == null){
            System.out.println("Pais não encontrado!\n");
        }else{
            pais.getInformacao();
        }
    }

    public static void informacaoRegiao(){
        String opcs[] = {"nome", "sigla"};
        System.out.println("Procurar por: ");
        System.out.println("1 - Nome ");
        System.out.println("2 - Sigla ");
        int op = input.nextInt();

        System.out.println("Digite o " + opcs[op-1]);    
        input.nextLine();
        String valor = input.nextLine();

        for(Pais p : paises){
            Regiao regiao = p.procurarRegiaoPor(opcs[op-1], valor);
            if(regiao != null){
                regiao.getInformacao();
                return;
            }
        }
        System.out.println("Regiao não encontrada!\n");
    }
    
    public static void informacaoEstado(){
        String opcs[] = {"nome", "sigla", "capital"};
        System.out.println("Procurar por: ");
        System.out.println("1 - Nome ");
        System.out.println("2 - Sigla ");
        System.out.println("3 - Capital ");
        int op = input.nextInt();
        
        System.out.println("Digite o " + opcs[op-1]);    
        input.nextLine();
        String valor = input.nextLine();

        for(Pais p : paises){
            for(Regiao r : p.getRegioes()){
                Estado estado = r.procurarEstadoPor(opcs[op-1], valor);
                if(estado != null){
                    estado.getInformacao();
                    return;
                }
            }
        }
        System.out.println("Estado não encontrada!\n");
    }
    
    public static void carregarArquivo(){
        System.out.println("Digite o nome da Pais que deseja adicionar os Estados: ");
        String nome = input.nextLine();

        Pais pais = procurarPaisPor("nome", nome);
        if(pais == null){
            System.out.println("Pais não encontrado!\n");  
            
        }else{
            boolean res = carregar("C:\\Users\\Cliente\\eclipse-workspace\\Trab2LPII\\Trb2\\trabalho\\estados.txt", pais);
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
}
