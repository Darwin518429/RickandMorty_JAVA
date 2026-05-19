package implementation.mysql.rickmorty;

import Model.rickMortyDB.Personatge;
import dao.Personatges;
import dbconfig.BDC.Provider;

import java.sql.ResultSet;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class mysqlPersonatge implements Personatges {
    Provider provider;
    public mysqlPersonatge(Provider p ){
        provider = p;
    }


@Override
    public  void copiaParcial(List<Personatge> llista) {
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
        }catch (SQLException e ){
            System.out.println(e);
        }

    }


    @Override
    public Personatge get (Integer id) {
        String sql = "SELECT * FROM personatges";

        try (Connection conn = provider.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return map(rs);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error obteniendo sector por id", e);
        }

        return null;
    }
    @Override
    public List<Personatge> getAll(){
        List<Personatge> ps = new ArrayList<>();
        return ps;
    }

    private Personatge map(ResultSet rs) throws SQLException {

        Personatge p  = new Personatge();
        p.setId_personatge(rs.getInt("id_personatge"));
        p.setNom(rs.getString("nom"));
        p.setStatus(rs.getString("status"));
        p.setSpecies(rs.getString("species"));
        p.setTipus(rs.getString("tipus"));
        p.setGenere(rs.getString("genere"));
        p.setId_origen(rs.getInt("origen"));
        p.setId_localtizacio(rs.getInt("localitzacio"));

        return p;
    }
}


