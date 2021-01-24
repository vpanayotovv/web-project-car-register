package com.project.mobile.Init;

import com.project.mobile.models.entity.User;
import com.project.mobile.models.entity.enums.Role;
import com.project.mobile.service.BrandService;
import com.project.mobile.service.ModelService;
import com.project.mobile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Set;


@Component
public class DataBaseInit implements CommandLineRunner {

    private final BrandService brandService;
    private final ModelService modelService;
    private final UserService userService;



    @Autowired
    public DataBaseInit(BrandService brandService, ModelService modelService, UserService userService) {
        this.brandService = brandService;
        this.modelService = modelService;
        this.userService = userService;
    }

    private static final List<User> SAMPLE_USERS = List.of(
            new User("pesho", "Petur", "Petrov", true , "" , Set.of(Role.ADMIN,Role.USER)),
            new User("ivan", "Ivan", "Simeonov", true, "" , Set.of(Role.USER))
    );

    @Override
    public void run(String... args) throws FileNotFoundException {

        SAMPLE_USERS.forEach(userService::createUser);
//        this.brandService.seedData();
//        this.modelService.seedData();

    }
}
