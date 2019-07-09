
package ca.jrvs.apps.twitter.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "text",
        "indices"
})
public class Hashtag {

    @JsonProperty("text")
    private String text;
    @JsonProperty("indices")
    private List<Integer> indices = null;

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    public Hashtag withText(String text) {
        this.text = text;
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

    public Hashtag withIndices(List<Integer> indices) {
        this.indices = indices;
        return this;
    }

    @Override
    public String toString() {
        return "Hashtag{" +
                "text='" + text + '\'' +
                ", indices=" + indices +
                '}';
    }
}
