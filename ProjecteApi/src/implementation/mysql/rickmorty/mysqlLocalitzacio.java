package implementation.mysql.rickmorty;

import Model.rickMortyDB.Localitzacio;
import View.Classes.Messages;
import dao.LocalitzacionsDAO;
import dbconfig.BDC.Provider;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class mysqlLocalitzacio implements LocalitzacionsDAO {
private Provider provider ;
public mysqlLocalitzacio(Provider dao){
    provider = dao;
}

    @Override
    public Localitzacio get (Integer id){

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
    public List<Localitzacio> getAll(){

             List<Localitzacio> lz = new ArrayList<>();

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

@Override
public void addLocalitzacio(Localitzacio l  ){
    String sql = """
                INSERT IGNORE INTO localitzacions VALUES(?,?,?)
                """;

        try(Connection conn = provider.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)
        ){
            ps.setInt(1,l.getId_localitzacions());
            ps.setString(2,l.getNom());
            ps.setString(3,l.getTipus());


             ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
}

public  Localitzacio searchcalitzacio(Integer id){
    String sql = "SELECT * FROM localitzacions WHERE id_localitzacions = ?";
try(Connection conn = provider.getConnection();
PreparedStatement ps = conn.prepareStatement(sql);
){
    //Mirar con el boolean
    ps.setInt(1,id);
    ResultSet rs = ps.executeQuery();
    if(rs.next()) return map(rs);

}catch (SQLException e ){
    System.out.println(e);
}
    return null;
}
      private Localitzacio map(ResultSet rs) throws SQLException {

        Localitzacio l  = new Localitzacio();
        l.setId_localitzacions(rs.getInt("id_localitzacions"));
        l.setNom(rs.getString("nom"));
        l.setTipus(rs.getString("tipus"));

        return l;
    }

    @Override
    public   void insertDesconegut(){
    String sql = """
         INSERT IGNORE INTO localitzacions VALUES (0,"Desconegut","No es sap")
            """;

    try(Connection conn = provider.getConnection();
        Statement ps = conn.createStatement();
    ){
      ps.executeUpdate(sql);
    }
    catch (SQLException e ){
        Messages.M_exception(e);
    }
    }
}
