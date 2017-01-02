package com.beanvalidation.data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;


public class Customer {
    /*
     * Using Built in validations in javax.validation.constraints via annotations @NotNull and @Size
     */
    @NotNull
    @Size(max = 40 , min = 3)
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String email;

    @NotNull
    private String phoneNumber;

    /*
     * Element must be a date in past
     */
    @Past
    private Date dateOfCustomerEnrollment;

    public Date getDateOfCustomerEnrollment() {
        return dateOfCustomerEnrollment;
    }

    public void setDateOfCustomerEnrollment(Date dateOfCustomerEnrollment) {
        this.dateOfCustomerEnrollment = dateOfCustomerEnrollment;
    }

    public Customer() {
    }

    public Customer(String firstName, String lastName, String email, String phoneNumber, Date dateOfCustomerEnrollment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfCustomerEnrollment = dateOfCustomerEnrollment;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dateOfCustomerEnrollment='" + dateOfCustomerEnrollment + '\'' +
                '}';
    }
}
