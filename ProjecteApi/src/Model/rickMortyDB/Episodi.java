package Model.rickMortyDB;

public class Episodi {
    private int  id_episodi;
    private String name;
    private String date;
    private String episodi;
    public Episodi(int id, String name, String date,String episodi){
        id_episodi = id;
        this.name = name;
        this.date = date;
        this.episodi = episodi;
    }

    public int getId_episodi() {
        return id_episodi;
    }

    public void setId_episodi(int id_episodi) {
        this.id_episodi = id_episodi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEpisodi() {
        return episodi;
    }

    public void setEpisodi(String episodi) {
        this.episodi = episodi;
    }
}
