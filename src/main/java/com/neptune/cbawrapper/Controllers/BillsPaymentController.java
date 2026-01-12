package com.neptune.cbawrapper.Controllers;

import com.neptune.cbawrapper.Models.BillsPaymentData;
import com.neptune.cbawrapper.Models.CategoriesModel;
import com.neptune.cbawrapper.Models.CategoryServicesModel;
import com.neptune.cbawrapper.Repository.BillsPaymentDataRepository;
import com.neptune.cbawrapper.Repository.CategoriesRepository;
import com.neptune.cbawrapper.Repository.CategoryServicesRepository;
import com.neptune.cbawrapper.RequestRessponseSchema.BillsPayment.*;
import com.neptune.cbawrapper.RequestRessponseSchema.ResponseSchema;
import com.neptune.cbawrapper.Services.BillsPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bills_payment")
public class BillsPaymentController {

    @Autowired
    private BillsPayment billsPayment;

    private final BillsPaymentDataRepository billsPaymentDataRepository;
    private final CategoriesRepository categoriesRepository;
    private final CategoryServicesRepository categoryServicesRepository;

    public BillsPaymentController(BillsPaymentDataRepository billsPaymentDataRepository, CategoryServicesRepository categoryServicesRepository, CategoriesRepository categoriesRepository) {
        this.billsPaymentDataRepository = billsPaymentDataRepository;
        this.categoryServicesRepository = categoryServicesRepository;
        this.categoriesRepository =  categoriesRepository;
    }

    @GetMapping("/bill/categories")
    public ResponseEntity<ResponseSchema<?>> getBillsCategories( @RequestParam(value = "paymentTypeId", required = false) Integer paymentTypeId){
        List<CategoriesModel> findCategory;// = categoriesRepository.findCategoryByPaymentTypeId(true, paymentTypeId);

        if (paymentTypeId != null) {
            findCategory = categoriesRepository.findCategoryByPaymentTypeId(true, paymentTypeId);
        } else {
            findCategory = categoriesRepository.findCategory(true);
        }

        ResponseSchema<?> responseSchema = new ResponseSchema<>( 200, "successful", findCategory, "", ZonedDateTime.now(), true);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }

    @GetMapping("/bill/category-service/{categoryId}")
    public ResponseEntity<ResponseSchema<?>> getCategoryServices(@PathVariable("categoryId") String categoryId){
        List<CategoryServicesModel> findAllById = categoryServicesRepository.findAllById(categoryId);

        ResponseSchema<?> responseSchema = new ResponseSchema<>( 200, "successful", findAllById, "", ZonedDateTime.now(), true);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }

    @GetMapping("/bill/info/{billerId}")
    public ResponseEntity<ResponseSchema<?>> getBillerInfo(@PathVariable("billerId") String billerId){
        BillInfo getBillInfo = billsPayment.getBillerInfo(billerId);

        ResponseSchema<?> responseSchema = new ResponseSchema<>( 200, "successful", getBillInfo, "", ZonedDateTime.now(), true);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }

    @PostMapping("/bill/validate-customer")
    public ResponseEntity<ResponseSchema<?>> validateCustomer(@RequestBody ValidateCustomerRequest request){
        System.out.println("request = " + request);
        Object validateCustomer = billsPayment.validateCustomer(request);

        ResponseSchema<?> responseSchema = new ResponseSchema<>( 200, "successful", validateCustomer, "", ZonedDateTime.now(), true);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }

    @PostMapping("/bill/make-payment")
    public ResponseEntity<ResponseSchema<?>> makePayment(@RequestBody MakePayment request){
         MakePaymentApiResponse validateCustomer = billsPayment.makePayment(request);

        BillsPaymentData billsPaymentData = new BillsPaymentData();
        billsPaymentData.setPaymentCode(request.getPaymentCode());
        billsPaymentData.setCustomerId(request.getCustomerId());
        billsPaymentData.setEmail(request.getEmail());
        billsPaymentData.setMobile(request.getMobile());
        billsPaymentData.setAmount(request.getAmount());
        billsPaymentData.setCustomerAccountNumber(request.getCustomerAccountNumber());
        billsPaymentData.setBillType(request.getBillType());
        billsPaymentData.setResponse(validateCustomer);
        billsPaymentData.setRequestReference(request.getRequestReference());

        billsPaymentDataRepository.save(billsPaymentData);

        ResponseSchema<?> responseSchema = new ResponseSchema<>( 200, "successful", validateCustomer, "", ZonedDateTime.now(), true);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }
}
