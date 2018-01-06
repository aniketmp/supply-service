package no.tusla.supplyservice.model.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Model X",
        "Model Y",
        "Model Z"
})
public class ModelNextSeason {

    @JsonProperty("Model X")
    private List<ModelXNextSeason> modelXNextSeason;
    @JsonProperty("Model Y")
    private List<ModelYNextSeason> modelYNextSeason;
    @JsonProperty("Model Z")
    private List<ModelZNextSeason> modelZNextSeason;

    /**
     * No args constructor for use in serialization
     */
    public ModelNextSeason() {
    }

    /**
     * @param modelXNextSeason
     * @param modelYNextSeason
     * @param modelZNextSeason
     */
    public ModelNextSeason(List<ModelXNextSeason> modelXNextSeason, List<ModelYNextSeason> modelYNextSeason, List<ModelZNextSeason> modelZNextSeason) {
        super();
        this.modelXNextSeason = modelXNextSeason;
        this.modelYNextSeason = modelYNextSeason;
        this.modelZNextSeason = modelZNextSeason;
    }

    @JsonProperty("Model X")
    public List<ModelXNextSeason> getModelXNextSeason() {
        return modelXNextSeason;
    }

    @JsonProperty("Model X")
    public void setModelXNextSeason(List<ModelXNextSeason> modelXNextSeason) {
        this.modelXNextSeason = modelXNextSeason;
    }

    @JsonProperty("Model Y")
    public List<ModelYNextSeason> getModelYNextSeason() {
        return modelYNextSeason;
    }

    @JsonProperty("Model Y")
    public void setModelYNextSeason(List<ModelYNextSeason> modelYNextSeason) {
        this.modelYNextSeason = modelYNextSeason;
    }

    @JsonProperty("Model Z")
    public List<ModelZNextSeason> getModelZNextSeason() {
        return modelZNextSeason;
    }

    @JsonProperty("Model Z")
    public void setModelZNextSeason(List<ModelZNextSeason> modelZNextSeason) {
        this.modelZNextSeason = modelZNextSeason;
    }

}
