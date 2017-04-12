package unirio.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
            conn.commit();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PublicacaoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Publicacoes consultaPublicacaoPorNome(String titulo) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Publicacao> registrosDoBanco = new ArrayList<Publicacao>();
        Publicacoes publicacoes = null;
        Publicacao publicacaoClasse = null;
        try {
            abrirConexao();
            String sql = "select * from publicacao where titulo = ?";

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

                registrosDoBanco.add(publicacaoClasse);
            }
            publicacoes = new Publicacoes(registrosDoBanco);
        } catch (SQLException ex) {
            fecharConexao();
        }

        return publicacoes;
    }

    public Boolean addPublicacao(Integer Id, String titulo, int paginaInicial, int paginaFinal , Integer anoPublicacao) {
        PreparedStatement stmt = null;

        try {
            abrirConexao();
            
            String sql = "INSERT INTO publicacao(\"Id\", titulo , \"paginaInicial\", \"paginaFinal\" , \"anoPublicacao\") VALUES (?, ?, ?, ?, ?)";
            
            stmt = conn.prepareCall(sql);
            
            stmt.setInt(1, Id);
            stmt.setString(2, titulo);
            stmt.setInt(3, paginaInicial);
            stmt.setInt(4, paginaFinal);
            stmt.setInt(5, anoPublicacao);
            System.out.println("Query: " + stmt.toString());
            stmt.executeUpdate();
            fecharConexao();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
        }

        return false;
    }

}
