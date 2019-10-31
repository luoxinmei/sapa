package com.sapa.model;

/**
 * @author 罗小妹
 */
public class Adoptor {
    private Integer adoptorId;

    private String name;

    private String gender;

    private String idCard;

    private String telephone;

    private String address;

    private String wechat;

    private String reason;

    public Integer getAdoptorId() {
        return adoptorId;
    }

    public void setAdoptorId(Integer adoptorId) {
        this.adoptorId = adoptorId;
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}