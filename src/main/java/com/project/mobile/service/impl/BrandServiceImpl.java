package com.project.mobile.service.impl;

import com.google.gson.Gson;
import com.project.mobile.models.dto.BrandSeedDto;
import com.project.mobile.models.entity.Brand;
import com.project.mobile.models.entity.Constants;
import com.project.mobile.models.entity.Model;
import com.project.mobile.models.view.BrandViewModel;
import com.project.mobile.models.view.ModelViewModel;
import com.project.mobile.repository.BrandRepository;
import com.project.mobile.repository.ModelRepository;
import com.project.mobile.service.BrandService;
import com.project.mobile.service.ModelService;
import com.project.mobile.util.CustomFileReader;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    private final CustomFileReader reader;
    private final Gson gson;
    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;
    private final ModelService modelService;
    private final ModelRepository modelRepository;

    @Autowired
    public BrandServiceImpl(CustomFileReader reader, Gson gson, BrandRepository brandRepository, ModelMapper modelMapper, ModelService modelService, ModelRepository modelRepository) {
        this.reader = reader;
        this.gson = gson;
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
        this.modelService = modelService;
        this.modelRepository = modelRepository;
    }

    @Override
    public void seedData() throws FileNotFoundException {
        String read = String.join("", reader.read(Constants.BRAND_PATH));
        BrandSeedDto[] brandSeedDtos = this.gson.fromJson(read,BrandSeedDto[].class);

        for (BrandSeedDto brandSeedDto : brandSeedDtos) {
            Brand brand = this.modelMapper.map(brandSeedDto,Brand.class);
            this.brandRepository.saveAndFlush(brand);
        }
    }

    @Override
    public List<BrandViewModel> getAllBrands() {
        List<Brand> brands = this.brandRepository.findAll();

        List<BrandViewModel> result = new ArrayList<>();

        for (Brand brand : brands) {
            BrandViewModel mappedBrand = this.modelMapper.map(brand, BrandViewModel.class);
            List<Model> models = this.modelService.getModelsById(brand.getId());
            List<ModelViewModel> modelsViewModels = models.stream().map(m -> this.modelMapper.map(m, ModelViewModel.class)).collect(Collectors.toList());

            mappedBrand.setModels(modelsViewModels);

            result.add(mappedBrand);
        }

        return result;

    }
}
