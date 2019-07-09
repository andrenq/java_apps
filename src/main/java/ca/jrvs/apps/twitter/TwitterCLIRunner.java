package ca.jrvs.apps.twitter;

import ca.jrvs.apps.twitter.dto.Tweet;
import ca.jrvs.apps.twitter.service.TwitterService;
import ca.jrvs.apps.twitter.service.TwitterServiceImp;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import java.io.IOException;


public class TwitterCLIRunner {
  private TwitterService twitterService = new TwitterServiceImp();


  public void postTweet(String[] args) {
    if (args.length != 3) {
      throw new RuntimeException(
          "Missing arguments:\nUSAGE: TwitterCLIApp post \"tweet_text\" \"latitude:longitude\"");
    }
    String status = args[1];
    String coord = args[2];
    String[] coordArray = coord.split(":");
    Double latitude = null;
    Double longitude = null;
    try {
      latitude = Double.parseDouble(coordArray[0]);
      longitude = Double.parseDouble(coordArray[1]);
    } catch (Exception e) {
      throw new RuntimeException(
          "Invalid location format\nUSAGE: TwitterCLIApp post \"tweet_text\" \"latitude:longitude\"",
          e);
    }
    twitterService.postTweet(status, latitude, longitude);
  }

  public void showTweet(String[] args){
    if (args.length<2){
      throw new RuntimeException("USAGE: TwitterCLIApp show tweet_id [fields]");
    }
    try{
      String tweet_id = args[1];
      twitterService.showTweet(tweet_id,null);
    }catch (Exception e){
      throw new RuntimeException(
              "USAGE: TwitterCLIApp show tweet_id");
    }


  }

  public static void main(String[] args)
      throws OAuthExpectationFailedException, OAuthCommunicationException,
          OAuthMessageSignerException, IOException {
    TwitterService twitterService = new TwitterServiceImp();
    TwitterCLIRunner runner = new TwitterCLIRunner();
    Tweet tweet = new Tweet();
    String text = ("1148599198096482304");
    double latitude = -20.53861;
    double longitude = -47.400829;
    String coord = latitude+":"+longitude;
    String[] args2 = new String[3];
    args2[0] = "SHOW";
    args2[1] = text;
    args2[2] = coord;
    //runner.postTweet(args2);
    runner.showTweet(args2);
  }
}
