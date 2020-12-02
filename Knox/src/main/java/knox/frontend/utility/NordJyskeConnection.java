package knox.frontend.utility;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class NordJyskeConnection extends AbstractConnection {
    //String ip = "0.0.0.0";
    String ip = "192.38.49.147";
    String port = "9090";
    @Override
    public String CreateURL(String methodName) {
        String returnString = "http://" + ip +":"+ port +"/" + methodName;
        System.out.println(returnString);
        return returnString;
    }

    public String Search (String objekt, String subject ,String predicate) {
        List<NameValuePair> parameters = new ArrayList<>();
        parameters.add(new BasicNameValuePair("objekt", objekt));
        parameters.add(new BasicNameValuePair("subject", subject));
        parameters.add(new BasicNameValuePair("predicate", predicate));

        return Request("factcheck",parameters);
    }
}
