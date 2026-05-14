package Api;

import java.util.List;

public interface genericApi {
    String fetch(String url) throws Exception;

    List<String> fecthAll() throws Exception;
}
