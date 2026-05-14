package Model.rickMortyDB;

public class Localitzacions {
    protected int id_localitzacions;
    protected String nom,tipus;

    public Localitzacions(int id_localitzacions , String nom , String tipus){
        this.id_localitzacions = id_localitzacions;
        this.nom = nom;
        this.tipus = tipus;
    }

}
