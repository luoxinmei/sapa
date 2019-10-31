package com.sapa.model;

/**
 * @author 罗小妹
 */
public class Pet {
    private Integer petId;

    private String name;

    private String gender;

    private Integer age;

    private String picture;

    private Integer states;

    private Integer petAdoptor;

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getStates() {
        return states;
    }

    public void setStates(Integer states) {
        this.states = states;
    }

    public Integer getPetAdoptor() {
        return petAdoptor;
    }

    public void setPetAdoptor(Integer petAdoptor) {
        this.petAdoptor = petAdoptor;
    }
}