package com.mmendoza.soccerapi.services.label;

import com.mmendoza.soccerapi.domain.entities.Label;
import com.mmendoza.soccerapi.domain.exception.PropertyException;
import com.mmendoza.soccerapi.repository.ILabelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ServCreateNewLabelTest {

    @InjectMocks
    private ServCreateNewLabel servCreateNewLabel;

    @Mock
    private ILabelRepository labelRepository;


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

        ArgumentCaptor<Label> captor = ArgumentCaptor.forClass(Label.class);

        Mockito.when(labelRepository.save(captor.capture())).thenReturn(Mockito.any(Label.class));

        servCreateNewLabel.run("Boca");

        Mockito.verify(labelRepository).save(Mockito.any(Label.class));

        assertEquals("Boca", captor.getValue().getDescription());
    }
}