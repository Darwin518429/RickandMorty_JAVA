package implementation.mysql.rickmorty;

import Model.rickMortyDB.Personatge;
import dao.PersonatgesDAO;
import dbconfig.BDC.Provider;

import java.sql.ResultSet;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class mysqlPersonatge implements PersonatgesDAO {
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
        String sql = "SELECT * FROM personatges WHERE id_personatge = ? ";

        try (Connection conn = provider.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return map(rs);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error en obindre personatge ", e);
        }

        return null;
    }
    @Override
    public List<Personatge> getAll(){
        List<Personatge> p = new ArrayList<>();

        String sql = "SELECT * FROM personatges ";

        try (Connection conn = provider.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    p.add(map(rs));
                }
                return p;
            }

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<Personatge> getStatus(String status){
        List<Personatge> p =  new ArrayList<>();
        String sql = """
                SELECT * FROM personatges WHERE status  = ?
                """;

        try(Connection conn = provider.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql) ){
            ps.setString(1,status);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                p.add(map(rs));
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return p;
    }

public void copiaTotal(List<Personatge> l ){
    String sql = """
               REPLACE  INTO personatges  VALUES (?,?,?,?,?,?,?,?)
                """;

    try (
            Connection conn = provider.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
    ) {
        for (Personatge p : l) {
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
    public void addPersonatge(Personatge p ){
        String sql = """
                INSERT INTO personatges VALUES(?,?,?,?,?,?,?,?)
                """;

        try(Connection conn = provider.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)
        ){
            ps.setInt(1,p.getId_personatge());
            ps.setString(2,p.getNom());
            ps.setString(3,p.getStatus());
            ps.setString(4,p.getSpecies());
            ps.setString(5, p.getTipus());
            ps.setString(6,p.getGenere());
            ps.setInt(7,p.getId_origen());
            ps.setInt(8,p.getId_localtizacio());

             ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
@Override
public void updatePersonatge(Personatge p ){
        String sql = """
                UPDATE personatges SET
                                       nom  = ?,
                                       status = ?, 
                                       especies = ?,
                                       tipus =?,
                                       genere =?,
                                       origen =? ,
                                       localitzacio = ? 
                                       WHERE id_personatge = ?
                """;
            try(Connection conn = provider.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
            ){

                ps.setString(1, p.getNom());
                ps.setString(2, p.getStatus());
                ps.setString(3, p.getSpecies());
                ps.setString(4, p.getTipus());
                ps.setString(5, p.getGenere());
                ps.setInt(6, p.getId_origen());
                ps.setInt(7,p.getId_localtizacio());
                ps.setInt(8, p.getId_personatge());

                ps.executeUpdate();
            }
            catch (SQLException e ){
                System.out.println(e);
            }

}

    private Personatge map(ResultSet rs) throws SQLException {

        Personatge p  = new Personatge();
        p.setId_personatge(rs.getInt("id_personatge"));
        p.setNom(rs.getString("nom"));
        p.setStatus(rs.getString("status"));
        p.setSpecies(rs.getString("especies"));
        p.setTipus(rs.getString("tipus"));
        p.setGenere(rs.getString("genere"));
        p.setId_origen(rs.getInt("origen"));
        p.setId_localtizacio(rs.getInt("localitzacio"));

        return p;
    }
}


