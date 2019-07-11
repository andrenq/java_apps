package ca.jrvs.apps.twitter.util;

import ca.jrvs.apps.twitter.dto.Coordinates;
import ca.jrvs.apps.twitter.dto.Tweet;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.Assert.*;

public class TwitterUtilTest {
    @Test
    public void validatePostTweetTest() {

        try {
            Tweet tweet1 = TwitterUtil.createTweet("new msg", -40.4320, -20.1234);
        } catch (IllegalArgumentException e) {
            fail("Tweet on right format, should not fail");
        }

        try {
            Tweet tweet2 = TwitterUtil.createTweet("new msg", -240.4320, -20.1234);
            fail("Invalid coordinates:\nShould throw exception before this point");
        } catch (IllegalArgumentException e) {
        }

        try {
            Tweet tweet3 = TwitterUtil.createTweet("", -20.4320, -20.1234);
            fail("Invalid status msg:\nShould throw exception before this point");
        } catch (IllegalArgumentException e) {
        }
        try {
            Tweet tweet3 =
                    TwitterUtil.createTweet(
                            "qwerqweqweqweqweqweqwexzczc asdasdasd123asd asddasd123das "
                                    + "adqwdsdasdasddsaf asdasdasdqdef sdsdfsdfdfsdfsdf addfsdfsdfdsfsdvvcxxv sdfwer23rfdsfsdfvcxvcxvxcv "
                                    + "vsdsdfdsfdfsdfsdfsdfsdvxcvxvc ndajsldnjkasndajsknjnmsana,dnsakasndsakjdnasmdnaskndkasjdnaksjdnm,nda"
                                    + "makldmakldmaskldmnvcxkvnkjxcnvjnqenooi naoksdno!nomosdjf #ifjsdiojosidjf ^hsdjnsdjfksndflkmkdlfmskdf",
                            -40.4320,
                            -20.1234);
            fail("Invalid status msg:\nShould throw exception before this point");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testValidateID() {
        String id = "123d";
        try {
            TwitterUtil.validateID(id);
            fail("Id should fail and not reach this instruction");
        } catch (IllegalArgumentException e) {
            assertTrue(!e.getMessage().isEmpty());
        }
        id = "123345678902345678";
        try {
            TwitterUtil.validateID(id);
        } catch (IllegalArgumentException e) {
            fail("Id should not fail");
        }
    }
}
