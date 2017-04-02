/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unirio;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Filipe-pc
 */
@WebService(serviceName = "servicoString")
public class servicoString {

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
}
