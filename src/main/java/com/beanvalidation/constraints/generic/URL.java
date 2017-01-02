package com.beanvalidation.constraints.generic;

import com.beanvalidation.constraints.validation.URLValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE,
        ElementType.METHOD, ElementType.FIELD})
/**
 * URLValidator does the validation for the generic constraint
 */

@Constraint(validatedBy = {URLValidator.class})
public @interface URL {
    String message() default "malformed URL";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * default values for the fields specified in UrlValidator.class
     */

    String protocol() default "";

    String host() default "";

    int port() default  -1;
}
