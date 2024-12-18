package com.mmendoza.soccerapi.mappers;

import com.mmendoza.soccerapi.domain.dto.label.LabelDto;
import com.mmendoza.soccerapi.domain.entities.Label;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
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

    @Test
    void toEntity() {
        Label entity = labelMapper
                .toEntity(LabelDto.builder()
                        .labelId(1)
                        .description("description")
                        .build());

        assertEquals(Label.class, entity.getClass());
        assertEquals(1, entity.getLabelId());
        assertEquals("description", entity.getDescription());
    }
}