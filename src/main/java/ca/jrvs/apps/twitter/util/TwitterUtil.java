package ca.jrvs.apps.twitter.util;

import ca.jrvs.apps.twitter.dto.Coordinates;
import ca.jrvs.apps.twitter.dto.Tweet;
import java.util.Arrays;
import java.util.function.Predicate;

public class TwitterUtil {
  private static final Double MAX_LAT = 90d;
  private static final Double MIN_LAT = -90d;
  private static final Double MAX_LON = 180d;
  private static final Double MIN_LON = -180d;

  private static final Integer MAX_TWEET_CHAR = 280;

  // Validate a id - if not valid throws Illegal argument exception
  public static void validateID(String id) {
    if (id.isEmpty() || !id.chars().noneMatch(c -> c < '0' || c > '9'))
      throw new IllegalArgumentException("Tweet Id is in the wrong format");
  }

  // Validate a tweet - if not valid throws Illegal argument exception
  public static void validatePostTweet(Tweet tweet) {
    String status = tweet.getText();
    Double longitude = tweet.getCoordinates().getCoordinates().get(0);
    Double latitude = tweet.getCoordinates().getCoordinates().get(1);
    if ((latitude < MIN_LAT) || latitude > MAX_LAT) {
      throw new IllegalArgumentException("Invalid Latitude");
    }
    if ((longitude < MIN_LON) || longitude > MAX_LON) {
      throw new IllegalArgumentException(
              "Invalid location format: Longitude\n"
                      + "USAGE: TwitterCLIApp post \"tweet_text\" \"latitude:longitude\"");
    }
    if (status.isEmpty() || status.length() > MAX_TWEET_CHAR) {
      throw new IllegalArgumentException(
              "Invalid location format: Latitude\n"
                      + "USAGE: TwitterCLIApp post \"tweet_text\" \"latitude:longitude\"");
    }
  }

  // create tweet
  public static Tweet createTweet(String status, Double latitude, Double longitude) {
    Tweet tweet = new Tweet();
    tweet.setText(status);
    Coordinates coordinates = new Coordinates();
    coordinates.setCoordinates(Arrays.asList(latitude, longitude));
    tweet.setCoordinates(coordinates);
    validatePostTweet(tweet);
    return tweet;
  }
}
