package ca.jrvs.apps.twitter.service;

import ca.jrvs.apps.twitter.dao.CrdRepository;
import ca.jrvs.apps.twitter.dto.Coordinates;
import ca.jrvs.apps.twitter.dto.Tweet;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TwitterServiceImpTest {

    private final String status = "Testingh Twitter Service Imp";
    private final String idStr = "345678909876543";
    private final Double latitude = 40.3246;
    private final Double longitude = 23.3412;
    public Tweet mockTweet = new Tweet();

    @Mock
    CrdRepository mockDao;
    @InjectMocks
    TwitterServiceImp service;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(mockDao.create(any())).thenReturn(mockTweet);
        when(mockDao.deleteById(any())).thenReturn(mockTweet);
        when(mockDao.findById(any())).thenReturn(mockTweet);

        Coordinates coordinates = new Coordinates();
        coordinates.setCoordinates(Arrays.asList(latitude, longitude));
        mockTweet.setText(status);
        mockTweet.setCoordinates(coordinates);
        mockTweet.setIdStr(idStr);

    }

    @Test
    public void postTweetTest() {
        Tweet actualTweet = service.postTweet(status, latitude, longitude);
        assertEquals(mockTweet, actualTweet);
    }

    @Test
    public void showTweetTest() throws Exception {
        try {
            Tweet actualTweet = service.showTweet(mockTweet.getIdStr(), new String[]{""});
            assertEquals(mockTweet, actualTweet);
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void deleteTweetsTest() {
        mockTweet.setIdStr(idStr);
        try {
            Tweet actualTweet = service.deleteTweets(new String[]{mockTweet.getIdStr()}).get(0);
            assertEquals(mockTweet, actualTweet);
        } catch (IllegalArgumentException e) {
            fail();
        }
    }
}
