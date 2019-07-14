package ca.jrvs.apps.twitter.service;

import ca.jrvs.apps.twitter.dao.CrdRepository;
import ca.jrvs.apps.twitter.dto.Tweet;
import oauth.signpost.exception.OAuthException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ca.jrvs.apps.twitter.util.TwitterUtil.*;

public class TwitterServiceImp implements TwitterService {
  private CrdRepository dao;

  public TwitterServiceImp(CrdRepository dao) {
    this.dao = dao;
  }

  @Override
  public Tweet postTweet(String status, Double latitude, Double longitude) {
    Tweet postTweet = createTweet(status, latitude, longitude);
    validatePostTweet(postTweet);

    Tweet responseTweet;
    try {
      responseTweet = (Tweet) dao.create(postTweet);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    System.out.println("Created tweet:");
    System.out.println(responseTweet);
    return responseTweet;
  }

  @Override
  public Tweet showTweet(String id, String[] fields) {
    validateID(id);
    try {
      Tweet responseTweet = (Tweet) dao.findById(id);
      return responseTweet;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public List<Tweet> deleteTweets(String[] ids) {
    System.out.println("Deleted tweet(s):");
    List<Tweet> tweetList = new ArrayList<>();
    for (String id : ids) {
      try {
        validateID(id);
        Tweet responseTweet = (Tweet) dao.deleteById(id);
        if (!responseTweet.getIdStr().isEmpty()) {
          tweetList.add(responseTweet);
        }
      } catch (IllegalArgumentException e) {
        throw e;
      } catch (Exception e) {
        System.out.println("Could not delete id: " + id);
      }
    }
    return tweetList;
  }
}
