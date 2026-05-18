package Model.DTO;

public class personatgesDTO {
    private String nom,status,species,tipus,genere,id_origen,id_localtizacio;

    public personatgesDTO(String nom, String status, String species, String tipus ,
                          String genere,String id_origen, String id_localtizacio){
        this.nom = nom;
        this.status = status;
        this.species = species;
        this.tipus = tipus;
        this.genere = genere;
        this.id_origen = id_origen;
        this.id_localtizacio = id_localtizacio;

    }


    @Override
    public String toString() {
        return "──────────────Personatge─────────\n" +
                "Nom    :" + nom + "\n" +
                "Status : " + status + "\n" +
                "Species: " + species + "\n" +
                "Tipus  :"  + tipus + "\n" +
                "Genere :" + genere + "\n" +
                "Origen :" + id_origen + "\n" +
                "Localitzacio_Actual    :" + id_localtizacio + "\n" +
                "─────────────────────────────────";
    }
}
