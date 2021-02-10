package com.project.mobile.service.impl;

import com.project.mobile.models.dto.OfferAddBindingModel;
import com.project.mobile.models.entity.Offer;
import com.project.mobile.models.view.OfferViewModel;
import com.project.mobile.repository.OfferRepository;
import com.project.mobile.security.CurrentUser;
import com.project.mobile.service.ModelService;
import com.project.mobile.service.OfferService;
import com.project.mobile.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final ModelService modelService;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, CurrentUser currentUser, UserService userService, ModelService modelService) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.modelService = modelService;
    }

    @Override
    public List<OfferViewModel> getAllOffers() {


        return this.offerRepository.findAll().stream().map(offer -> {
           offer.getModel().setBrand(offer.getModel().getBrand());
           return this.modelMapper.map(offer, OfferViewModel.class);
        }).collect(Collectors.toList());

    }

    @Override
    public Offer getOfferById(Long offerId) {
       return this.offerRepository.findById(offerId).orElseThrow( () -> new IllegalArgumentException("Offer not exist!"));
    }

    @Override
    public void addOffer(OfferAddBindingModel offerAddBindingModel) {
        Offer offer = this.modelMapper.map(offerAddBindingModel,Offer.class);
        offer.setSeller(userService.getUserByName(currentUser.getName()));
        offer.setModel(modelService.getModelByName(offerAddBindingModel.getModel()));
        offer.setCreated(LocalDateTime.now());
        offer.setModified(LocalDateTime.now());

        this.offerRepository.saveAndFlush(offer);
    }

    @Override
    public void deleteOffer(long id) {
        offerRepository.deleteById(id);
    }
}
