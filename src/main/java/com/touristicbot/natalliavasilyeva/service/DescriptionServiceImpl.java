package com.touristicbot.natalliavasilyeva.service;

import com.touristicbot.natalliavasilyeva.model.Description;
import com.touristicbot.natalliavasilyeva.repository.DescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescriptionServiceImpl implements DescriptionService {

    private DescriptionRepository descriptionRepository;

    @Autowired
    public void setDescriptionRepository (DescriptionRepository descriptionRepository){
        this.descriptionRepository=descriptionRepository;
    }

    @Override
    public Description addDescription (Description description) {
        Description savedDescription = descriptionRepository.saveAndFlush(description);

        return savedDescription;
    }

    @Override
    public void deleteById(long id) {
        descriptionRepository.deleteById(id);
    }


    @Override
    public Description editDescription(Description description) {
        return descriptionRepository.saveAndFlush(description);
    }

    @Override
    public List<Description> getAllDescriptions() {
        return descriptionRepository.findAll();
    }
}
