package unirio;

import unirio.Model.Publicacoes;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import unirio.DAO.PublicacaoDao;
import unirio.DAO.PublicacoesDao;

/**
 *
 * @author Filipe-pc Classe base para os serviços
 *
 */
@WebService(serviceName = "Servico")
public class Servico {

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Operação de Web service de multiplicacao
     */
    @WebMethod(operationName = "multiplicacao")
    public int multiplicacao(@WebParam(name = "inteiro1") int inteiro1, @WebParam(name = "inteiro2") int inteiro2) {

        return inteiro1 * inteiro2;
    }

    /*
    * Consulta por nome usando mock para simular o banco de dados   
     */
    @WebMethod(operationName = "consultaPorNome")
    public Publicacoes consultaPorNome(@WebParam(name = "nomePublicacao") String nomePublicacao) {

        PublicacoesDao pubDao = new PublicacoesDao();
        Publicacoes pub = pubDao.getPublicacoes();

        return pub.consulta(nomePublicacao);
    }

    /*
    * Consulta usando postgres
     */
    @WebMethod(operationName = "consultaPublicacaoPorNome")
    public Publicacoes consultaPublicacaoPorNome(@WebParam(name = "nomePublicacao") String nomePublicacao) {
        PublicacaoDao dao = new PublicacaoDao();
        Publicacoes listaPublicacoes = dao.consultaPublicacaoPorNome(nomePublicacao);

        return listaPublicacoes;

    }

    /*
        Inserção usando banco de dados
     */
    @WebMethod(operationName = "addPublicacao")
    public Boolean addPublicacao(
            @WebParam(name = "Id") int Id,
            @WebParam(name = "titulo") String titulo,
            @WebParam(name = "paginaInicial") int paginaInicial,
            @WebParam(name = "paginaFinal") int paginaFinal,
            @WebParam(name = "anoPublicacao") int anoPublicacao) {
        PublicacaoDao dao = new PublicacaoDao();
        Boolean add = dao.addPublicacao(Id, titulo, paginaInicial, paginaFinal, anoPublicacao);

        return add;

    }
           /*
        Inserção usando banco de dados
     */
    @WebMethod(operationName = "removePublicacao")
    public Boolean removePublicacao(@WebParam(name = "Id") int Id ) {
        
        PublicacaoDao dao = new PublicacaoDao();
        Boolean remove = dao.removePublicacao(Id);
        return remove;

    }
 
}
