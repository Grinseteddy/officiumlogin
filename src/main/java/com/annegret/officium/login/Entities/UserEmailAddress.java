package com.annegret.officium.login.Entities;

import org.apache.catalina.User;

public class UserEmailAddress {

    private String eMailAddress;

    public UserEmailAddress() {

    }

    public UserEmailAddress(UserEmailAddress userEmailAddress) {
        this.eMailAddress=userEmailAddress.geteMailAddress();
    }

    public String geteMailAddress() {
        return eMailAddress;
    }

    public void seteMailAddress(String eMailAddress) {
        this.eMailAddress = eMailAddress;
    }
}
