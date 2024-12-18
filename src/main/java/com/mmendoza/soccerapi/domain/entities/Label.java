package com.mmendoza.soccerapi.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "labels")

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Label {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer labelId;

    @Column(name = "description", unique = true, nullable = false, length = 25)
    private String description;

    // private News news;
}
