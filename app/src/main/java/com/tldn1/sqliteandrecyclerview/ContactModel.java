package com.tldn1.sqliteandrecyclerview;

/**
 * Created by X on 12/28/2016.
 */

public class ContactModel {
    private String name;
    private String email;
    private int id;
    public ContactModel(int id,String name, String email) {
        this.setId(id);
        this.setName(name);
        this.setEmail(email);
    }
    public ContactModel(String name, String email) {
        this.setName(name);
        this.setEmail(email);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
