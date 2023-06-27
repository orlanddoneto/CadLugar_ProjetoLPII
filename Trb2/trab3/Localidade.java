package trab3;

import java.util.ArrayList;

public abstract class Localidade{
    private String nome;
    private String sigla;
    private double area;
    private int populacao;
    private float PIB;
    private float IDH;

    public Localidade(String nome, String sigla){
        setNome(nome);
        setSigla(sigla);
        setArea(0.0f);
        setPopulacao(0);
        setPIB(0.0f);
        setIDH(0.0f);
    }
    public float PIBperCapita(){
        return this.PIB / this.populacao;
    }
    public float densidade(){
        return this.populacao / (float) this.area;
    }
    public abstract ArrayList<String> getInformacao();

    /*
     * Getters e Setters   
     */
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    
    public void setSigla(String sigla){
        this.sigla = sigla;
    }
    public String getSigla(){
        return this.sigla;
    }

    public void setArea(double area){
        this.area = area;
    }
    public double getArea(){
        return this.area;
    
    }
    
    public void setPopulacao(int populacao){
        this.populacao = populacao;
    }
    public int getPopulacao(){
        return this.populacao;
    }

    public void setPIB(float PIB){
        this.PIB = PIB;
    }
    public float getPIB(){
        return this.PIB;
    }

    public void setIDH(float IDH){
        this.IDH = IDH;
    }
    public float getIDH(){
        return this.IDH;
    }
}