package ca.jrvs.apps.twitter.dao;

import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dto.Tweet;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import static ca.jrvs.apps.twitter.example.JsonParser.toObjectFromJson;

@Repository
public class TwitterRestDao implements CrdRepository<Tweet, String> {
  // Response code
  private static final int HTTP_OK = 200;
  private final String baseURL = "https://api.twitter.com/1.1/statuses/";
  private HttpHelper httpHelper;

  @Autowired
  public TwitterRestDao(HttpHelper httpHelper) {
    this.httpHelper = httpHelper;
  }

  @Override
  public Tweet create(Tweet entity) throws OAuthException, IOException {
    String status = "status=" + URLEncoder.encode(entity.getText(), "utf-8");
    String latitude = "lat=" + entity.getCoordinates().getCoordinates().get(0);
    String longitude = "long=" + entity.getCoordinates().getCoordinates().get(1);
    String AMPERSAND = "&";
    String saveURL = "update.json?";
    String postUrl = baseURL + saveURL + status + AMPERSAND + latitude + AMPERSAND + longitude;
    HttpResponse response = httpHelper.httpPost(URI.create(postUrl));
    if (response.getStatusLine().getStatusCode() % HTTP_OK > 2) {
      throw new RuntimeException(
              "\nError posting tweet:\nHTTP response: " + response.getStatusLine().toString());
    }
    return toObjectFromJson(EntityUtils.toString(response.getEntity()), Tweet.class);
  }

  @Override
  public Tweet findById(String s) throws OAuthException, IOException {
    String findURL = "show.json?id=";
    HttpResponse response = httpHelper.httpGet(URI.create(baseURL + findURL + s));
    if (response.getStatusLine().getStatusCode() % HTTP_OK > 2) {
      System.out.println("\nCould not find tweet:\nHTTP response: " + response.getStatusLine());
    }
    return toObjectFromJson(EntityUtils.toString(response.getEntity()), Tweet.class);
  }

  @Override
  public Tweet deleteById(String s) throws OAuthException, IOException {
    String deleURL = "destroy/";
    HttpResponse response = httpHelper.httpPost(URI.create(baseURL + deleURL + s + ".json"));
    return toObjectFromJson(EntityUtils.toString(response.getEntity()), Tweet.class);
  }
}
