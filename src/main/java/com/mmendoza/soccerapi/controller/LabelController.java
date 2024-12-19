package com.mmendoza.soccerapi.controller;

import com.mmendoza.soccerapi.domain.dto.label.LabelDto;
import com.mmendoza.soccerapi.domain.entities.Label;
import com.mmendoza.soccerapi.mappers.ILabelMapper;
import com.mmendoza.soccerapi.services.label.ServCreateNewLabel;
import com.mmendoza.soccerapi.services.label.ServGetAllLabels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class LabelController implements ILabelController {

    @Autowired
    private ServCreateNewLabel createNewLabel;

    @Autowired
    private ServGetAllLabels getAllLabels;

    @Autowired
    private ILabelMapper labelMapper;

    @Override
    public ResponseEntity<List<LabelDto>> getAllLabels() {

        List<Label> response = getAllLabels.run(null);

        return ResponseEntity.ok().body(labelMapper.toDtoList(response));
    }

    @Override
    public ResponseEntity<Void> createNewLabel(String description) {

        createNewLabel.run(description);

        return ResponseEntity.ok().build();
    }

}
