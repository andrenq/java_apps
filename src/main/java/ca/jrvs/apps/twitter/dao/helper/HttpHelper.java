package ca.jrvs.apps.twitter.dao.helper;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import org.apache.http.HttpResponse;
import org.apache.http.entity.StringEntity;

import java.io.IOException;
import java.net.URI;

public interface HttpHelper {
    HttpResponse httpPost(URI uri) throws OAuthCommunicationException, OAuthExpectationFailedException, OAuthMessageSignerException, IOException;
    HttpResponse httpPost(URI uri, StringEntity stringEntity) throws OAuthCommunicationException, OAuthExpectationFailedException, OAuthMessageSignerException, IOException;
    HttpResponse httpGet(URI uri) throws OAuthExpectationFailedException, OAuthCommunicationException, OAuthMessageSignerException, IOException;
}
