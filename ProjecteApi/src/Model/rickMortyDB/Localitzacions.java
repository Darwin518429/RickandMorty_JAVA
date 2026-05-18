package Model.rickMortyDB;

public class Localitzacions {
    protected int id_localitzacions;
    protected String nom,tipus;

    public Localitzacions(int id_localitzacions , String nom , String tipus){
        this.id_localitzacions = id_localitzacions;
        this.nom = nom;
        this.tipus = tipus;
    }

    public int getId_localitzacions() {
        return id_localitzacions;
    }

    public void setId_localitzacions(int id_localitzacions) {
        this.id_localitzacions = id_localitzacions;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }
}
