package com.annegret.officium.login.Entities;

public class UserName {

    private String userName;

    UserName() {

    }

    UserName(UserName userName){
        this.userName=userName.getUserName();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
