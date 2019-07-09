package ca.jrvs.apps.twitter.dao.helper;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.net.URI;

public class ApacheHttpHelper implements HttpHelper{
    private static String CONSUMER_KEY = System.getenv("consumerKey");
    private static String CONSUMER_SECRET = System.getenv("consumerSecret");
    private static String ACCESS_TOKEN = System.getenv("accessToken");
    private static String TOKEN_SECRET = System.getenv("tokenSecret");

    private OAuthConsumer oAuthConsumer() {
        OAuthConsumer consumer = new CommonsHttpOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
        consumer.setTokenWithSecret(ACCESS_TOKEN, TOKEN_SECRET);
        return consumer;
    }

    @Override
    public HttpResponse httpPost(URI uri, StringEntity stringEntity)
            throws OAuthCommunicationException, OAuthExpectationFailedException,
            OAuthMessageSignerException, IOException {
        HttpPost request = new HttpPost(uri);
        if (stringEntity != null) {
            request.setEntity(stringEntity);
        }
        oAuthConsumer().sign(request);
        HttpClient httpClient = new DefaultHttpClient();
        HttpResponse response = httpClient.execute(request);
        return response;
    }



    @Override
    public HttpResponse httpPost(URI uri)
            throws OAuthExpectationFailedException, OAuthMessageSignerException, IOException,
            OAuthCommunicationException {
        HttpPost request = new HttpPost(uri);
        oAuthConsumer().sign(request);
        HttpClient httpClient = new DefaultHttpClient();
        HttpResponse response = httpClient.execute(request);
        return response;
    }

    @Override
    public HttpResponse httpGet(URI uri)
            throws OAuthExpectationFailedException, OAuthCommunicationException,
            OAuthMessageSignerException, IOException {
        HttpGet request = new HttpGet(uri);
        oAuthConsumer().sign(request);
        HttpClient httpClient = new DefaultHttpClient();
        HttpResponse response = httpClient.execute(request);
        return response;
    }
}
