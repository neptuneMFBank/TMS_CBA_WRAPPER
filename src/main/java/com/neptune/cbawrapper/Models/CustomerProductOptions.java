package com.neptune.cbawrapper.Models;

public class CustomerProductOptions {

    private Integer id;
    private String product_created_at;
    private String old_account_number;
    private String account_number;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct_created_at() {
        return product_created_at;
    }

    public void setProduct_created_at(String product_created_at) {
        this.product_created_at = product_created_at;
    }

    public String getOld_account_number() {
        return old_account_number;
    }

    public void setOld_account_number(String old_account_number) {
        this.old_account_number = old_account_number;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public CustomerProductOptions(String product_created_at, String old_account_number, String account_number) {
        this.product_created_at = product_created_at;
        this.old_account_number = old_account_number;
        this.account_number = account_number;
    }
}
