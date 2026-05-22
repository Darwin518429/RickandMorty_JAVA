package Api.ApiTemplate;

import Api.ConnectionEndpoint.ConnectionApi;

//EXISTEIX NOMES PER AGRUPAR
//EVITAR DE FER UNA INSTANCIA AMB EK ABSTRACT
public  abstract class ApiClientGeneric {
    protected ConnectionApi api;
    protected String[] url;

    public ApiClientGeneric(ConnectionApi api, String ...url) {
        this.api = api;
        this.url = url;
    }
public  int lengthUrl(){
        return url.length;
}
    public String getUrl(int id ) {
        return url[id];
    }
}
