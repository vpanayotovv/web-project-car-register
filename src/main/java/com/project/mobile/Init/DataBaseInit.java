package com.project.mobile.Init;

import com.project.mobile.models.entity.Offer;
import com.project.mobile.models.entity.User;
import com.project.mobile.models.entity.enums.Engine;
import com.project.mobile.models.entity.enums.Role;
import com.project.mobile.models.entity.enums.Transmission;
import com.project.mobile.repository.OfferRepository;
import com.project.mobile.service.BrandService;
import com.project.mobile.service.ModelService;
import com.project.mobile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Component
public class DataBaseInit implements CommandLineRunner {

    private final BrandService brandService;
    private final ModelService modelService;
    private final UserService userService;
    private final OfferRepository offerRepository;



    @Autowired
    public DataBaseInit(BrandService brandService, ModelService modelService, UserService userService, OfferRepository offerRepository) {
        this.brandService = brandService;
        this.modelService = modelService;
        this.userService = userService;
        this.offerRepository = offerRepository;
    }

    private static final List<User> SAMPLE_USERS = List.of(
            new User("pesho", "taina","Petur", "Petrov", true , "" , List.of(Role.ADMIN,Role.USER)),
            new User("ivan", "taina", "Ivan", "Simeonov", true, "" , List.of(Role.USER))
    );

    @Override
    public void run(String... args) throws FileNotFoundException {
//            SAMPLE_USERS.forEach(userService::createUser);
//            this.brandService.seedData();
//            this.modelService.seedData();
//
//            Offer offer = new Offer("Mn dobra kola",Engine.DIESEL,"https://images.carandbike.com/bike-images/large/bmw/s-1000-rr/bmw-s-1000-rr.jpg?v=7",160000,new BigDecimal(8000), Transmission.AUTOMATIC,2006);
//            Offer offer2 = new Offer("Vsichko oblsujeno",Engine.ELECTRIC,"https://www.hushhush.com/wp-content/uploads/2019/01/2016-bmw-m3.jpg",160000,new BigDecimal(10000), Transmission.MANUAL,2008);
//
//            offer.setCreated(LocalDateTime.now());
//            offer.setModified(LocalDateTime.now());
//            offer.setModel(this.modelService.getModelById((long) 1));
//            offer.setSeller(this.userService.getUserById((long) 2));
//
//
//
//            offer2.setCreated(LocalDateTime.now());
//            offer2.setModified(LocalDateTime.now());
//            offer2.setModel(this.modelService.getModelById((long) 3));
//            offer2.setSeller(this.userService.getUserById((long) 1));
//
//            this.offerRepository.saveAndFlush(offer);
//            this.offerRepository.saveAndFlush(offer2);

    }
}
