package com.neptune.cbawrapper.Controllers;


import com.neptune.cbawrapper.Configuration.AESServiceImp;
import com.neptune.cbawrapper.Configuration.Helpers;
import com.neptune.cbawrapper.Exception.ErrorLoggingException;
import com.neptune.cbawrapper.Models.BusinessPlatformCharges;
import com.neptune.cbawrapper.Models.PlatformCharges;
import com.neptune.cbawrapper.Repository.BusinessPlatformChargesRepository;
import com.neptune.cbawrapper.Repository.PlatformChargeRepository;
import com.neptune.cbawrapper.RequestRessponseSchema.*;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/charges")
public class ChargesController {

    private final PlatformChargeRepository platformChargeRepository;
    private final Helpers helpers;
    private final ErrorLoggingException errorLoggingException;
    private final BusinessPlatformChargesRepository businessPlatformChargesRepository;
    private final AESServiceImp aesServiceImp;

    public ChargesController(ErrorLoggingException errorLoggingException, PlatformChargeRepository platformChargeRepository, Helpers helpers, BusinessPlatformChargesRepository businessPlatformChargesRepository, AESServiceImp aesServiceImp) {
        this.platformChargeRepository = platformChargeRepository;
        this.helpers = helpers;
        this.errorLoggingException = errorLoggingException;
        this.businessPlatformChargesRepository = businessPlatformChargesRepository;
        this.aesServiceImp = aesServiceImp;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/get-all-platform-charges")
    public ResponseEntity<ResponseSchema<?>> getAllPlatformCharges(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        Page<PlatformCharges> allPlatformCharges = helpers.getPaginatedPlatformCharges(page, size);
        ResponseSchema<?> responseSchema = new ResponseSchema<>( 200, "successful", aesServiceImp.aesEncrypt(helpers.convertToJson(allPlatformCharges)), "", ZonedDateTime.now(), true);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/get-all-business-platform-charges")
    public ResponseEntity<ResponseSchema<?>> getAllBusinessPlatformCharges(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        Page<BusinessPlatformCharges> allPlatformCharges = helpers.getPaginatedBusinessPlatformCharges(page, size);
        ResponseSchema<?> responseSchema = new ResponseSchema<>( 200, "successful", aesServiceImp.aesEncrypt(helpers.convertToJson(allPlatformCharges)), "", ZonedDateTime.now(), true);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/create-platform-charge")
    public ResponseEntity<ResponseSchema<?>> createPlatformCharge(@RequestBody EncryptedRequest request){ // PlatformChargesRequest charges
        String decrypted = aesServiceImp.aesDecrypt(request.getRequest());
        PlatformChargesRequest charges = helpers.convertToObject(decrypted, PlatformChargesRequest.class);

        System.out.println("charges = " + charges);
        Optional<PlatformCharges> checkIfChargeTypeExists = platformChargeRepository.getChargeByName(charges.getPlatformName());

        String data = aesServiceImp.aesEncrypt(helpers.convertToJson(charges));

        if(checkIfChargeTypeExists.isPresent()){
            errorLoggingException.logError("CREATE_PLATFORM_CHARGE", "charge for the platform name provided already exists","charge for the platform name provided already exists");
            ResponseSchema<?> responseSchema = new ResponseSchema<>( 409, "charge for the platform name provided already exists", null, "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.CONFLICT);
        }

        PlatformCharges platformCharges = new PlatformCharges();
        platformCharges.setPlatformName(charges.getPlatformName());
        platformCharges.setAmount(charges.getAmount());
        platformCharges.setChargeType(charges.getChargeType());
        platformCharges.setThreshold(charges.getThreshold());
        platformCharges.setBusinessValue(charges.getBusinessValue());
        platformCharges.setTotal(charges.getTotal());
        platformChargeRepository.save(platformCharges);

        ResponseSchema<?> responseSchema = new ResponseSchema<>( 200, "charge for this platform type added successfully", null, "", ZonedDateTime.now(), false);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/create-business-platform-charge")
    public ResponseEntity<ResponseSchema<?>> createBusinessPlatformCharge(@RequestBody EncryptedRequest request){ // BusinessPlatformChargesRequest charges

        String decrypted = aesServiceImp.aesDecrypt(request.getRequest());
        BusinessPlatformChargesRequest charges = helpers.convertToObject(decrypted, BusinessPlatformChargesRequest.class);

        Optional<BusinessPlatformCharges> checkIfChargeTypeExists = businessPlatformChargesRepository.getChargeByBusinessWalletId(charges.getBusinessWalletId());

        if(checkIfChargeTypeExists.isPresent()){
            errorLoggingException.logError("CREATE_BUSINESS_PLATFORM_CHARGE", "charge for the platform name provided already exists","charge for the platform name provided already exists");
            ResponseSchema<?> responseSchema = new ResponseSchema<>( 409, "charge for the platform name provided already exists ", null, "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.CONFLICT);
        }

        BusinessPlatformCharges businessPlatformCharges = new BusinessPlatformCharges();
        businessPlatformCharges.setBusinessId(charges.getBusinessId());
        businessPlatformCharges.setBusinessWalletId(charges.getBusinessWalletId());
        businessPlatformCharges.setChargeType(charges.getChargeType());
        businessPlatformCharges.setAmount(charges.getAmount());
        businessPlatformCharges.setThreshold(charges.getThreshold());
        businessPlatformCharges.setBusinessName(charges.getBusinessName());
        businessPlatformChargesRepository.save(businessPlatformCharges);

        ResponseSchema<?> responseSchema = new ResponseSchema<>( 200, "charge for this platform type added successfully", null, "", ZonedDateTime.now(), false);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/update-platform-charge")
    public ResponseEntity<ResponseSchema<?>> updatePlatformCharge(@RequestBody EncryptedRequest request){ // PlatformChargesRequest charges
        String decrypted = aesServiceImp.aesDecrypt(request.getRequest());
        PlatformChargesRequest charges = helpers.convertToObject(decrypted, PlatformChargesRequest.class);;

        Optional<PlatformCharges> checkIfChargeTypeExists = platformChargeRepository.getChargeById(charges.getId());

        if(checkIfChargeTypeExists.isEmpty()){
            errorLoggingException.logError("CREATE_PLATFORM_CHARGE", "charge for the platform name provided not found","charge for the platform name provided not found");
            ResponseSchema<?> responseSchema = new ResponseSchema<>( 404, "charge for the platform name provided not found", null, "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.NOT_FOUND);
        }

        PlatformCharges platformCharges = checkIfChargeTypeExists.get();
        platformCharges.setPlatformName(charges.getPlatformName());
        platformCharges.setAmount(charges.getAmount());
        platformCharges.setChargeType(charges.getChargeType());
        platformCharges.setThreshold(charges.getThreshold());
        platformCharges.setBusinessValue(charges.getBusinessValue());
        platformCharges.setTotal(charges.getTotal());
        platformChargeRepository.save(platformCharges);

        ResponseSchema<?> responseSchema = new ResponseSchema<>( 200, "charge for this platform type updated successfully", null, "", ZonedDateTime.now(), false);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/update-business-platform-charge")
    public ResponseEntity<ResponseSchema<?>> updateBusinessPlatformCharge(@RequestBody EncryptedRequest request){ // BusinessPlatformChargesRequest charges
        String decrypted = aesServiceImp.aesDecrypt(request.getRequest());
        BusinessPlatformChargesRequest charges = helpers.convertToObject(decrypted, BusinessPlatformChargesRequest.class);

        Optional<BusinessPlatformCharges> checkIfChargeTypeExists = businessPlatformChargesRepository.getChargeByBusinessWalletId(charges.getBusinessWalletId());

        if(checkIfChargeTypeExists.isEmpty()){
            errorLoggingException.logError("CREATE_BUSINESS_PLATFORM_CHARGE", "charge for the business platform name provided not found","charge for the business platform name provided not found");
            ResponseSchema<?> responseSchema = new ResponseSchema<>( 404, "charge for the business wallet provided not found ", null, "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.NOT_FOUND);
        }

        BusinessPlatformCharges businessPlatformCharges = checkIfChargeTypeExists.get();
        businessPlatformCharges.setBusinessId(charges.getBusinessId());
        businessPlatformCharges.setBusinessWalletId(charges.getBusinessWalletId());
        businessPlatformCharges.setChargeType(charges.getChargeType());
        businessPlatformCharges.setBusinessName(charges.getBusinessName());
        businessPlatformCharges.setAmount(charges.getAmount());
        businessPlatformCharges.setThreshold(charges.getThreshold());
        businessPlatformChargesRepository.save(businessPlatformCharges);

        ResponseSchema<?> responseSchema = new ResponseSchema<>( 200, "charge for this business updated successfully", null, "", ZonedDateTime.now(), false);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }


    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete-platform-charge")
    public ResponseEntity<ResponseSchema<?>> deletePlatformCharge(@RequestBody EncryptedRequest request){ //PlatformChargesRequest charges

        String decrypted = aesServiceImp.aesDecrypt(request.getRequest());
        PlatformChargesRequest charges = helpers.convertToObject(decrypted, PlatformChargesRequest.class);
        Optional<PlatformCharges> checkIfChargeTypeExists = platformChargeRepository.getChargeById(charges.getId());

        if(checkIfChargeTypeExists.isEmpty()){
            errorLoggingException.logError("DELETE_PLATFORM_CHARGE", "charge for the platform name provided not found","charge for the platform name provided not found");
            ResponseSchema<?> responseSchema = new ResponseSchema<>( 404, "charge for the platform name provided not found ", null, "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.NOT_FOUND);
        }

        platformChargeRepository.delete(checkIfChargeTypeExists.get());

        ResponseSchema<?> responseSchema = new ResponseSchema<>( 200, "charge for this platform type deleted successfully", null, "", ZonedDateTime.now(), false);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }


    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete-business-platform-charge")
    public ResponseEntity<ResponseSchema<?>> deleteBusinessPlatformCharge(@RequestBody EncryptedRequest request){ //BusinessPlatformChargesRequest charges

        String decrypted = aesServiceImp.aesDecrypt(request.getRequest());
        BusinessPlatformChargesRequest charges = helpers.convertToObject(decrypted, BusinessPlatformChargesRequest.class);
        Optional<BusinessPlatformCharges> checkIfChargeTypeExists = businessPlatformChargesRepository.getChargeByBusinessWalletId(charges.getBusinessWalletId());

        if(checkIfChargeTypeExists.isEmpty()){
            errorLoggingException.logError("DELETE_BUSINESS_PLATFORM_CHARGE", "charge for the platform name provided not found","charge for the platform name provided not found");
            ResponseSchema<?> responseSchema =  new ResponseSchema<>( 404, "charge for the platform name provided not found ", null, "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.NOT_FOUND);
        }

        businessPlatformChargesRepository.delete(checkIfChargeTypeExists.get());

        ResponseSchema<?> responseSchema = new ResponseSchema<>( 200, "charge for this platform type deleted successfully", null, "", ZonedDateTime.now(), false);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }


}
