package ca.jrvs.apps.twitter.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"screen_name", "name", "id", "id_str", "indices"})
public class UserMention {

  @JsonProperty("screen_name")
  private String screenName;

  @JsonProperty("name")
  private String name;

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("id_str")
  private String idStr;

  @JsonProperty("indices")
  private List<Integer> indices = null;

  @JsonProperty("screen_name")
  public String getScreenName() {
    return screenName;
  }

  @JsonProperty("screen_name")
  public void setScreenName(String screenName) {
    this.screenName = screenName;
  }

  public UserMention withScreenName(String screenName) {
    this.screenName = screenName;
    return this;
  }

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  public UserMention withName(String name) {
    this.name = name;
    return this;
  }

  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(Integer id) {
    this.id = id;
  }

  public UserMention withId(Integer id) {
    this.id = id;
    return this;
  }

  @JsonProperty("id_str")
  public String getIdStr() {
    return idStr;
  }

  @JsonProperty("id_str")
  public void setIdStr(String idStr) {
    this.idStr = idStr;
  }

  public UserMention withIdStr(String idStr) {
    this.idStr = idStr;
    return this;
  }

  @JsonProperty("indices")
  public List<Integer> getIndices() {
    return indices;
  }

  @JsonProperty("indices")
  public void setIndices(List<Integer> indices) {
    this.indices = indices;
  }

  public UserMention withIndices(List<Integer> indices) {
    this.indices = indices;
    return this;
  }

  @Override
  public String toString() {
    return "UserMention{"
        + "screenName='"
        + screenName
        + '\''
        + ", name='"
        + name
        + '\''
        + ", id="
        + id
        + ", idStr='"
        + idStr
        + '\''
        + ", indices="
        + indices
        + '}';
  }
}
