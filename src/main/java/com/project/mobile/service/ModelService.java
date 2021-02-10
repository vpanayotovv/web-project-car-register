package com.project.mobile.service;

import com.project.mobile.models.entity.Model;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;

@Service
public interface ModelService {

    void seedData() throws FileNotFoundException;

    List<Model> getModelsById(Long id);

    Model getModelById(Long id);

    Model getModelByName(String model);
}
