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
            conn = DriverManager.getConnection(dbUrl, "postgresql", "");

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

    public ArrayList<Publicacao> consultaPublicacaoPorNome(String nomePublicacao) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Publicacao> registrosDoBanco = new ArrayList<Publicacao>();
        Publicacao publicacaoClasse = null;
        try {
            abrirConexao();
            String sql = "select * from publicacao where publicacao = ?";

            stmt = conn.prepareCall(sql);
            stmt.setString(1, nomePublicacao);
            rs = stmt.executeQuery();
            while (rs.next()) {
                publicacaoClasse = new Publicacao(
                        rs.getLong("id"),
                        rs.getString("titulo"),
                        rs.getInt("paginaInicial"),
                        rs.getInt("paginaFinal"),
                        rs.getInt("anoPublicacao"));

                registrosDoBanco.add(publicacaoClasse);
            }

        } catch (SQLException ex) {
            fecharConexao();
        }

        return registrosDoBanco;
    }

}
