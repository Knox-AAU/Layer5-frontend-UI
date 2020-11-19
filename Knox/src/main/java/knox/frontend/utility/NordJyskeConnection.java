package knox.frontend.utility;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class NordJyskeConnection extends AbstractConnection {
    String ip = "0.0.0.0";
    String port = "480";
    @Override
    public String CreateURL(String methodName) {
        return "http://" + ip +":"+ port +"/" + methodName;
    }

    public String Search (String objekt, String subject ,String predicate) {
        List<NameValuePair> parameters = new ArrayList<>();
        parameters.add(new BasicNameValuePair("objekt", objekt));
        parameters.add(new BasicNameValuePair("subject", subject));
        parameters.add(new BasicNameValuePair("predicate", predicate));

        return Request("factcheck ",parameters);
    }
}
