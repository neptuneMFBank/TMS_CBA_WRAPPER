package com.neptune.cbawrapper.Controllers;


import com.neptune.cbawrapper.Configuration.Helpers;
import com.neptune.cbawrapper.Models.BusinessPlatformCharges;
import com.neptune.cbawrapper.Models.PlatformCharges;
import com.neptune.cbawrapper.Repository.BusinessPlatformChargesRepository;
import com.neptune.cbawrapper.Repository.PlatformChargeRepository;
import com.neptune.cbawrapper.RequestRessponseSchema.BusinessPlatformChargesRequest;
import com.neptune.cbawrapper.RequestRessponseSchema.PlatformChargesRequest;
import com.neptune.cbawrapper.RequestRessponseSchema.ResponseSchema;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/charges")
public class ChargesController {

    private final PlatformChargeRepository platformChargeRepository;
    private final Helpers helpers;
    private final BusinessPlatformChargesRepository businessPlatformChargesRepository;

    public ChargesController(PlatformChargeRepository platformChargeRepository, Helpers helpers, BusinessPlatformChargesRepository businessPlatformChargesRepository) {
        this.platformChargeRepository = platformChargeRepository;
        this.helpers = helpers;
        this.businessPlatformChargesRepository = businessPlatformChargesRepository;
    }

    @GetMapping("/get-all-platform-charges")
    public ResponseSchema getAllPlatformCharges(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        Page<PlatformCharges> allPlatformCharges = helpers.getPaginatedPlatformCharges(page, size);
        return new ResponseSchema<>( 200, "successful", allPlatformCharges, "", ZonedDateTime.now(), false);
    }

    @GetMapping("/get-all-business-platform-charges")
    public ResponseSchema getAllBusinessPlatformCharges(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        Page<BusinessPlatformCharges> allPlatformCharges = helpers.getPaginatedBusinessPlatformCharges(page, size);
        return new ResponseSchema<>( 200, "successful", allPlatformCharges, "", ZonedDateTime.now(), false);
    }

    @PostMapping("/create-platform-charge")
    public ResponseSchema createPlatformCharge(@RequestBody PlatformChargesRequest charges){
        Optional<PlatformCharges> checkIfChargeTypeExists = platformChargeRepository.getChargeByName(charges.getPlatformName());

        if(checkIfChargeTypeExists.isPresent()){
            return new ResponseSchema<>( 501, "charge for the platform name provided already exists ", null, "", ZonedDateTime.now(), false);
        }

        PlatformCharges platformCharges = new PlatformCharges();
        platformCharges.setPlatformName(charges.getPlatformName());
        platformCharges.setAmount(charges.getAmount());
        platformCharges.setChargeType(charges.getChargeType());
        platformCharges.setThreshold(charges.getThreshold());
        platformCharges.setBusinessValue(charges.getBusinessValue());
        platformCharges.setTotal(charges.getTotal());
        platformChargeRepository.save(platformCharges);

        return new ResponseSchema<>( 200, "charge for this platform type added successfully", null, "", ZonedDateTime.now(), false);
    }

    @PostMapping("/create-business-platform-charge")
    public ResponseSchema createBusinessPlatformCharge(@RequestBody BusinessPlatformChargesRequest charges){
        Optional<BusinessPlatformCharges> checkIfChargeTypeExists = businessPlatformChargesRepository.getChargeByBusinessWalletId(charges.getBusinessWalletId());

        if(checkIfChargeTypeExists.isPresent()){
            return new ResponseSchema<>( 501, "charge for the platform name provided already exists ", null, "", ZonedDateTime.now(), false);
        }

        BusinessPlatformCharges businessPlatformCharges = new BusinessPlatformCharges();
        businessPlatformCharges.setBusinessId(charges.getBusinessId());
        businessPlatformCharges.setBusinessWalletId(charges.getBusinessWalletId());
        businessPlatformCharges.setChargeType(charges.getChargeType());
        businessPlatformCharges.setAmount(charges.getAmount());
        businessPlatformCharges.setThreshold(charges.getThreshold());
        businessPlatformChargesRepository.save(businessPlatformCharges);

        return new ResponseSchema<>( 200, "charge for this platform type added successfully", null, "", ZonedDateTime.now(), false);
    }

    @PutMapping("/update-platform-charge")
    public ResponseSchema updatePlatformCharge(@RequestBody PlatformChargesRequest charges){
        Optional<PlatformCharges> checkIfChargeTypeExists = platformChargeRepository.getChargeById(charges.getId());

        if(checkIfChargeTypeExists.isEmpty()){
            return new ResponseSchema<>( 404, "charge for the platform name provided not found ", null, "", ZonedDateTime.now(), false);
        }

        PlatformCharges platformCharges = checkIfChargeTypeExists.get();
        platformCharges.setPlatformName(charges.getPlatformName());
        platformCharges.setAmount(charges.getAmount());
        platformCharges.setChargeType(charges.getChargeType());
        platformCharges.setThreshold(charges.getThreshold());
        platformCharges.setBusinessValue(charges.getBusinessValue());
        platformCharges.setTotal(charges.getTotal());
        platformChargeRepository.save(platformCharges);

        return new ResponseSchema<>( 200, "charge for this platform type updated successfully", null, "", ZonedDateTime.now(), false);
    }

    @PutMapping("/update-business-platform-charge")
    public ResponseSchema updateBusinessPlatformCharge(@RequestBody BusinessPlatformChargesRequest charges){
        Optional<BusinessPlatformCharges> checkIfChargeTypeExists = businessPlatformChargesRepository.getChargeByBusinessWalletId(charges.getBusinessWalletId());

        if(checkIfChargeTypeExists.isEmpty()){
            return new ResponseSchema<>( 404, "charge for the business wallet provided not found ", null, "", ZonedDateTime.now(), false);
        }

        BusinessPlatformCharges businessPlatformCharges = checkIfChargeTypeExists.get();
        businessPlatformCharges.setBusinessId(charges.getBusinessId());
        businessPlatformCharges.setBusinessWalletId(charges.getBusinessWalletId());
        businessPlatformCharges.setChargeType(charges.getChargeType());
        businessPlatformCharges.setAmount(charges.getAmount());
        businessPlatformCharges.setThreshold(charges.getThreshold());
        businessPlatformChargesRepository.save(businessPlatformCharges);

        return new ResponseSchema<>( 200, "charge for this business updated successfully", null, "", ZonedDateTime.now(), false);
    }


    @DeleteMapping("/delete-platform-charge")
    public ResponseSchema deletePlatformCharge(@RequestBody PlatformChargesRequest charges){
        Optional<PlatformCharges> checkIfChargeTypeExists = platformChargeRepository.getChargeById(charges.getId());

        if(checkIfChargeTypeExists.isEmpty()){
            return new ResponseSchema<>( 404, "charge for the platform name provided not found ", null, "", ZonedDateTime.now(), false);
        }

        platformChargeRepository.delete(checkIfChargeTypeExists.get());

        return new ResponseSchema<>( 200, "charge for this platform type deleted successfully", null, "", ZonedDateTime.now(), false);
    }


    @DeleteMapping("/delete-business-platform-charge")
    public ResponseSchema deleteBusinessPlatformCharge(@RequestBody BusinessPlatformChargesRequest charges){
        Optional<BusinessPlatformCharges> checkIfChargeTypeExists = businessPlatformChargesRepository.getChargeByBusinessWalletId(charges.getBusinessWalletId());

        if(checkIfChargeTypeExists.isEmpty()){
            return new ResponseSchema<>( 404, "charge for the platform name provided not found ", null, "", ZonedDateTime.now(), false);
        }

        businessPlatformChargesRepository.delete(checkIfChargeTypeExists.get());

        return new ResponseSchema<>( 200, "charge for this platform type deleted successfully", null, "", ZonedDateTime.now(), false);
    }


}
