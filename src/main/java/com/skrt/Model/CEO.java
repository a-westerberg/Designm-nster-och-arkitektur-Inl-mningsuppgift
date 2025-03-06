package com.skrt.Model;

import com.skrt.Model.Observer.Observer;

public class CEO implements Observer {
    private int id = 1;
    private String name = "Alex";

    /* TODO Observer möster */


    public CEO() {

    }

    public CEO(int id, String name) {
        this.id = id;
        this.name = name;

    }


    @Override
    public void update(String message) {
        System.out.println("CEO " + name + " notified: " + message);
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
