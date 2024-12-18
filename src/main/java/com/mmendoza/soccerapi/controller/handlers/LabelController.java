package com.mmendoza.soccerapi.controller.handlers;

import com.mmendoza.soccerapi.services.label.ServCreateNewLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class LabelController implements ILabelController {

    @Autowired
    private ServCreateNewLabel createNewLabel;

    @Override
    public ResponseEntity<Void> createNewLabel(String description) {
        createNewLabel.run(description);
        return ResponseEntity.ok().build();
    }

}
