package com.beanvalidation.bl.service;

import com.beanvalidation.data.Customer;

import javax.validation.*;
import java.util.Set;

public class PurchaseOrderService {

    /*
     * Construct a validator using Validator factory
     */

    private ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

    private Validator validator = validatorFactory.getValidator();

    private Set<ConstraintViolation<Customer>> violations;

    public void createCustomer(Customer customer){
        violations = validator.validate(customer);
        if(violations.size() > 0){
            throw new ConstraintViolationException(violations);
        }
        //If no violations are there , Create a Customer
    }

    public void updateCustomer(Customer customer){
        violations = validator.validate(customer);
        if(!violations.isEmpty()){
            throw new ConstraintViolationException(violations);
        }
        //If no exceptions are there, Update a Customer
    }


}
