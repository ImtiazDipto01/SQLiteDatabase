package com.example.admin.insertquery;

/**
 * Created by Admin on 3/25/2017.
 */

public class DataProvider {

    private String name, password ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DataProvider(String name, String password){

        this.name = name ;
        this.password = password ;

    }
}
