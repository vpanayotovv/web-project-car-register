package com.project.mobile.service;

import com.project.mobile.models.entity.Offer;
import com.project.mobile.models.view.SimpleOfferViewModel;

import java.util.List;

public interface OfferService {
    List<SimpleOfferViewModel> getAllOffers();

    Offer getOfferById(Long offerId);
}
