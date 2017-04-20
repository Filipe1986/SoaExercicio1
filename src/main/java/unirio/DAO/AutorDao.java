package unirio.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import unirio.Model.Autor;
import unirio.Model.Publicacao;

/**
 *
 * @author Filipe-pc
 */
public class AutorDao {
    
        private static String dbUrl = "jdbc:postgresql://localhost:5432/publicacoes";
    private static Connection conn = null;
    
    
        private static void abrirConexao() {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            conn = DriverManager.getConnection(dbUrl, "postgres", "admin");

        } catch (Exception ex) {
            Logger.getLogger(AutorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void fecharConexao() {
        try {

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AutorDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
  //-----------------------------------------
    
    
    
    
    public ArrayList<Autor> consultaAutorPorNome(String nomeInicial) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Autor> registros = new ArrayList<Autor>();

        Autor autor = null;

        String nome = "%" + nomeInicial.trim() + "%";

        try {
            abrirConexao();
            String sql = " select * from autor where nome like ?;";

            stmt = conn.prepareCall(sql);
            stmt.setString(1, nome);
            rs = stmt.executeQuery();
            while (rs.next()) {
                autor = new Autor(
                        rs.getLong("Id"),
                        rs.getString("nome"),
                        rs.getString("nomeDeCitacao"),
                        rs.getString("cpf"));
              
                registros.add(autor);
            }

        } catch (SQLException ex) {
            fecharConexao();
        }

        return registros;
    }

    public Boolean addAutor(String nomeAutor, String nomeDeCitacao, String  cpf) {
        PreparedStatement stmt = null;

        try {
            abrirConexao();

            String sql = "INSERT INTO publicacao( nomeAutor , nomeDeCitacao , cpf ) VALUES (?, ?, ?)";

            stmt = conn.prepareCall(sql);

            stmt.setString(1, nomeAutor);
            stmt.setString(2, nomeDeCitacao );
            stmt.setString(3,  cpf);

            stmt.executeUpdate();
            fecharConexao();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
        }

        return false;
    }

    public Boolean removeAutor(Integer Id) {
        PreparedStatement stmt = null;

        try {
            abrirConexao();

            String sql = "Delete from autor where \"Id\" = ?";
            stmt = conn.prepareCall(sql);
            stmt.setInt(1, Id);
            stmt.executeUpdate();
            fecharConexao();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
        }
        return false;
    }

    public int getAutorIdPorNome(String nomeAutor) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int id = -1;

        try {
            abrirConexao();
            String sql = " select * from autor where nomeAutor like ?";

            stmt = conn.prepareCall(sql);
            stmt.setString(1, nomeAutor);
            System.out.println(stmt.toString());
            rs = stmt.executeQuery();
            while (rs.next()) {

                return (int) rs.getLong("Id");
            }

        } catch (SQLException ex) {
            fecharConexao();
        }

        return id;
    }
    
    
     public Boolean alteraAutor(int Id, String nomeAutor, String nomeDeCitacao, String  cpf) {
        PreparedStatement stmt = null;

        try {
            abrirConexao();

            String sql = "Update  publicacao set nomeAutor = ? , nomeDeCitacao = ?, cpf = ? where \"Id\" = ?";
                        
            stmt = conn.prepareCall(sql);

            stmt.setString(1, nomeAutor);
            stmt.setString(2, nomeDeCitacao);
            stmt.setString(3, cpf);
            stmt.setInt(4, Id);
            stmt.executeUpdate();
            fecharConexao();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
        }

        return false;
    }
    
    
    
}
