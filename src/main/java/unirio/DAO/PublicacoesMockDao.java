package unirio.DAO;

import unirio.Model.Publicacao;
import unirio.Model.Publicacoes;

/**
 *
 * @author Filipe-pc
 * Mock para simulação de banco de dados populado
 */
public class PublicacoesMockDao {

    private Publicacoes publicacoes;
    public PublicacoesMockDao() {
        publicacoes = new Publicacoes(new Publicacao(1, "livro 1", 10, 100, 2016));
        publicacoes.addPublicacao(new Publicacao(2, "Revista 1",  5, 35, 2013));
        publicacoes.addPublicacao(new Publicacao(3, "Revista 2",  5, 205, 2013));
        publicacoes.addPublicacao(new Publicacao(4, "Artigo 1",  5,     135, 2015));
        publicacoes.addPublicacao(new Publicacao(5, "Artigo 2",  7, 85, 2014));
        
        
    }

    public Publicacoes getPublicacoes() {
        return publicacoes;
    }
    
    
    
    
    
}
