package com.mmendoza.soccerapi.services.label;

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



        return null;
    }
}
