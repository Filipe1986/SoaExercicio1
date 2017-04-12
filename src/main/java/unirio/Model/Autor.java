/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unirio.Model;

/**
 *
 * @author Filipe-pc
 */
public class Autor {
    
    private String nome;
    private String nomeDeCitacao;
    private String cpf;
    private Long id;

    public Autor(String nome, String nomeDeCitacao, String cpf, Long id) {
        this.nome = nome;
        this.nomeDeCitacao = nomeDeCitacao;
        this.cpf = cpf;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeDeCitacao() {
        return nomeDeCitacao;
    }

    public String getCpf() {
        return cpf;
    }

    public Long getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNomeDeCitacao(String nomeDeCitacao) {
        this.nomeDeCitacao = nomeDeCitacao;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    
    
}
