package com.skrt.Model;

public class CEO {
    private int id;
    private String name;

    /* TODO Observer möster */


    public CEO() {

    }

    public CEO(int id, String name) {
        this.id = id;
        this.name = name;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
