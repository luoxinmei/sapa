package com.sapa.req;

/**
 * @author 罗小妹
 */
public class AddPetReq {
    private String name;

    private String gender;

    private Integer age;

    private String picture;

    private Integer petAdoptor;

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



    public Integer getPetAdoptor() {
        return petAdoptor;
    }

    public void setPetAdoptor(Integer petAdoptor) {
        this.petAdoptor = petAdoptor;
    }
}
