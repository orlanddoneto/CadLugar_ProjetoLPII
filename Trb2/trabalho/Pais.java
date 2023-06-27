package trabalho;
import java.util.ArrayList;
import java.util.Iterator;

public class Pais extends Localidade{
    private String capital;
    private ArrayList<Regiao> regioes;
    
    public Pais(String nome, String sigla, String capital){
        super( nome, sigla ) ;
        setCapital(capital);
        this.regioes = new ArrayList<Regiao>();
    }

    @Override
    public void getInformacao(){
        System.out.println("Nome: " + this.getNome());
        System.out.println("Sigla: " + this.getSigla());
        System.out.println("Capital: " + this.getCapital());
        System.out.println("Area: " + this.getArea());
        System.out.println("Populacao: " + this.getPopulacao());
        System.out.println("PIB: " + this.getPIB());
        System.out.println("IDH: " + this.getIDH());
        System.out.println("Nome dos estados e regiões: ");
        for (Regiao r : regioes){
            System.out.println();
            System.out.println("Região - " + r.getNome());
            for (Estado e : r.getEstados()){
                System.out.println("Estado - " + e.getNome());
            }
        }
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