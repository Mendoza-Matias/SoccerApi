package com.mmendoza.soccerapi.services.label;

import com.mmendoza.soccerapi.domain.entities.Label;
import com.mmendoza.soccerapi.domain.exception.NotFoundException;
import com.mmendoza.soccerapi.repository.ILabelRepository;
import com.mmendoza.soccerapi.utils.GenericServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServGetAllLabels extends GenericServices<Void, List<Label>> {

    @Autowired
    private ILabelRepository labelRepository;

    @Override
    protected List<Label> execute(Void request) {

        List<Label> labels = labelRepository.findAll();

        if (labels.isEmpty())
            throw new NotFoundException("No labels found");

        return labels;
    }
}
