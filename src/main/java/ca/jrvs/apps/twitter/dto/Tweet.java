package ca.jrvs.apps.twitter.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "created_at",
  "id",
  "id_str",
  "text",
  "truncated",
  "entities",
  "source",
  "in_reply_to_status_id",
  "in_reply_to_status_id_str",
  "in_reply_to_user_id",
  "in_reply_to_user_id_str",
  "in_reply_to_screen_name",
  "user",
  "geo",
  "coordinates",
  "place",
  "contributors",
  "is_quote_status",
  "retweet_count",
  "favorite_count",
  "favorited",
  "retweeted",
  "lang",
  "retweeted_status",
  "extended_entities",
  "possibly_sensitive"
})
public class Tweet {

  @JsonProperty("created_at")
  private String createdAt;

  @JsonProperty("id")
  private Long id;

  @JsonProperty("id_str")
  private String idStr;

  @JsonProperty("text")
  private String text;

  @JsonProperty("entities")
  private Entities entities;

  @JsonProperty("coordinates")
  private Coordinates coordinates;

  @JsonProperty("retweet_count")
  private Long retweetCount;

  @JsonProperty("favorite_count")
  private Long favoriteCount;

  @JsonProperty("favorited")
  private Boolean favorited;

  @JsonProperty("retweeted")
  private Boolean retweeted;

  @JsonProperty("created_at")
  public String getCreatedAt() {
    return createdAt;
  }

  @JsonProperty("created_at")
  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public Tweet withCreatedAt(String createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(Long id) {
    this.id = id;
  }

  @JsonProperty("id_str")
  public String getIdStr() {
    return idStr;
  }

  @JsonProperty("id_str")
  public void setIdStr(String idStr) {
    this.idStr = idStr;
  }

  public Tweet withIdStr(String idStr) {
    this.idStr = idStr;
    return this;
  }

  @JsonProperty("text")
  public String getText() {
    return text;
  }

  @JsonProperty("text")
  public void setText(String text) {
    this.text = text;
  }

  public Tweet withText(String text) {
    this.text = text;
    return this;
  }

  @JsonProperty("entities")
  public Entities getEntities() {
    return entities;
  }

  @JsonProperty("entities")
  public void setEntities(Entities entities) {
    this.entities = entities;
  }

  public Tweet withEntities(Entities entities) {
    this.entities = entities;
    return this;
  }

  @JsonProperty("coordinates")
  public Coordinates getCoordinates() {
    return coordinates;
  }

  @JsonProperty("coordinates")
  public void setCoordinates(Coordinates coordinates) {
    this.coordinates = coordinates;
  }

  @JsonProperty("favorited")
  public Boolean getFavorited() {
    return favorited;
  }

  @JsonProperty("retweeted")
  public Boolean getRetweeted() {
    return retweeted;
  }

  @JsonProperty("retweeted")
  public void setRetweeted(Boolean retweeted) {
    this.retweeted = retweeted;
  }

  public Tweet withRetweeted(Boolean retweeted) {
    this.retweeted = retweeted;
    return this;
  }

  @Override
  public String toString() {
    return "Tweet:\n"
        + "\tcreatedAt:\t\t'"
        + createdAt
        + '\''
        + "\n"
        + "\tid:\t\t\t\t"
        + id
        + "\n"
        + "\tidStr:\t\t\t'"
        + idStr
        + '\''
        + "\n"
        + "\ttext:\t\t\t'"
        + text
        + '\''
        + "\n"
        + "\tretweeted:\t\t"
        + retweeted
        + "\n"
        + "\tcoordinates:\t"
        + coordinates
        + "\n"
        + "\tretweetCount:\t"
        + retweetCount
        + "\n"
        + "\tfavoriteCount:\t"
        + favoriteCount
        + "\n"
        + "\tfavorited:\t\t"
        + favorited
        + "\n"
        + "\tentities:\t\t"
        + entities
        + "\n";
  }
}
