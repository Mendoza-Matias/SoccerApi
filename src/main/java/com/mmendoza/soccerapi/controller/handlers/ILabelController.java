package com.mmendoza.soccerapi.controller.handlers;

import com.mmendoza.soccerapi.domain.dto.label.LabelDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("api/soccer/labels")
public interface ILabelController {

    @GetMapping
    ResponseEntity<List<LabelDto>> getAllLabels();

    @PostMapping
    ResponseEntity<Void> createNewLabel(@RequestBody String description);
}
