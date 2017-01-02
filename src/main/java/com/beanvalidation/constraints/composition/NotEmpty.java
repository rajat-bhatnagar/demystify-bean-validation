package com.beanvalidation.constraints.composition;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@NotNull
@Size(min = 4)
public @interface NotEmpty {
    /**
     * Body of the Constraint which has the Composition should
     * have a message parameter
     */
    String message() default "should not be empty and minimum length is 4";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
