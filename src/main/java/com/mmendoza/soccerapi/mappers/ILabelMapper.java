package com.mmendoza.soccerapi.mappers;

import com.mmendoza.soccerapi.domain.dto.label.LabelDto;
import com.mmendoza.soccerapi.domain.entities.Label;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ILabelMapper {

    ILabelMapper INSTANCE = Mappers.getMapper(ILabelMapper.class);

    @Mappings({
            @Mapping(source = "labelId", target = "labelId"),
            @Mapping(source = "description", target = "description")
    })
    LabelDto toDto(Label label);

    @InheritInverseConfiguration(name = "toDto")
    Label toEntity(LabelDto labelDto);
}
