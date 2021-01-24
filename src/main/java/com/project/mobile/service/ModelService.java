package com.project.mobile.service;

import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

@Service
public interface ModelService {

    void seedData() throws FileNotFoundException;
}
