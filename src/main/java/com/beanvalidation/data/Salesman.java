package com.beanvalidation.data;

import com.beanvalidation.constraints.composition.NotEmpty;

/**
 * A class on which constraint composition is applied
 * to avoid code duplication
 */
public class Salesman {

    /**
     * @NotEmpty is an example of Constraint Composition
     */
    @NotEmpty
    private String firstname;

    @NotEmpty
    private String lastname;

    private String email;

    private String salesMailboxEmail;

    @Override
    public String toString() {
        return "Salesman{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", salesMailboxEmail='" + salesMailboxEmail + '\'' +
                '}';
    }

    public Salesman(String firstname, String lastname, String email, String salesMailboxEmail) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.salesMailboxEmail = salesMailboxEmail;
    }

    public Salesman() {

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalesMailboxEmail() {
        return salesMailboxEmail;
    }

    public void setSalesMailboxEmail(String salesMailboxEmail) {
        this.salesMailboxEmail = salesMailboxEmail;
    }
}
