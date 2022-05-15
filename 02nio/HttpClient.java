import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClient {
    public static void main(String[] arg){
        String url = "http://localhost:8801";
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpClient httpCLient = HttpClients.createDefault();
        try(CloseableHttpResponse httpResponse =httpCLient.execute(httpGet)) {
            HttpEntity entity = httpResponse.getEntity();
            System.out.println(EntityUtils.toString(entity));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpCLient.close();
                httpGet.releaseConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
