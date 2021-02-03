package com.project.mobile.web;

import com.project.mobile.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/offers")
public class OffersController {

    private final OfferService offerService;

    public OffersController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/all")
    public String getAllOffers(Model model){
        model.addAttribute("offers",this.offerService.getAllOffers());
        return "offers";
    }

    @GetMapping("/details/{offerId}")
    public String getOfferDetails(@PathVariable("offerId") Long offerId, Model model) {
        model.addAttribute("offer", offerService.getOfferById(offerId));
        return "offer-details";
    }

    @GetMapping("/add")
    public String addOffer(){
        return "offer-add";
    }

}
