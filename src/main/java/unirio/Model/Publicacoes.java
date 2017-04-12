package unirio.Model;

import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author Filipe-pc
 * Coleção de Publicacao
 */
public class Publicacoes implements Serializable{
    
    private ArrayList<Publicacao> publicacoes;

    public Publicacoes(ArrayList<Publicacao> Publicacoes) {
        this.publicacoes = Publicacoes;
    }

    public Publicacoes(Publicacao publicacao) {
        this.publicacoes = new ArrayList<Publicacao>();
        publicacoes.add(publicacao);
    }

    private Publicacoes() {
        publicacoes = new ArrayList<>();
    }


    

    public ArrayList<Publicacao> getPublicacoes() {
        return publicacoes;
    }

    public void setPublicacoes(ArrayList<Publicacao> Publicacoes) {
        this.publicacoes = Publicacoes;
    }

    @Override
    public String toString() {
        String toString = "Publicacoes{ ";
        for (Publicacao publicacao : publicacoes) {
            toString += publicacao.toString() + " ";
        }
        toString += " }";
        
        
        return toString;
    }
    
    public void addPublicacao(Publicacao publicacao){
        this.publicacoes.add(publicacao);
    }
    public Publicacoes consulta(String nomeParcial){
        Publicacoes consulta = new Publicacoes();
        for (Publicacao publicacao : publicacoes) {
            if (publicacao.getTitulo().contains(nomeParcial)){
                consulta.addPublicacao(publicacao);
            }
        }
        return consulta;
    }
    
    
}
