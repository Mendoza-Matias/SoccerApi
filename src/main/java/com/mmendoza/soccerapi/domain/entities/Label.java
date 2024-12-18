package com.mmendoza.soccerapi.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Label {

    private Integer labelId;

    private String description;

    // private News news;
}
