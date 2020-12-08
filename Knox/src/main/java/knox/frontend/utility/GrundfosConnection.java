package knox.frontend.utility;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class GrundfosConnection extends AbstractConnection {
    String ip = "localhost";
    String port = "8081";
    @Override
    public String CreateURL(String methodName) {
        return "http://" + ip +":"+ port +"/" + methodName;
    }

    public String Search (String search) {
        NameValuePair parameter = new BasicNameValuePair("q", search);
        List<NameValuePair> parameters = new ArrayList<>();
        parameters.add(parameter);

        return Request("search",parameters);
    }
}
