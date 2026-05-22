package Api.ConnectionEndpoint;

public interface ConnectionApi {
    String fetch(String url) throws Exception;
    String fetchFile(String ruta) throws Exception;

}
