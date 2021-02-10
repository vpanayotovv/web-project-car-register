package com.project.mobile.service;

import com.project.mobile.models.dto.OfferAddBindingModel;
import com.project.mobile.models.entity.Offer;
import com.project.mobile.models.view.OfferViewModel;

import java.util.List;

public interface OfferService {
    List<OfferViewModel> getAllOffers();

    Offer getOfferById(Long offerId);

    void addOffer(OfferAddBindingModel offerAddBindingModel);
}
