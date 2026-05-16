package Api;

//EXISTEIX NOMES PER AGRUPAR
//EVITAR DE FER UNA INSTANCIA AMB EK ABSTRACT
public  abstract class ApiClientGeneric {
    protected ConnectionApi api;
    protected String url;

    public ApiClientGeneric(ConnectionApi api, String url) {
        this.api = api;
        this.url = url;
    }

}
