package knox.frontend.utility;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class NordJyskeConnection extends AbstractConnection {
  // String ip = "0.0.0.0";
  String ip = "localhost";
  String port = "9090";

  @Override
  public String CreateURL(String methodName) {
    String returnString = "http://" + ip + ":" + port + "/" + methodName;
    System.out.println(returnString);
    return returnString;
  }

  public String Search(NordJyskeSearchData searchData) {
    List<NameValuePair> parameters = new ArrayList<>();
    parameters.add(new BasicNameValuePair("objekt", searchData.getObject()));
    parameters.add(new BasicNameValuePair("subject", searchData.getSubject()));
    parameters.add(new BasicNameValuePair("predicate", searchData.getPredicate()));

    return Request("factcheck", parameters);
  }

  public String Article(String filename) {
    List<NameValuePair> parameters = new ArrayList<>();
    return Request(filename, parameters);
  }
}
