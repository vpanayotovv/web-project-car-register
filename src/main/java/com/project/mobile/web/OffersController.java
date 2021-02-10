package com.project.mobile.web;

import com.project.mobile.models.dto.OfferAddBindingModel;
import com.project.mobile.models.entity.enums.Engine;
import com.project.mobile.models.entity.enums.Transmission;
import com.project.mobile.service.BrandService;
import com.project.mobile.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/offers")
public class OffersController {

    private final BrandService brandService;


    private final OfferService offerService;

    public OffersController(BrandService brandService, OfferService offerService) {
        this.brandService = brandService;
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
    public String add(Model model){
        if (!model.containsAttribute("offerAddBindingModel")){
            model.addAttribute("offerAddBindingModel",new OfferAddBindingModel());
        }
        model.addAttribute("brands",brandService.getAllBrands());
        model.addAttribute("engines", Engine.values());
        model.addAttribute("transmissions", Transmission.values());
        return "offer-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid @ModelAttribute("offerAddBindingModel") OfferAddBindingModel offerAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("offerAddBindingModel",offerAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerAddBindingModel",bindingResult);

            return "redirect:add";
        }


        //TODO:add to db
        System.out.println();

        return "redirect:all";
    }
}
