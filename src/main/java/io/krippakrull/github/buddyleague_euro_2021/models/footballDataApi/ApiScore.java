
package io.krippakrull.github.buddyleague_euro_2021.models.footballDataApi;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "winner",
    "duration",
    "fullTime",
    "halfTime",
    "extraTime",
    "penalties"
})
@Generated("jsonschema2pojo")
public class ApiScore {

    @JsonProperty("winner")
    private Object winner;
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("fullTime")
    private FullTime fullTime;
    @JsonProperty("halfTime")
    private HalfTime halfTime;
    @JsonProperty("extraTime")
    private ExtraTime extraTime;
    @JsonProperty("penalties")
    private Penalties penalties;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("winner")
    public Object getWinner() {
        return winner;
    }

    @JsonProperty("winner")
    public void setWinner(Object winner) {
        this.winner = winner;
    }

    @JsonProperty("duration")
    public String getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(String duration) {
        this.duration = duration;
    }

    @JsonProperty("fullTime")
    public FullTime getFullTime() {
        return fullTime;
    }

    @JsonProperty("fullTime")
    public void setFullTime(FullTime fullTime) {
        this.fullTime = fullTime;
    }

    @JsonProperty("halfTime")
    public HalfTime getHalfTime() {
        return halfTime;
    }

    @JsonProperty("halfTime")
    public void setHalfTime(HalfTime halfTime) {
        this.halfTime = halfTime;
    }

    @JsonProperty("extraTime")
    public ExtraTime getExtraTime() {
        return extraTime;
    }

    @JsonProperty("extraTime")
    public void setExtraTime(ExtraTime extraTime) {
        this.extraTime = extraTime;
    }

    @JsonProperty("penalties")
    public Penalties getPenalties() {
        return penalties;
    }

    @JsonProperty("penalties")
    public void setPenalties(Penalties penalties) {
        this.penalties = penalties;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
