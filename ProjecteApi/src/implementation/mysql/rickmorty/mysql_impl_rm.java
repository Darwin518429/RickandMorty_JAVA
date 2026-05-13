package implementation.mysql.rickmorty;

import Api.RickMorty.RickMortyParser;
import Model.rickMortyDB.Personatges;
import dbconfig.BDC.ConnectConfigLoader;
import dbconfig.BDC.Provider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class mysql_impl_rm {
    public mysql_impl_rm (){}

 //   RickMortyParser parser= new RickMortyParser();
    Provider pv = ConnectConfigLoader.getProvider("mysql");

    public  void insertarTots(List<Personatges> llista) throws SQLException {
        String sql = """
                INSERT IGNORE INTO personatges  VALUES (?,?,?,?,?,?,?,?)
                """;

        try (
                Connection conn = pv.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            for (Personatges p : llista) {
                ps.setInt(1, p.getId_personatge());
                ps.setString(2, p.getNom());
                ps.setString(3, p.getStatus());
                ps.setString(4, p.getSpecies());
                ps.setString(5, p.getTipus());
                ps.setString(6, p.getGenere());
                ps.setInt(7,p.getId_origen());
                ps.setInt(8,p.getId_localtizacio());
                ps.executeUpdate();
            }
        }
    }
}
