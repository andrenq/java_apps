package ca.jrvs.apps.twitter.dao;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

import java.io.IOException;

public interface CrdRepository<T, ID> {
  T create(T entity)
      throws IOException, OAuthCommunicationException, OAuthExpectationFailedException,
          OAuthMessageSignerException;

  T findById(ID id)
      throws OAuthExpectationFailedException, OAuthCommunicationException,
          OAuthMessageSignerException, IOException;

  T deleById(ID id)
      throws OAuthExpectationFailedException, OAuthCommunicationException,
          OAuthMessageSignerException, IOException;
}
