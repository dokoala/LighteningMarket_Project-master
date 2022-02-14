package com.project.lighteningmarket.mystore.domain;

import java.util.List;

public class FollowerVO {

    private String loginId; // 로그인한 아이디
    private String followerNickname; // 팔로워하는 사람
    private int followerProdutCount; // 팔로워 상품개수
    private int followerCount; // 팔로워 팔로워수


    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getFollowerNickname() {
        return followerNickname;
    }

    public void setFollowerNickname(String followerNickname) {
        this.followerNickname = followerNickname;
    }

    public int getFollowerProdutCount() {
        return followerProdutCount;
    }

    public void setFollowerProdutCount(int followerProdutCount) {
        this.followerProdutCount = followerProdutCount;
    }

    public int getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(int followerCount) {
        this.followerCount = followerCount;
    }

    @Override
    public String toString() {
        return "FollowerVO{" +
                "loginId='" + loginId + '\'' +
                ", followerNickname='" + followerNickname + '\'' +
                ", followerProdutCount=" + followerProdutCount +
                ", followerCount=" + followerCount +
                '}';
    }

}
