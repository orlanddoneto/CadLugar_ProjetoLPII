package trab3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pais extends Localidade{
    private String capital;
    private ArrayList<Regiao> regioes;
    
    public Pais(String nome, String sigla, String capital){
        super( nome, sigla ) ;
        setCapital(capital);
        this.regioes = new ArrayList<Regiao>();
    }

    @Override
    public ArrayList<String> getInformacao(){
    	ArrayList<String> informacoes = new ArrayList<>();
        informacoes.add("Nome: " + this.getNome()+"\n");
        informacoes.add("Sigla: " + this.getSigla()+"\n");
        informacoes.add("Capital: " + this.getCapital()+"\n");
        informacoes.add("Area: " + this.getArea()+"\n");
        informacoes.add("Populacao: " + this.getPopulacao()+"\n");
        informacoes.add("PIB: " + this.getPIB()+"\n");
        informacoes.add("IDH: " + this.getIDH()+"\n");
        informacoes.add("\n");
        informacoes.add("Nome dos estados e regiões: "+"\n");
        for (Regiao r : regioes){
        	informacoes.add("\n");
        	informacoes.add("Região - " + r.getNome()+"\n");
            for (Estado e : r.getEstados()){
            	informacoes.add("Estado - " + e.getNome()+"\n");
            }
        }
        return informacoes;
    }

    public boolean addRegiao(Regiao novo){
        this.regioes.add(novo);

        atualizarDados();
        return false;
    }
    public void atualizarDados(){
        /* calcular:
         *    PIB
         *    Populacao
         *    area
         */
        float PIB = 0.0f, IDH = 0.0f;
        double area = 0.0f;
        int populacao = 0;
        
        for(Regiao r : this.regioes){
            PIB += r.getPIB();
            area += r.getArea();
            populacao += r.getPopulacao();
            IDH += r.getIDH();

        }
        
        IDH = IDH / this.regioes.size();
        
        setPIB(PIB);
        setArea(area);
        setPopulacao(populacao);
        setIDH(IDH);
        
    }
    
    public Regiao procurarRegiaoPor(String tipo, String valor){
        Regiao procurado = null;

        for (Regiao r : this.regioes) {
            if(tipo == "nome"){
                if( r.getNome().equals(valor) ){ procurado = r; }
            }else if(tipo == "sigla"){
                if( r.getSigla().equals(valor)){ procurado = r; }
            }
        }
        
        return procurado;
    }
    /*
     * Getters e Setters
     */
    public void setCapital(String capital){
        this.capital = capital;
    }
    public String getCapital(){
        return this.capital;
    }
    public ArrayList<Regiao> getRegioes(){
        return this.regioes;
    }
}