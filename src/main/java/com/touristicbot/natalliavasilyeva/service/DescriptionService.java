package com.touristicbot.natalliavasilyeva.service;

import com.touristicbot.natalliavasilyeva.model.Description;

import java.util.List;

public interface DescriptionService {

    Description addDescription(Description description);
    void deleteById(long id);
    Description editDescription(Description description);
    List<Description> getAllDescriptions();

}
