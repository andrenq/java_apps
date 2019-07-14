package ca.jrvs.apps.twitter;

import org.junit.Test;

import static org.junit.Assert.*;

public class TwitterCLITest {
    TwitterCLI twitterCLI = new TwitterCLI();
    String[] args1 = {"post", "Test Post C@maro 65 #test", "-14.6738:50.1234"}; //correct format with symbols
    String[] args2 = {"post", "Test Post", ""}; //missing coordinates
    String[] args3 = {"post", "", "-14.6738:50.1234"}; //missing status
    String[] args4 = {"show", "1150529237872500737", ""}; //Correct format
    String[] args5 = {"show", "G", ""}; //invalid ID
    String[] args6 = {"delete", "1150529237872500737,1150059384061472771"}; //Correct format
    String[] args7 = {"delete", "12345db"}; //invalid ID
    String[] args8 = {"", ""}; //missing args
    String[] args9 = {""}; //missing args

    @Test
    public void mainTestPost() {
        try {
            TwitterCLI.main(args1);
        } catch (Exception e) {
            fail();
        }

        try {
            TwitterCLI.main(args2);
            fail();
        } catch (Exception e) {
        }
        try {
            TwitterCLI.main(args3);
            fail();
        } catch (Exception e) {
        }
    }

    @Test
    public void mainTestShow() {
        try {
            TwitterCLI.main(args4);
        } catch (Exception e) {
            fail();
        }

        try {
            TwitterCLI.main(args5);
            fail();
        } catch (Exception e) {
        }
    }

    @Test
    public void mainTestDelete() {
        try {
            TwitterCLI.main(args6);
        } catch (Exception e) {
            fail();
        }

        try {
            TwitterCLI.main(args7);
            fail();
        } catch (Exception e) {
        }
    }

    @Test
    public void argsTest() {
        try {
            TwitterCLI.main(args8);
            fail();
        } catch (Exception e) {
        }
        try {
            TwitterCLI.main(args9);
            fail();
        } catch (Exception e) {
        }
    }
}
