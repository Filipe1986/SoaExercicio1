package unirio;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Filipe-pc
 */
@WebService(serviceName = "ServicoTeste")
public class ServicoTeste {
    
    
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
}
