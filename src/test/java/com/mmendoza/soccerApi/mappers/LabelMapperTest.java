package com.mmendoza.soccerapi.mappers;

import com.mmendoza.soccerapi.domain.dto.label.LabelDto;
import com.mmendoza.soccerapi.domain.entities.Label;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest /* Loads the application context and allows testing the mapper by injecting it. */
public class LabelMapperTest {

    @Autowired
    private ILabelMapper labelMapper;

    @Test
    void toDto() {
        LabelDto dto = labelMapper.
                toDto(Label.builder()
                        .labelId(1)
                        .description("description")
                        .build());

        assertEquals(LabelDto.class, dto.getClass());
        assertEquals(1, dto.getLabelId());
        assertEquals("description", dto.getDescription());
    }

  
}