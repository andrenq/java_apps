package ca.jrvs.apps.twitter;

import ca.jrvs.apps.twitter.dto.Tweet;
import ca.jrvs.apps.twitter.service.TwitterService;


class TwitterCLIRunner {
  private TwitterService twitterService;

  TwitterCLIRunner(TwitterService service) {
    this.twitterService = service;
  }

  private void postTweet(String[] args) {
    if (args.length != 3) {
      throw new RuntimeException(
          "Missing arguments:\nUSAGE: TwitterCLIApp post \"tweet_text\" \"latitude:longitude\"");
    }
    String status = args[1];
    String coord = args[2];
    String[] coordArray = coord.split(":");
    Double latitude;
    Double longitude;
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

  private void showTweet(String[] args) {
    if (args.length < 2) {
      throw new RuntimeException("USAGE: TwitterCLIApp show tweet_id [fields]");
    }
      Tweet tweet = twitterService.showTweet(args[1], null);
      if (!(tweet.getIdStr() == null)) {
          System.out.println(tweet);
      } else {
          System.out.println("Could not find id:" + args[1]);
      }
  }

  private void deleteTweet(String[] args) {
    /*    if (args.length != 2 || args[1].isEmpty()) {
      throw new RuntimeException("USAGE: TwitterCLIApp deleteTweets tweet_ids");
    }*/
    String tweetIds = args[1];
    String[] ids = tweetIds.split(",");
      for (Tweet t : twitterService.deleteTweets(ids)) {
          System.out.println(t);
      }
  }

  void run(String[] args) {
    if (args.length < 2) {
      throw new RuntimeException("USAGE: TwitterCLIApp post|show|deleteTweets args");
    }
    switch (args[0].toLowerCase()) {
      case "post":
        postTweet(args);
        break;
      case "show":
        showTweet(args);
        break;
      case "delete":
        deleteTweet(args);
        break;
      default:
          throw new RuntimeException("USAGE: TwitterCLIApp post|show|deleteTweets args");
    }
  }
}
