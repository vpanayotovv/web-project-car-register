package com.project.mobile.service;

import com.google.gson.Gson;
import com.project.mobile.models.dto.BrandSeedDto;
import com.project.mobile.models.entity.Brand;
import com.project.mobile.models.entity.Constants;
import com.project.mobile.repository.BrandRepository;
import com.project.mobile.util.CustomFileReader;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

@Service
public class BrandServiceImpl implements BrandService {

    private final CustomFileReader reader;
    private final Gson gson;
    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public BrandServiceImpl(CustomFileReader reader, Gson gson, BrandRepository brandRepository, ModelMapper modelMapper) {
        this.reader = reader;
        this.gson = gson;
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
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
}
