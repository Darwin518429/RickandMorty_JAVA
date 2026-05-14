package Model.rickMortyDB;

public class Personatge {
    protected int id_personatge;
    protected String nom,status,species,tipus,genere;
    protected  Integer id_origen,id_localtizacio;
    public Personatge(Integer id_personatge, String nom, String status, String species, String tipus, String genere, Integer id_origen, int id_lloc ){
        this.id_personatge = id_personatge;
        this.nom = nom;
        this.status = status;
        this.species = species;
        this.tipus = tipus;
        this.genere = genere;
        this.id_origen = id_origen;
        this.id_localtizacio = id_lloc;
    }

    public int getId_personatge() {
        return id_personatge;
    }

    public void setId_personatge(int id_personatge) {
        this.id_personatge = id_personatge;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public int getId_origen() {
        return id_origen;
    }

    public void setId_origen(int id_origen) {
        this.id_origen = id_origen;
    }

    public int getId_localtizacio() {
        return id_localtizacio;
    }

    public void setId_localtizacio(int id_localtizacio) {
        this.id_localtizacio = id_localtizacio;
    }
}
