package com.mmendoza.soccerapi.services.label;

import com.mmendoza.soccerapi.domain.exception.PropertyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ServCreateNewLabelTest {

    @InjectMocks
    private ServCreateNewLabel servCreateNewLabel;

    @BeforeEach
    void setUp() {
    }

    @Test
    void verifyDescriptionEmpty() {
        PropertyException exception = assertThrows(PropertyException.class, () -> {
            servCreateNewLabel.run("");
        });
        assertEquals("The description is empty", exception.getMessage());
    }

    @Test
    void verifyDescriptionNull() {
        PropertyException exception = assertThrows(PropertyException.class, () -> {
            servCreateNewLabel.run(null);
        });
        assertEquals("The description is empty", exception.getMessage());
    }

    @Test
    void verifyExecute() {

    }
}