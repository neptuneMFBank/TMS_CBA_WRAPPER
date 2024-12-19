package com.neptune.cbawrapper.RequestRessponseSchema;


import java.util.List;

public class CustomerData<T> {

    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public CustomerData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                data +
                '}';
    }
}
