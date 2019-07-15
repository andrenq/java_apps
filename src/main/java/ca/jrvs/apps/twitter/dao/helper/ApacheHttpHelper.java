package ca.jrvs.apps.twitter.dao.helper;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;

@SuppressWarnings("Duplicates")
@Component
public class ApacheHttpHelper implements HttpHelper {
    static final String CONSUMER_KEY = System.getenv("consumerKey");
    static final String CONSUMER_SECRET = System.getenv("consumerSecret");
    static final String ACCESS_TOKEN = System.getenv("accessToken");
    static final String TOKEN_SECRET = System.getenv("tokenSecret");

    private HttpClient httpClient = HttpClientBuilder.create().build();

    private OAuthConsumer oAuthConsumer() {
        OAuthConsumer consumer = new CommonsHttpOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
        consumer.setTokenWithSecret(ACCESS_TOKEN, TOKEN_SECRET);
        return consumer;
    }

    @Override
    public HttpResponse httpPost(URI uri, StringEntity stringEntity)
            throws OAuthException, IOException {
        HttpPost request = new HttpPost(uri);
        if (stringEntity != null) {
            request.setEntity(stringEntity);
        }
        oAuthConsumer().sign(request);
        return httpClient.execute(request);
    }

    @Override
    public HttpResponse httpPost(URI uri) throws OAuthException, IOException {
        HttpPost request = new HttpPost(uri);
        oAuthConsumer().sign(request);
        return httpClient.execute(request);
    }

    @Override
    public HttpResponse httpGet(URI uri) throws OAuthException, IOException {
        HttpGet request = new HttpGet(uri);
        oAuthConsumer().sign(request);
        return httpClient.execute(request);
    }
}
