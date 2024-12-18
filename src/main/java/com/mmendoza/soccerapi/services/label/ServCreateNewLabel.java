package com.mmendoza.soccerapi.services.label;

import com.mmendoza.soccerapi.domain.exception.PropertyException;
import com.mmendoza.soccerapi.utils.GenericServices;
import org.springframework.stereotype.Component;

@Component
public class ServCreateNewLabel extends GenericServices<String, Void> {

    @Override
    protected Void execute(String request) {

        if (request.isEmpty())
            throw new PropertyException("The description is empty");



        return null;
    }
}
