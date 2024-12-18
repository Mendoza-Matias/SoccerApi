package com.mmendoza.soccerapi.controller.handlers;

import com.mmendoza.soccerapi.services.label.ServCreateNewLabel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LabelControllerCreateNewLabelTest {

    @InjectMocks
    private LabelController labelController;

    @Mock
    private ServCreateNewLabel servCreateNewLabel;

    private String description;

    @BeforeEach
    void setUp() {
        description = "description";
    }

    @Test
    void verifyResponse() {

        /* Capture the value that reaches the service */
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        Mockito.doNothing().when(servCreateNewLabel).run(captor.capture());

        ResponseEntity<Void> result = labelController.createNewLabel(description);

        assertEquals(HttpStatus.OK, result.getStatusCode());

        assertEquals(description, captor.getValue());
    }
}