package Model.DTO;

public class personatgeDTO {
    private String nom,status,species,tipus,genere,id_origen,id_localtizacio;

    public personatgeDTO(String nom, String status, String species, String tipus ,
                         String genere, String id_origen, String id_localtizacio){
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
        return String.format(
                "\n╔════════════════════════════════════════╗" +
                        "\n║               PERSONATGE               ║" +
                        "\n╠════════════════════════════════════════╣" +
                        "\n║  Nom      : %-27.27s║" +
                        "\n║  Status   : %-27.27s║" +
                        "\n║  Species  : %-27.27s║" +
                        "\n║  Tipus    : %-27.27s║" +
                        "\n║  Genere   : %-27.27s║" +
                        "\n║  Origen   : %-27.27s║" +
                        "\n║  Ubicacio : %-27.27s║" +
                        "\n╚════════════════════════════════════════╝\n",
                nom, status, species, tipus, genere, id_origen, id_localtizacio
        );
    }
}
