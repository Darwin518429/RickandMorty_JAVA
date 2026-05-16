package Api;

import java.util.List;
import java.util.function.Function;

public interface ConnectionApi {
    String fetch(String url) throws Exception;

    List<String> fecthAll(String baseUrl , Function<String, String> nextUrlExtractor) throws Exception;


}
