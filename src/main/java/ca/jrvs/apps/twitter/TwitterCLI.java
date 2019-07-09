package ca.jrvs.apps.twitter;


import ca.jrvs.apps.twitter.dao.CrdRepository;
import ca.jrvs.apps.twitter.dao.TwitterRestDao;
import ca.jrvs.apps.twitter.dao.helper.ApacheHttpHelper;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.service.TwitterService;
import ca.jrvs.apps.twitter.service.TwitterServiceImp;


public class TwitterCLI {
    public static void main(String[] args) {
        //Create components
        HttpHelper httpHelper = new ApacheHttpHelper();
        CrdRepository dao = new TwitterRestDao(httpHelper);
        TwitterService service = new TwitterServiceImp(dao);

        //Create Runner
        TwitterCLIRunner runner = new TwitterCLIRunner(service);

        String text = ("Last deleted IDs 1148671689263386633,1148671177977552896");
        double latitude = -20.53861;
        double longitude = -47.400829;
        String coord = latitude+":"+longitude;
        String[] args2 = new String[3];
        args2[0] = "post";
        args2[1] = text;
        args2[2] = coord;

        //Run Application
        runner.run(args2);
    }

}
