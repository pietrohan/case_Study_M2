package model;

import java.io.Serializable;

public class Client implements Serializable {
    //id, name, information, phoneNumber, address
    private String id, name, information, phoneNumber, address;
    private Jewlry jewlry;

    public Client() {
    }

    public Client(String id, String name, String information, String phoneNumber, String address, Jewlry jewlry) {
        this.id = id;
        this.name = name;
        this.information = information;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.jewlry = jewlry;
    }

    public Jewlry getJewlry() {
        return jewlry;
    }

    public void setJewlry(Jewlry jewlry) {
        this.jewlry = jewlry;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", information='" + information + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", jewlry=" + jewlry +
                '}';
    }
}
