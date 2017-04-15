package unirio.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import unirio.Model.Publicacao;
import unirio.Model.Publicacoes;

/**
 *
 * @author Filipe-pc
 */
public class PublicacaoDao {

    private static String dbUrl = "jdbc:postgresql://localhost:5432/publicacoes";
    private static Connection conn = null;

    private static void abrirConexao() {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            conn = DriverManager.getConnection(dbUrl, "postgres", "admin");

        } catch (Exception ex) {
            Logger.getLogger(PublicacaoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void fecharConexao() {
        try {
  
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PublicacaoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Publicacao> consultaPorNome(String tituloInicial) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Publicacao> registrosDoBanco = new ArrayList<Publicacao>();
      
        Publicacao publicacaoClasse = null;
        
        String titulo = "%" + tituloInicial.trim() + "%";
        
        try {
            abrirConexao();
            String sql = " select * from publicacao where titulo like ?;";
            
            stmt = conn.prepareCall(sql);
            stmt.setString(1, titulo);
            rs = stmt.executeQuery();
            while (rs.next()) {
                publicacaoClasse = new Publicacao(
                        rs.getLong("Id"),
                        rs.getString("titulo"),
                        rs.getInt("paginaInicial"),
                        rs.getInt("paginaFinal"),
                        rs.getInt("anoPublicacao"));
                System.out.println("teste");
                registrosDoBanco.add(publicacaoClasse);
            }
            
        } catch (SQLException ex) {
            fecharConexao();
        }

        return registrosDoBanco;
    }

    public Boolean addPublicacao( String titulo, int paginaInicial, int paginaFinal , Integer anoPublicacao) {
        PreparedStatement stmt = null;

        try {
            abrirConexao();
            
            String sql = "INSERT INTO publicacao( titulo , \"paginaInicial\", \"paginaFinal\" , \"anoPublicacao\") VALUES (?, ?, ?, ?)";
            
            stmt = conn.prepareCall(sql);
            
      
            stmt.setString(1, titulo);
            stmt.setInt(2, paginaInicial);
            stmt.setInt(3, paginaFinal);
            stmt.setInt(4, anoPublicacao);
            stmt.executeUpdate();
            fecharConexao();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
        }

        return false;
    }
    
        public Boolean removePublicacao(Integer Id) {
        PreparedStatement stmt = null;

        try {
            abrirConexao();
            
            String sql = "Delete from publicacao where \"Id\" = ?";
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
}
