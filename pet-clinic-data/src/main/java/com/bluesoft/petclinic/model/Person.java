package com.bluesoft.petclinic.model;

class Person extends BaseEntity{
    private String firstName;
    private String lastName;

    String getFirstName() {
        return firstName;
    }

    void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    String getLastName() {
        return lastName;
    }

    void setLastName(final String lastName) {
        this.lastName = lastName;
    }
}
