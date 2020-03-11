package com.yc.utils;

public class LocalDTO {
    private int addressStep;
    private int storeStep;

    public int getAddressStep() {
        return addressStep;
    }

    public void setAddressStep(int addressStep) {
        this.addressStep = addressStep;
    }

    public int getStoreStep() {
        return storeStep;
    }

    public void setStoreStep(int storeStep) {
        this.storeStep = storeStep;
    }

    public LocalDTO(int addressStep, int storeStep) {
        this.addressStep = addressStep;
        this.storeStep = storeStep;
    }

}
