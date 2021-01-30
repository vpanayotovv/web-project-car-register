package com.project.mobile.service.impl;

import com.google.gson.Gson;
import com.project.mobile.models.dto.ModelSeedDto;
import com.project.mobile.models.entity.Brand;
import com.project.mobile.models.entity.Constants;
import com.project.mobile.models.entity.Model;
import com.project.mobile.repository.BrandRepository;
import com.project.mobile.repository.ModelRepository;
import com.project.mobile.service.ModelService;
import com.project.mobile.util.CustomFileReader;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {

    private final CustomFileReader reader;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    public ModelServiceImpl(CustomFileReader reader, Gson gson, ModelMapper modelMapper, ModelRepository modelRepository, BrandRepository brandRepository) {
        this.reader = reader;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public void seedData() throws FileNotFoundException {
        String read = String.join("", reader.read(Constants.MODEL_PATH));

        ModelSeedDto[] modelSeedDto = this.gson.fromJson(read,ModelSeedDto[].class);

        for (ModelSeedDto seedDto : modelSeedDto) {
            Model model = this.modelMapper.map(seedDto, Model.class);
            Brand brand = this.brandRepository.getOne(seedDto.getBrand());
            model.setBrand(brand);
            this.modelRepository.saveAndFlush(model);
        }

    }

    @Override
    public List<Model> getModelsById(Long id) {
       return this.modelRepository.findAllByBrandId(id);
    }

    @Override
    public Model getModelById(Long id) {
       return this.modelRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Model not found!"));
    }
}
