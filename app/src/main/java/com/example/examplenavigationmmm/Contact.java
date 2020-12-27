package com.example.examplenavigationmmm;

public class Contact {
    String uid;
    String name;
    String image;
    String phone;
    int like;

    public Contact(String name, String image, String phone) {
        this.name = name;
        this.image = image;
        this.phone = phone;
        this.like = 0;
    }

    public String getName() {
        return name;
    }
    public void setName(String name){this.name=name;}
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
