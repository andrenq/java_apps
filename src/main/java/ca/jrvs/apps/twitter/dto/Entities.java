
package ca.jrvs.apps.twitter.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "hashtags",
        "symbols",
        "user_mentions",
        "urls",
        "media"
})
public class Entities {

    @JsonProperty("hashtags")
    private List<Hashtag> hashtags = null;
    @JsonProperty("symbols")
    private List<Object> symbols = null;
    @JsonProperty("user_mentions")
    private List<UserMention> userMentions = null;
    @JsonProperty("urls")
    private List<Object> urls = null;
    @JsonProperty("media")
    private List<Medium> media = null;

    @JsonProperty("hashtags")
    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    @JsonProperty("hashtags")
    public void setHashtags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }

    public Entities withHashtags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
        return this;
    }

    @JsonProperty("symbols")
    public List<Object> getSymbols() {
        return symbols;
    }

    @JsonProperty("symbols")
    public void setSymbols(List<Object> symbols) {
        this.symbols = symbols;
    }

    public Entities withSymbols(List<Object> symbols) {
        this.symbols = symbols;
        return this;
    }

    @JsonProperty("user_mentions")
    public List<UserMention> getUserMentions() {
        return userMentions;
    }

    @JsonProperty("user_mentions")
    public void setUserMentions(List<UserMention> userMentions) {
        this.userMentions = userMentions;
    }

    public Entities withUserMentions(List<UserMention> userMentions) {
        this.userMentions = userMentions;
        return this;
    }

    @JsonProperty("urls")
    public List<Object> getUrls() {
        return urls;
    }

    @JsonProperty("urls")
    public void setUrls(List<Object> urls) {
        this.urls = urls;
    }

    public Entities withUrls(List<Object> urls) {
        this.urls = urls;
        return this;
    }

    @JsonProperty("media")
    public List<Medium> getMedia() {
        return media;
    }

    @JsonProperty("media")
    public void setMedia(List<Medium> media) {
        this.media = media;
    }

    public Entities withMedia(List<Medium> media) {
        this.media = media;
        return this;
    }

    @Override
    public String toString() {
        return "Entities{" +
                "hashtags=" + hashtags +
                ", symbols=" + symbols +
                ", userMentions=" + userMentions +
                ", urls=" + urls +
                ", media=" + media +
                '}';
    }
}
