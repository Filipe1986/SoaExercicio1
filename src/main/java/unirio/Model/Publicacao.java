/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unirio.Model;

import java.io.Serializable;

/**
 *
 * @author Filipe-pc
 * Modelo básico de Publicacao
 */
public class Publicacao implements Serializable{
    
    private long id;
    private String titulo;
    private int paginaInicial;
    private int paginaFinal;
    private int anoPublicacao;

    public Publicacao(long id, String titulo, int paginaInicial, int paginaFinal, int anoPublicacao) {
        this.id = id;
        this.titulo = titulo;
        this.paginaInicial = paginaInicial;
        this.paginaFinal = paginaFinal;
        this.anoPublicacao = anoPublicacao;
    }

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getPaginaInicial() {
        return paginaInicial;
    }

    public int getPaginaFinal() {
        return paginaFinal;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setPaginaInicial(int paginaInicial) {
        this.paginaInicial = paginaInicial;
    }

    public void setPaginaFinal(int paginaFinal) {
        this.paginaFinal = paginaFinal;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    @Override
    public String toString() {
        return "Publicacao{" + "id=" + id + ", titulo=" + titulo + ", paginaInicial=" + paginaInicial + ", paginaFinal=" + paginaFinal + ", anoPublicacao=" + anoPublicacao + '}';
    }
    
    public String conteudo() {
        return "Publicacao{" + "id=" + id + ", titulo=" + titulo + ", paginaInicial=" + paginaInicial + ", paginaFinal=" + paginaFinal + ", anoPublicacao=" + anoPublicacao + '}';
    }
    
    
    
    
    
    
}
