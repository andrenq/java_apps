package ca.jrvs.apps.twitter.dao;

import oauth.signpost.exception.OAuthException;
import java.io.IOException;

public interface CrdRepository<T, ID> {
    T create(T entity) throws IOException, OAuthException;

    T findById(ID id) throws IOException, OAuthException;

    T deleteById(ID id) throws IOException, OAuthException;
}
