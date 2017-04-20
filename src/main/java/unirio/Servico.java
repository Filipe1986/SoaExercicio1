package unirio;

import br.com.correios.bsb.sigep.master.bean.cliente.AtendeCliente;
import br.com.correios.bsb.sigep.master.bean.cliente.AtendeClienteService;
import br.com.correios.bsb.sigep.master.bean.cliente.ConsultaCEP;
import br.com.correios.bsb.sigep.master.bean.cliente.SQLException_Exception;
import br.com.correios.bsb.sigep.master.bean.cliente.SigepClienteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import unirio.DAO.AutorDao;
import unirio.DAO.PublicacaoDao;
import unirio.Model.Autor;
import unirio.Model.EnderecoAutor;
import unirio.Model.Publicacao;

/**
 *
 * @author Filipe-pc Classe base para os serviços
 *
 */
@WebService(serviceName = "Servico")
public class Servico {

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "nomePublicacao") String txt) {
        return "Hello" + txt;
    }

    /*
      Consulta acessando o banco de dados
     */
    @WebMethod(operationName = "consultaPublicacaoPorNome")
    public ArrayList<Publicacao> consultaPublicacaoPorNome(@WebParam(name = "nomePublicacao") String nomePublicacao) {
        PublicacaoDao dao = new PublicacaoDao();
        return dao.consultaPorNome(nomePublicacao);
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
        Boolean add = dao.addPublicacao(titulo, paginaInicial, paginaFinal, anoPublicacao);

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

    @WebMethod(operationName = "getPublicacaoIdPorNome")
    public int getPublicacaoIdPorNome(String titulo) {
        PublicacaoDao dao = new PublicacaoDao();
        return dao.getPublicacaoIdPorNome(titulo);
    }

    @WebMethod(operationName = "alteraPublicacao")
    public Boolean alteraPublicacao(int Id, String titulo, int paginaInicial, int paginaFinal, Integer anoPublicacao) {
        PublicacaoDao dao = new PublicacaoDao();
        return dao.alteraPublicacao(Id, titulo, paginaInicial, paginaFinal, anoPublicacao);

    }

    @WebMethod(operationName = "consultaAutorPorNome")
    public ArrayList<Autor> consultaAutorPorNome(@WebParam(name = "nomeAutor") String nomePublicacao) {
        AutorDao dao = new AutorDao();
        return dao.consultaAutorPorNome(nomePublicacao);
    }

    @WebMethod(operationName = "addAutor")
    public Boolean addAutor(
            @WebParam(name = "nomeAutor") String nomeAutor,
            @WebParam(name = "nomeDePublicacao") String nomeDePublicacao,
            @WebParam(name = "cpf") String cpf) {

        AutorDao dao = new AutorDao();
        return dao.addAutor(nomeAutor, nomeDePublicacao, cpf);

    }

    @WebMethod(operationName = "removeAutor")
    public Boolean removeAutor(@WebParam(name = "Id") int Id) {

        AutorDao dao = new AutorDao();
        return dao.removeAutor(Id);

    }

    @WebMethod(operationName = "getAutorIdPorNome")
    public int getAutorIdPorNome(String nomeAutor) {
        AutorDao dao = new AutorDao();
        return dao.getAutorIdPorNome(nomeAutor);
    }

    @WebMethod(operationName = "alteraAutor")
    public Boolean alteraAutor(int Id, String nomeAutor, String nomeDeCitacao, String cpf) {
        AutorDao dao = new AutorDao();
        return dao.alteraAutor(Id, nomeAutor, nomeDeCitacao, cpf);
    }

    @WebMethod(operationName = "infoCepAutor")
    public ArrayList<EnderecoAutor> infoCepAutor(String nomeAutor) {
        
        ArrayList<EnderecoAutor> enderecos = new ArrayList<>();
        
        AtendeCliente port = new AtendeClienteService().getAtendeClientePort();

        AutorDao dao = new AutorDao();
        ArrayList<Autor> autores = dao.consultaAutorPorNome(nomeAutor);
        for (Autor autor : autores) {
            try {
                enderecos.add(new EnderecoAutor(autor.getNome(),
                        port.consultaCEP(autor.getCpf()).getUf(),
                        port.consultaCEP(autor.getCpf()).getCidade(),
                        port.consultaCEP(autor.getCpf()).getBairro()));

            } catch (SQLException_Exception ex) {
                Logger.getLogger(Servico.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SigepClienteException ex) {
                Logger.getLogger(Servico.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return enderecos;
    }

}
