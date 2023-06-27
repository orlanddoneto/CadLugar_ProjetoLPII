package trabalho;

public class Estado extends Localidade{
    private Pais pais;
    private String capital;
    private Estado estadoSimilar;
    
    public Estado(String nome, String sigla, double area, int populacao, float PIB, float IDH, String capital, Pais pais){
        super( nome, sigla );
        
        setArea(area);
        setPopulacao(populacao);
        setPIB(PIB);
        setIDH(IDH);
        setCapital(capital);
        this.pais = pais;
        definirEstadoSimilar();
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
        System.out.println("Estado Similiar: " + this.getEstadoSimilar().getNome());
    }
    
    public void definirEstadoSimilar(){
       double similar;
    	double menor = 0.0f;
		Estado similarEstado = null;
        
        if ( this.pais != null ){
    		for(Regiao regiao : this.pais.getRegioes()) {
    			for (Estado estado : regiao.getEstados()) {
    				float idh2 = estado.getIDH();
    				float pib2 = estado.PIBperCapita();
    				double den2 = estado.densidade();
    				similar = Math.sqrt(Math.pow(super.getIDH() * 100 - idh2 * 100, 2)
    						+ Math.pow(super.PIBperCapita() - pib2, 2) + Math.pow(super.densidade() - den2, 2));
    				if (menor == 0 && similar != 0 ) {
    					menor = similar;
    				}
    				if (similar != 0) {
    					if (similar < menor) {
    						menor = similar;
    						similarEstado = estado;
    					}
    				}
    			}
    		}
        }
		this.estadoSimilar = similarEstado;
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
    public Estado getEstadoSimilar(){
        return this.estadoSimilar;
    }
}


