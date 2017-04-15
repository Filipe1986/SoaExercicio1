package unirio;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import unirio.DAO.PublicacoesMockDao;
import unirio.Model.Publicacoes;

/**
 *
 * @author Filipe-pc
 */
@WebService(serviceName = "ServicoMock")
public class ServicoMock {

    /*
    * Consulta por nome usando mock para simular o banco de dados   
     */
    @WebMethod(operationName = "consultaPorNomeMock")
    public Publicacoes consultaPorNomeMock(@WebParam(name = "nomePublicacao") String nomePublicacao) {

        PublicacoesMockDao pubDao = new PublicacoesMockDao();
        Publicacoes pub = pubDao.getPublicacoes();

        return pub.consulta(nomePublicacao);
    }
    
}
