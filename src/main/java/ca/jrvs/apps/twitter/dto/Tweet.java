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
        "entities",
        "coordinates",
        "retweet_count",
        "favorite_count",
        "favorited",
        "retweeted"
})
public class Tweet {

  @JsonProperty("created_at")
  private String createdAt;

  @JsonProperty("id")
  private long id;

  @JsonProperty("id_str")
  private String idStr;

  @JsonProperty("text")
  private String text;

  @JsonProperty("entities")
  private Entities entities;

  @JsonProperty("coordinates")
  private Coordinates coordinates;

  @JsonProperty("retweet_count")
  private long retweetCount;

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

  @JsonProperty("id")
  public long getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(long id) {
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

  @JsonProperty("text")
  public String getText() {
    return text;
  }

  @JsonProperty("text")
  public void setText(String text) {
    this.text = text;
  }

  @JsonProperty("entities")
  public Entities getEntities() {
    return entities;
  }

  @JsonProperty("entities")
  public void setEntities(Entities entities) {
    this.entities = entities;
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
