package com.beanvalidation.constraints.validation;

import com.beanvalidation.constraints.generic.URL;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.net.MalformedURLException;

/**
 * This is the validation class for the generic constraint URL.
 * Remember The generic constraint validation class needs to implement
 * ConstraintValidator interface
 */
public class URLValidator implements ConstraintValidator<URL, String> {

    private String protocol;
    private String host;
    private int port;

    /**
     * Initializes the validator
     */
    @Override
    public void initialize(URL url) {
        this.protocol = url.protocol();
        this.host = url.host();
        this.port = url.port();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null && value.length() == 0)
            return true;

        java.net.URL url;
        try {
            url = new java.net.URL(value);
        } catch (MalformedURLException e) {
           return false;
        }

        if (protocol != null && protocol.length() > 0 && !url.getProtocol().equals(protocol))
            return false;

        if (host != null && host.length() > 0 && !url.getHost().startsWith(host))
            return false;

        if (port != -1 && url.getPort() != port)
            return false;
        return true;
    }
}
