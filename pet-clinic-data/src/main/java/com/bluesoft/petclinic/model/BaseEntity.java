package com.bluesoft.petclinic.model;

import java.io.Serializable;

class BaseEntity implements Serializable {
    private Long id;

    Long getId() {
        return id;
    }

    void setId(final Long id) {
        this.id = id;
    }
}
