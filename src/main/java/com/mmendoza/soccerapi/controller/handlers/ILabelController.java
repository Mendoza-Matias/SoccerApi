package com.mmendoza.soccerapi.controller.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/soccer/labels")
public interface ILabelController {
    @PostMapping
    ResponseEntity<Void> createNewLabel(@RequestBody String description);
}
