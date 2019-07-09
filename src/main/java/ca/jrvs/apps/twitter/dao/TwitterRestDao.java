package ca.jrvs.apps.twitter.dao;

import ca.jrvs.apps.twitter.dao.helper.ApacheHttpHelper;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dto.Tweet;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import static ca.jrvs.apps.twitter.example.JsonParser.toObjectFromJson;

public class TwitterRestDao implements CrdRepository<Tweet, String> {
  private final String saveURL = "https://api.twitter.com/1.1/statuses/update.json?";
  private final String findURL = "https://api.twitter.com/1.1/statuses/show.json?id=";
  private final String deleURL = "https://api.twitter.com/1.1/statuses/destroy/";
  private final String AMPERSAND = "&";
  //Response code
  private static final int HTTP_OK = 200;

  private HttpHelper httpHelper;

  public TwitterRestDao(HttpHelper httpHelper) {
    this.httpHelper = httpHelper;
  }

  @Override
  public Tweet create(Tweet entity)
      throws IOException, OAuthCommunicationException, OAuthExpectationFailedException,
          OAuthMessageSignerException {
    String status = "status=" + URLEncoder.encode(entity.getText(), "utf-8");
    String latitude = "lat=" + entity.getCoordinates().getCoordinates().get(0);
    String longitude = "long=" + entity.getCoordinates().getCoordinates().get(1);
    String postUrl = saveURL + status + AMPERSAND + latitude + AMPERSAND + longitude;
    HttpResponse response = httpHelper.httpPost(URI.create(postUrl));
    System.out.println("Created tweet:");
    if(response.getStatusLine().getStatusCode()>HTTP_OK+99){
      System.out.println("Could not create tweet:\n" +
              response.getStatusLine());
      throw new RuntimeException();
    }
    return toObjectFromJson(EntityUtils.toString(response.getEntity()), Tweet.class);
  }

  @Override
  public Tweet findById(String s)
      throws OAuthExpectationFailedException, OAuthCommunicationException,
          OAuthMessageSignerException, IOException {
    HttpResponse response = httpHelper.httpGet(URI.create(findURL + s));
    if(response.getStatusLine().getStatusCode()>HTTP_OK+99){
      throw new RuntimeException("Could not find tweet:\n" +
              response.getStatusLine());
    }
    return toObjectFromJson(EntityUtils.toString(response.getEntity()), Tweet.class);
  }

  @Override
  public Tweet deleById(String s)
      throws OAuthExpectationFailedException, OAuthCommunicationException,
          OAuthMessageSignerException, IOException {
    HttpResponse response = httpHelper.httpPost(URI.create(deleURL + s + ".json"));
    return toObjectFromJson(EntityUtils.toString(response.getEntity()), Tweet.class);
  }
}
