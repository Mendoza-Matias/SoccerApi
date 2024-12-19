package com.mmendoza.soccerapi.services.label;

import com.mmendoza.soccerapi.domain.entities.Label;
import com.mmendoza.soccerapi.domain.exception.NotFoundException;
import com.mmendoza.soccerapi.repository.ILabelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ServGetAllLabelsTest {

    @InjectMocks
    private ServGetAllLabels servGetAllLabels;

    @Mock
    private ILabelRepository labelRepository;

    private List<Label> labels;

    @BeforeEach
    void setUp() {
        labels = new ArrayList<>(
                Arrays.asList(
                        Label.builder().labelId(1).description("River").build(),
                        Label.builder().labelId(2).description("Boca").build()
                )
        );
    }

    @Test
    void verifyListEmpty() {
        Mockito.when(labelRepository.findAll()).thenReturn(Collections.emptyList());

        NotFoundException exception = assertThrows(NotFoundException.class, () -> {
            servGetAllLabels.run(null);
        });

        assertEquals("No labels found", exception.getMessage());
    }

    @Test
    void verifyExecute() {

        Mockito.when(labelRepository.findAll()).thenReturn(labels);

        List<Label> execute = servGetAllLabels.run(null);

        Mockito.verify(labelRepository).findAll();

        assertEquals(Label.class, execute.get(0).getClass());
        assertEquals(2, execute.size());
        assertEquals(1, execute.get(0).getLabelId());
        assertEquals("River", execute.get(0).getDescription());
        assertEquals(2, execute.get(1).getLabelId());
        assertEquals("Boca", execute.get(1).getDescription());
    }
}