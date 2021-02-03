package com.project.mobile.service.impl;

import com.project.mobile.models.entity.Offer;
import com.project.mobile.models.view.OfferViewModel;
import com.project.mobile.repository.OfferRepository;
import com.project.mobile.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
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
}
