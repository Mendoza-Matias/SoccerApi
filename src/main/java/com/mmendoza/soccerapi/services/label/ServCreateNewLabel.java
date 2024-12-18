package com.mmendoza.soccerapi.services.label;

import com.mmendoza.soccerapi.domain.entities.Label;
import com.mmendoza.soccerapi.domain.exception.ExistException;
import com.mmendoza.soccerapi.domain.exception.PropertyException;
import com.mmendoza.soccerapi.repository.ILabelRepository;
import com.mmendoza.soccerapi.utils.GenericServices;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServCreateNewLabel extends GenericServices<String, Void> {

    @Autowired
    private ILabelRepository labelRepository;

    @Override
    protected Void execute(String request) {

        if (Strings.isEmpty(request))
            throw new PropertyException("The description is empty");

        if (labelRepository.existsByDescription(request))
            throw new ExistException("The label already exists");

        labelRepository.save(Label.builder().description(request).build());

        return null;
    }
}
