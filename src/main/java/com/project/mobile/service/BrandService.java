package com.project.mobile.service;

import com.project.mobile.models.view.BrandViewModel;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;

@Service
public interface BrandService{

    void seedData() throws FileNotFoundException;

    List<BrandViewModel> getAllBrands();
}
