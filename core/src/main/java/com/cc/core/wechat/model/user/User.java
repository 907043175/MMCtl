package com.cc.core.wechat.model.user;


public class User {

    private String wechatId;
    // 微信号
    private String alias;
    private String qr;
    private String nickname;
    private String signature;
    private String regionCode;
    private int sex;
    private String avatar;
    private String phone;

    public String getAlias() {
        return this.alias;
    }
    public void setAlias(String alias) {
        this.alias = alias;
    }
    public String getWechatId() {
        return this.wechatId;
    }
    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }
    public String getQr() {
        return this.qr;
    }
    public void setQr(String qr) {
        this.qr = qr;
    }
    public String getNickname() {
        return this.nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getSignature() {
        return this.signature;
    }
    public void setSignature(String signature) {
        this.signature = signature;
    }
    public String getRegionCode() {
        return this.regionCode;
    }
    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }
    public int getSex() {
        return this.sex;
    }
    public void setSex(int sex) {
        this.sex = sex;
    }
    public String getAvatar() {
        return this.avatar;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                ", alias='" + alias + '\'' +
                ", wechatId='" + wechatId + '\'' +
                ", qr='" + qr + '\'' +
                ", nickname='" + nickname + '\'' +
                ", signature='" + signature + '\'' +
                ", regionCode='" + regionCode + '\'' +
                ", sex=" + sex +
                ", avatar='" + avatar + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
