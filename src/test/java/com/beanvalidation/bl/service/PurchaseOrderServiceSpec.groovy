package com.beanvalidation.bl.service

import com.beanvalidation.data.Customer
import spock.lang.Specification

import javax.validation.ConstraintViolation
import javax.validation.ConstraintViolationException
import javax.validation.Validator
import javax.validation.ValidatorFactory

class PurchaseOrderServiceSpec extends Specification{
    ValidatorFactory validatorFactory = Mock()
    Validator validator = Mock()

    PurchaseOrderService bl = new PurchaseOrderService(validatorFactory: validatorFactory,
                                                        validator: validator)

    def "test - createCustomer - valid"(){
        given:
        Customer customer = new Customer('Gagan', 'Bhatnagar', 'gagan@gmail.com', '149-89607867', '10-10-1982');

        when:
        bl.createCustomer(customer)

        then:
        1 * validator.validate(customer) >> []
        0 * _

        and:
        noExceptionThrown()
    }

    def "test - updateCustomer - valid"(){
        given:
        Customer customer = new Customer('Amit', 'Bhatnagar', 'gagan@gmail.com', '149-89607867', '10-10-1982');

        when:
        bl.createCustomer(customer)

        then:
        1 * validator.validate(customer) >> []
        0 * _

        and:
        noExceptionThrown()
    }
}
