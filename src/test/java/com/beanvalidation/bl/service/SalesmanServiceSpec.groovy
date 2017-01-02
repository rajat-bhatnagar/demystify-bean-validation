package com.beanvalidation.bl.service

import com.beanvalidation.data.Salesman
import spock.lang.Shared
import spock.lang.Specification

import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

class SalesmanServiceSpec extends Specification{
    @Shared
    ValidatorFactory validatorFactory
    @Shared
    Validator validator
    @Shared
    SalesmanService bl

    //Run before all the tests
    def setupSpec(){
        validatorFactory = Validation.buildDefaultValidatorFactory()
        validator = validatorFactory.getValidator()
        bl = new SalesmanService(validatorFactory: validatorFactory,
                validator: validator)
    }

    //Run After all the tests , even after failure
    def cleanupSpec(){
        validatorFactory.close()
    }

    def "test - createSalesman - valid"(){
        given:
        Salesman salesman = new Salesman('Fand', 'Yuang', 'ming@kungfu.com' ,'mingmascot@dalai.com')

        when:
        boolean isSalesmanCreated = bl.createSalesman(salesman)

        then:
        0 * _

        and:
        isSalesmanCreated
    }

    def "test - createSalesman - first name less than 4 characters"(){
        given:
        Salesman salesman = new Salesman('Tu', 'Zing', 'Tu@kungfu.com' ,'zing@dalai.com')

        when:
        boolean isSalesmanCreated = bl.createSalesman(salesman)

        then:
        0 * _

        and:
        !isSalesmanCreated
    }

    def "test - createSalesman - last name less than 4 characters"(){
        given:
        Salesman salesman = new Salesman('Danze', 'Pu', 'Pu@kungfu.com' ,'Pu@dalai.com')

        when:
        boolean isSalesmanCreated = bl.createSalesman(salesman)

        then:
        0 * _

        and:
        !isSalesmanCreated
    }
}
