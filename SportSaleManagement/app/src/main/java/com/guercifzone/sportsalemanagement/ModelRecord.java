package com.guercifzone.sportsalemanagement;

public class ModelRecord {
    String id,name, email,image,address, dob,burndate,rectime;

    public ModelRecord(String id, String name, String email, String image, String address, String dob, String burndate, String rectime) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.image = image;
        this.address = address;
        this.dob = dob;
        this.burndate = burndate;
        this.rectime = rectime;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getBurndate() {
        return burndate;
    }

    public void setBurndate(String burndate) {
        this.burndate = burndate;
    }

    public String getRectime() {
        return rectime;
    }

    public void setRectime(String rectime) {
        this.rectime = rectime;
    }
}
