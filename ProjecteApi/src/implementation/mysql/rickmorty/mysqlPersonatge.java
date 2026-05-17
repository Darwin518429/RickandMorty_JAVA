package implementation.mysql.rickmorty;

import Model.rickMortyDB.Personatge;
import dbconfig.BDC.Provider;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class mysqlPersonatge {
    Provider provider;
    public mysqlPersonatge(Provider p ){
        provider = p;
    }



    public  void insertPersonatges(List<Personatge> llista) throws SQLException {
        String sql = """
                INSERT IGNORE INTO personatges  VALUES (?,?,?,?,?,?,?,?)
                """;

        try (
             Connection conn = provider.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            for (Personatge p : llista) {
                ps.setInt(1, p.getId_personatge());
                ps.setString(2, p.getNom());
                ps.setString(3, p.getStatus());
                ps.setString(4, p.getSpecies());
                ps.setString(5, p.getTipus());
                ps.setString(6, p.getGenere());
                ps.setInt(7, p.getId_origen());
                ps.setInt(8,p.getId_localtizacio());
                ps.executeUpdate();
            }
        }
    }
}
