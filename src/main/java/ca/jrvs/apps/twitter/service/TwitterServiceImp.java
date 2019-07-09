package ca.jrvs.apps.twitter.service;

import ca.jrvs.apps.twitter.dao.CrdRepository;
import ca.jrvs.apps.twitter.dao.TwitterRestDao;
import ca.jrvs.apps.twitter.dto.Tweet;
import ca.jrvs.apps.twitter.util.TwitterUtil;

import static ca.jrvs.apps.twitter.util.TwitterUtil.*;

public class TwitterServiceImp implements TwitterService {
    private CrdRepository dao = new TwitterRestDao();

    @Override
    public Tweet postTweet(String status, Double latitude, Double longitude) {
        Tweet postTweet = createTweet(status,latitude,longitude);
        validatePostTweet(postTweet);

        try {
            Tweet responseTweet = (Tweet) dao.create(postTweet);
            System.out.println(responseTweet);
        } catch (Exception e) {
            throw new RuntimeException("Failed to post tweet");
        }
        return postTweet;
    }

    @Override
    public void showTweet(String id, String[] fields) {
        validateID(id);
        try {
            Tweet responseTweet = (Tweet) dao.findById(id);
            System.out.println(responseTweet);
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve tweet");
        }
    }

    @Override
    public void deleteTweets(String[] ids) {

    }
}
