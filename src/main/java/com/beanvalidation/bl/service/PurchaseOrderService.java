package com.beanvalidation.bl.service;

import com.beanvalidation.data.Customer;

import javax.validation.*;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PurchaseOrderService {

    private final Logger logger = LoggerFactory.getLogger(PurchaseOrderService.class);

    /*
     * Construct a validator using Validator factory
     */

    private ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

    private Validator validator = validatorFactory.getValidator();

    private Set<ConstraintViolation<Customer>> violations;

    public boolean createCustomer(Customer customer){
        boolean isCustomerCreated = true;
        violations = validator.validate(customer);
        /**
         * If the Set of Typed Constraint Violations is not empty then
         * the Set Size == Number of Constraint Failure
         */
        if(!violations.isEmpty()){
            isCustomerCreated = false;
            logger.error(" ## Constraint Violations Size : "+violations.size());
            for(ConstraintViolation<Customer> violation : violations){
                logger.error(" ## ConstraintViolationException for Customer ");
                /**
                 * Constraint Violation API can be used to get
                 * Error Message
                 * Property Being Validated
                 * Invalid Value
                 */
                logger.error(violation.getRootBeanClass().getSimpleName() + "." +
                        violation.getPropertyPath() + " = "+violation.getInvalidValue() +
                        " :: error message - "+violation.getMessage());
            }
        }
        //If no violations are there , Create a Customer
        return isCustomerCreated;
    }

    public void updateCustomer(Customer customer){
        violations = validator.validate(customer);
        if(!violations.isEmpty()){
            throw new ConstraintViolationException(violations);
        }
        //If no exceptions are there, Update a Customer
    }


}
