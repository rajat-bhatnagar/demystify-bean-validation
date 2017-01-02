package com.beanvalidation.bl.service;

import com.beanvalidation.data.Salesman;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class SalesmanService {

    private Logger logger = LoggerFactory.getLogger(SalesmanService.class);

    private ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

    private Validator validator = validatorFactory.getValidator();

    private Set<ConstraintViolation<Salesman>> violations;

    public boolean createSalesman(Salesman salesman){
        boolean isSalesmanCreated = true;

        /*
         * Validating the Salesman by Validation API
         */
        violations = validator.validate(salesman);
        if(!violations.isEmpty()){
            isSalesmanCreated = false;
            logger.error(" ## Constraint Violations Size : "+violations.size());
            for(ConstraintViolation<Salesman> violation : violations) {
                logger.error(violation.getRootBeanClass().getSimpleName() + "." +
                violation.getPropertyPath() + " - " + violation.getInvalidValue()+
                " / Error message - "+violation.getMessage());
            }

        }
        return isSalesmanCreated;
    }
}
