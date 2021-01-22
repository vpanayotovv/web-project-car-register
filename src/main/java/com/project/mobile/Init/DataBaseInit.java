package com.project.mobile.Init;

import com.project.mobile.models.entity.Brand;
import com.project.mobile.models.entity.Model;
import com.project.mobile.models.entity.enums.Category;
import com.project.mobile.repository.BrandRepository;
import com.project.mobile.repository.ModelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.Instant;

@Component
public class DataBaseInit implements CommandLineRunner {

    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;

    public DataBaseInit(BrandRepository brandRepository, ModelRepository modelRepository) {
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        Brand brand = addBrand();

        addModel(brand);
    }

    private Brand addBrand() {
        Brand brand = new Brand();
        brand.setCreated(Instant.now());
        brand.setModified(Instant.now());
        brand.setName("Lambo");
        brandRepository.saveAndFlush(brand);
        return brand;
    }

    private void addModel(Brand brand) {
        Model model = new Model();
        model.setName("Aventador");
        model.setBrand(brand);
        model.setCreated(Instant.now());
        model.setModified(Instant.now());
        model.setCategory(Category.CAR);
        model.setImageUrl("https://www.nastarta.com/wp-content/uploads/2018/08/f9af2a48-lamborghini-aventador-svj-roadster-1.jpg");
        model.setEndYear(2021);
        model.setStartYear(2011);

        modelRepository.saveAndFlush(model);
    }
}
