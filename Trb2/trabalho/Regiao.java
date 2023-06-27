package trabalho;
import java.util.ArrayList;
import java.util.Iterator;

public class Regiao extends Localidade{
    private ArrayList<Estado> estados;
    
    public Regiao(String nome, String sigla){
        super( nome, sigla ) ;
        this.estados = new ArrayList<Estado>();
    }

    @Override
    public void getInformacao(){
        System.out.println("Nome: " + this.getNome());
        System.out.println("Sigla: " + this.getSigla());
        System.out.println("Area: " + this.getArea());
        System.out.println("Populacao: " + this.getPopulacao());
        System.out.println("PIB: " + this.getPIB());
        System.out.println("IDH: " + this.getIDH());
        System.out.println("Nome das estados: ");
        for (Estado e : estados){
            System.out.println("\t- " + e.getNome());
        }
    }
    public boolean addEstado(Estado novo){
        this.estados.add(novo);

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
        
        for(Estado e : this.estados){
            PIB += e.getPIB();
            area += e.getArea();
            populacao += e.getPopulacao();
            IDH += e.getIDH();
        }
        
        IDH = IDH / this.estados.size();
        
        setPIB(PIB);
        setArea(area);
        setPopulacao(populacao);
        setIDH(IDH);
    }
    public Estado procurarEstadoPor(String tipo, String valor){
        Estado procurado = null;

        for (Estado e : this.estados) {
            if(tipo == "nome"){
                if( e.getNome().equals(valor) ){ procurado = e; }
            }else if(tipo == "sigla"){
                if( e.getSigla().equals(valor)){ procurado = e; }
            }else if(tipo == "capital"){
                if( e.getCapital().equals(valor)){ procurado = e; }
            }
        }
        return procurado;
    }
    /*
     * Getters e Setters
     */
    public ArrayList<Estado> getEstados() {
        return estados;
    }
}