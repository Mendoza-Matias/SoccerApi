package com.mmendoza.soccerapi.repository;

import com.mmendoza.soccerapi.domain.entities.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILabelRepository extends JpaRepository<Label, Integer> {
    Boolean existsByDescription(String description);
}
