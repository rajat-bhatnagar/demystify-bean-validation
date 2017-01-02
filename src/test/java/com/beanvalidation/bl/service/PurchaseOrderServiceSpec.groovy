package com.beanvalidation.bl.service

import com.beanvalidation.data.Customer
import spock.lang.Shared
import spock.lang.Specification
import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

class PurchaseOrderServiceSpec extends Specification{
    @Shared
    ValidatorFactory validatorFactory
    @Shared
    Validator validator
    @Shared
    PurchaseOrderService bl

    //Run before all the tests
    def setupSpec(){
        validatorFactory = Validation.buildDefaultValidatorFactory()
        validator = validatorFactory.getValidator()
        bl = new PurchaseOrderService(validatorFactory: validatorFactory,
                validator: validator)
    }

    //Run After all the tests , even after failure
    def cleanupSpec(){
        validatorFactory.close()
    }

    def "test - createCustomer - valid"(){
        given:
        String dateOfCustomerEnrollment = '01-01-1982'
        Customer customer = new Customer('Tom' , 'Saw', 'Tome@Rockstar.com', '897-897-8967', Date.parse('dd-MM-yyyy', dateOfCustomerEnrollment))

        when:
        boolean isCustomerCreated = bl.createCustomer(customer)

        then:
        0 * _

        and:
        isCustomerCreated
    }

    def "test - createCustomer - invalid - null last name, email, phone number and date of enrollment"(){
        given:
        Customer customer = new Customer('Re' , null, null, null, null)

        when:
        boolean isCustomerCreated = bl.createCustomer(customer)

        then:
        0 * _

        and:
        !isCustomerCreated
    }

    def "test - createCustomer - Enroll a Customer in a future date"(){
        given:
        String dateOfEnrollment = '01-10-2082'
        Customer customer = new Customer('Jack', 'High', 'Jack@Wolverine.com', '786-890-5643', Date.parse('dd-MM-yyyy', dateOfEnrollment))

        when:
        boolean isCustomerCreatedInFutureDate = bl.createCustomer(customer)

        then:
        0 * _

        and:
        !isCustomerCreatedInFutureDate
    }
}
