package com.guercifzone.jackinzo.tools;

public class RecModel {
    private int id;
    private String name;
    private String email;
    private String type;
    private String address;
    private String assurance;
    private String date_sing;
    private String date_burn;
    private byte[] image;

    public RecModel(int id, String name, String email, String type, String address, String assurance, String date_sing, String date_burn, byte[] image) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.type = type;
        this.address = address;
        this.assurance = assurance;
        this.date_sing = date_sing;
        this.date_burn = date_burn;
        this.image = image;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAssurance() {
        return assurance;
    }

    public void setAssurance(String assurance) {
        this.assurance = assurance;
    }

    public String getDate_sing() {
        return date_sing;
    }

    public void setDate_sing(String date_sing) {
        this.date_sing = date_sing;
    }

    public String getDate_burn() {
        return date_burn;
    }

    public void setDate_burn(String date_burn) {
        this.date_burn = date_burn;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
