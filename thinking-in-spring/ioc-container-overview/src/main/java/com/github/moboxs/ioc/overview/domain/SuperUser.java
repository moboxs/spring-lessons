package com.github.moboxs.ioc.overview.domain;

import com.github.moboxs.ioc.overview.annotation.Supper;

@Supper
public class SuperUser extends User{

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
