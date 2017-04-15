package unirio;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import unirio.DAO.PublicacaoDao;
import unirio.Model.Publicacao;

/**
 *
 * @author Filipe-pc Classe base para os serviços
 *
 */
@WebService(serviceName = "Servico")
public class Servico {

    /*
      Consulta acessando o banco de dados
     */
    @WebMethod(operationName = "consultaPorNome")
    public ArrayList<Publicacao> consultaPorNome(@WebParam(name = "nomePublicacao") String nomePublicacao) {
        PublicacaoDao dao = new PublicacaoDao();
          return  dao.consultaPorNome(nomePublicacao);
    }

    /*
        Inserção usando o banco de dados
     */
    @WebMethod(operationName = "addPublicacao")
    public Boolean addPublicacao(
            @WebParam(name = "titulo") String titulo,
            @WebParam(name = "paginaInicial") int paginaInicial,
            @WebParam(name = "paginaFinal") int paginaFinal,
            @WebParam(name = "anoPublicacao") int anoPublicacao) {
        PublicacaoDao dao = new PublicacaoDao();
        Boolean add = dao.addPublicacao( titulo, paginaInicial, paginaFinal, anoPublicacao);

        return add;

    }

    /*
        Remoção usando banco de dados
     */
    @WebMethod(operationName = "removePublicacao")
    public Boolean removePublicacao(@WebParam(name = "Id") int Id) {

        PublicacaoDao dao = new PublicacaoDao();
        Boolean remove = dao.removePublicacao(Id);
        return remove;

    }
    
      /*
        Update usando banco de dados
     */
    @WebMethod(operationName = "modificaPublicacao")
    public Boolean modificacaoPublicacao(@WebParam(name = "Id") int Id) {
        
        //TODO
        return null;

    }
    
    

}