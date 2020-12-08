package knox.frontend.utility;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.HttpsURLConnection;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.List;

public abstract class AbstractConnection {
    public String Request (String methodName,List<NameValuePair> parameters)  {
        try {

            HttpPost post = new HttpPost(CreateURL(methodName));

            // add request parameter, form parameters
            post.setEntity(new UrlEncodedFormEntity(parameters));


            CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = httpClient.execute(post);
            String returnString = EntityUtils.toString(response.getEntity());
            return returnString;

        } catch (IOException e){
            throw new Error ("Error occurred while attempting to connect to an API : " + e);
        }
    }
    public abstract String CreateURL(String methodName);

}
