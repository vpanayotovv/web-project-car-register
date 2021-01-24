package com.project.mobile.Init;

import com.project.mobile.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;


@Component
public class DataBaseInit implements CommandLineRunner {

    private final BrandService brandService;

    @Autowired
    public DataBaseInit(BrandService brandService) {
        this.brandService = brandService;
    }
    @Override
    public void run(String... args) throws FileNotFoundException {

        this.brandService.seedData();

    }
}
