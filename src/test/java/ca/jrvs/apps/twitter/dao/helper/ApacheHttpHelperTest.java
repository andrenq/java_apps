package ca.jrvs.apps.twitter.dao.helper;

import org.apache.http.HttpResponse;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;
import java.net.URLEncoder;

import static org.junit.Assert.*;

public class ApacheHttpHelperTest {
    private HttpHelper testHttpHelper;
    private String baseUrL = "https://api.twitter.com/1.1/statuses/";
    private String statusCall = "update.json?status=";
    private String message = "Testing apacheHttpHelper for more errors";
    private String findURL = "show.json?id=";
    private String tweetId = "1149019973693661184";

    @Before
    public void setup() {
        testHttpHelper = new ApacheHttpHelper();

    }

    @Test
    public void enviromentalVariablesTest() {
        Assume.assumeFalse("CONSUMER_KEY is empty", ApacheHttpHelper.CONSUMER_KEY.isEmpty());
        Assume.assumeFalse("CONSUMER_SECRET is empty", ApacheHttpHelper.CONSUMER_SECRET.isEmpty());
        Assume.assumeFalse("ACCESS_TOKEN is empty", ApacheHttpHelper.ACCESS_TOKEN.isEmpty());
        Assume.assumeFalse("TOKEN_SECRET is empty", ApacheHttpHelper.TOKEN_SECRET.isEmpty());
    }

    @Test
    public void testHttpPost() throws Exception {
        HttpResponse response = testHttpHelper.httpPost(URI.create(baseUrL + statusCall +
                URLEncoder.encode(message, "utf-8")));
        assertNotNull(response);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }

    @Test
    public void testHttpGet() throws Exception {
        HttpResponse response = testHttpHelper.httpGet(URI.create(baseUrL + findURL + tweetId));
        assertNotNull(response);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }
}
