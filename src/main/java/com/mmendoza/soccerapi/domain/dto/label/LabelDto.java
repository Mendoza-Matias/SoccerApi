package com.mmendoza.soccerapi.domain.dto.label;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonRootName(value = "label")
public class LabelDto {

    @JsonProperty(value = "label_id")
    private Integer labelId;

    @JsonProperty(value = "description")
    private String description;
}
