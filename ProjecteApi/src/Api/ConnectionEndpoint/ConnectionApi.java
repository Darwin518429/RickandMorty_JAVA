package Api.ConnectionEndpoint;

public interface ConnectionApi {
    String fetch(String url) throws Exception;

  //  List<String> fecthAll(String baseUrl , Function<String, String> nextUrlExtractor) throws Exception;


}
