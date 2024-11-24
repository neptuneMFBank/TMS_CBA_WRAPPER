package com.neptune.cbawrapper.RequestRessponseSchema;


import java.util.List;

public class CustomerData {

    private List<Data> data;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public CustomerData(List<Data> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                data +
                '}';
    }
}
