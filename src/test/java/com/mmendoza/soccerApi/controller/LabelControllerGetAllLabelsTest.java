package com.mmendoza.soccerapi.controller;

import com.mmendoza.soccerapi.domain.dto.label.LabelDto;
import com.mmendoza.soccerapi.domain.entities.Label;
import com.mmendoza.soccerapi.mappers.ILabelMapper;
import com.mmendoza.soccerapi.services.label.ServGetAllLabels;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LabelControllerGetAllLabelsTest {

    @InjectMocks
    private LabelController labelController;

    @Mock
    private ServGetAllLabels servGetAllLabels;

    @Mock
    private ILabelMapper labelMapper;

    private List<Label> labels;

    private List<LabelDto> labelsDto;

    @BeforeEach
    void setUp() {
        labels = new ArrayList<>(Arrays.asList(
                Label.builder().labelId(1).description("Futbol").build()
        ));
        labelsDto = new ArrayList<>(Arrays.asList(
                LabelDto.builder().labelId(1).description("Futbol").build()
        ));
    }

    @Test
    void verifyResponse() {
        Mockito.when(servGetAllLabels.run(Mockito.any())).thenReturn(labels);

        Mockito.when(labelMapper.toDtoList(Mockito.anyList())).thenReturn(labelsDto);

        ResponseEntity<List<LabelDto>> response = labelController.getAllLabels();

        Mockito.verify(servGetAllLabels).run(Mockito.any());

        assertEquals(LabelDto.class, response.getBody().get(0).getClass());
        assertEquals(1, response.getBody().size());
        assertEquals(1, response.getBody().get(0).getLabelId());
        assertEquals("Futbol", response.getBody().get(0).getDescription());
    }
}