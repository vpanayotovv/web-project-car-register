package com.project.mobile.service;

import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

@Service
public interface BrandService{

    void seedData() throws FileNotFoundException;

}
