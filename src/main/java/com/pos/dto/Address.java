package com.pos.dto;

public class Address {
    private int id;
    private String state;
    private String city;
    private String country;
    private boolean isPermanentAddress;
    private boolean isCurrentAddress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isPermanentAddress() {
        return isPermanentAddress;
    }

    public void setPermanentAddress(boolean permanentAddress) {
        isPermanentAddress = permanentAddress;
    }

    public boolean isCurrentAddress() {
        return isCurrentAddress;
    }

    public void setCurrentAddress(boolean currentAddress) {
        isCurrentAddress = currentAddress;
    }
}
