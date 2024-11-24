package com.neptune.cbawrapper.Models;

public class CustomerOptions {

    private Integer id;
    private String customer_created_at;
    private String is_active;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomer_created_at() {
        return customer_created_at;
    }

    public void setCustomer_created_at(String customer_created_at) {
        this.customer_created_at = customer_created_at;
    }

    public String getIs_active() {
        return is_active;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }

    public CustomerOptions(String customer_created_at, String is_active) {
        this.customer_created_at = customer_created_at;
        this.is_active = is_active;
    }
}
