
package ca.jrvs.apps.twitter.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "coordinates"
})
public class Coordinates {

    @JsonProperty("type")
    private String type;
    @JsonProperty("coordinates")
    private List<Double> coordinates = null;

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public Coordinates withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("coordinates")
    public List<Double> getCoordinates() {
        return coordinates;
    }

    @JsonProperty("coordinates")
    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates withCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
        return this;
    }

}
