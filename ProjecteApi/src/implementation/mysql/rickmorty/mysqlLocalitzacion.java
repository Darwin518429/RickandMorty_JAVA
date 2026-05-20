package implementation.mysql.rickmorty;

import Model.rickMortyDB.Localitzacion;
import dao.LocalitacionsDAO;
import dbconfig.BDC.Provider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class mysqlLocalitzacion implements LocalitacionsDAO {
private Provider provider ;
public mysqlLocalitzacion(Provider dao){
    provider = dao;
}

    @Override
    public Localitzacion get (Integer id){
        System.out.println("Buscando localitzacio con id: " + id);
        String sql = """
                SELECT *
                FROM localitzacions
                WHERE id_localitzacions= ?
                """;

        try (Connection conn = provider.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return map(rs);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error en obtenir  Localitzacio", e);
        }

        return null;
    }

    @Override
    public List<Localitzacion> getAll(){

             List<Localitzacion> lz = new ArrayList<>();

        String sql = "SELECT * FROM localitzacions ";

        try (Connection conn = provider.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lz.add(map(rs));
                }
                return lz;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error", e);

        }

    }



      private Localitzacion map(ResultSet rs) throws SQLException {

        Localitzacion  l  = new Localitzacion();
        l.setId_localitzacions(rs.getInt("id_localitzacions"));
        l.setNom(rs.getString("nom"));
        l.setTipus(rs.getString("tipus"));

        return l;
    }

}
