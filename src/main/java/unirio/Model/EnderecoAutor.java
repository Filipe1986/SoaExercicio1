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
public class EnderecoAutor {

    private String nome;
    private String uf;
    private String cidade;
    private String bairro;

    public EnderecoAutor(String nome, String uf, String cidade, String bairro) {
        this.nome = nome;
        this.uf = uf;
        this.cidade = cidade;
        this.bairro = bairro;
    }

    public String getNome() {
        return nome;
    }

    public String getUf() {
        return uf;
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

}
