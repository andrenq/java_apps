package ca.jrvs.apps.twitter;

import ca.jrvs.apps.twitter.service.TwitterService;



public class TwitterCLIRunner {
  private TwitterService twitterService;

  public TwitterCLIRunner(TwitterService service) {
    this.twitterService = service;
  }


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
              "USAGE: TwitterCLIApp show tweet_id\n"+e);
    }

  }

  protected void deleteTweet(String[] args) {
/*    if (args.length != 2 || args[1].isEmpty()) {
      throw new RuntimeException("USAGE: TwitterCLIApp deleteTweets tweet_ids");
    }*/

    String tweetIds = args[1];
    String[] ids = tweetIds.split(",");
    twitterService.deleteTweets(ids);
  }

  public void run(String[] args){
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
        System.out.println("USAGE: TwitterCLIApp post|show|delete args");
        break;
    }
  }

}
