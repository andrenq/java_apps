package ca.jrvs.apps.twitter;


import ca.jrvs.apps.twitter.dao.TwitterRestDao;
import ca.jrvs.apps.twitter.dto.Coordinates;
import ca.jrvs.apps.twitter.dto.Tweet;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

import java.io.IOException;
import java.util.Arrays;

public class TwitterCLI {
    public static void main(String[] args)
            throws OAuthExpectationFailedException, OAuthCommunicationException,
            OAuthMessageSignerException, IOException {
        TwitterRestDao twitterRestDao = new TwitterRestDao();
        Tweet tweet = new Tweet();
        tweet.setText("another test,with location");
        double latitude = -20.53861;
        double longitude = -47.400829;
        Coordinates coordinates = new Coordinates();
        coordinates.setCoordinates(Arrays.asList(longitude, latitude));
        tweet.setCoordinates(coordinates);
        System.out.println(twitterRestDao.create(tweet));
    }

}
