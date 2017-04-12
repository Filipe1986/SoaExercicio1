/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unirio;

import java.util.ArrayList;
import java.util.List;
import unirio.Model.Publicacoes;
import unirio.Model.Publicacao;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import unirio.DAO.PublicacaoDao;
import unirio.DAO.PublicacoesDao;

/**
 *
 * @author Filipe-pc
 * Classe base para os serviços
 * 
 */
@WebService(serviceName = "Servico")
public class Servico {

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "multiplicacao")
    public int multiplicacao(@WebParam(name = "inteiro1") int inteiro1, @WebParam(name = "inteiro2") int inteiro2) {
    
        return inteiro1 * inteiro2;
    }
    
    @WebMethod(operationName = "consultaPorNome")
    public Publicacoes consultaPorNome(@WebParam(name = "nomePublicacao") String nomePublicacao) {
        
        PublicacoesDao pubDao = new PublicacoesDao();
        Publicacoes pub = pubDao.getPublicacoes();
        
        return pub.consulta(nomePublicacao);
    }
    
    @WebMethod(operationName = "consultaPublicacaoPorNome")
    public List<Publicacao> consultaPublicacaoPorNome(@WebParam (name = "nomePublicacao" ) String nomePublicacao){
        PublicacaoDao dao = new PublicacaoDao();
        ArrayList<Publicacao> listaPublicacoes =  dao.consultaPublicacaoPorNome(nomePublicacao);
        
        return listaPublicacoes;
        
    } 
}
