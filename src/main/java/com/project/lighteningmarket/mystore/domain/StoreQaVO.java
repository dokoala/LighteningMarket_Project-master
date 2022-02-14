package com.project.lighteningmarket.mystore.domain;

public class StoreQaVO {
    private String loginId; // 로그인 된 아이디
    private int storeQaIdx; // 상점문의번호
    private String nickname; // 닉네임(member.nickname)
    private String storeQaDes; // 상점문의내용
    private String unknownCheck; // 익명여부
    private String storeNickname; // 상점 주인 닉네임


    @Override
    public String toString() {
        return "StoreQaVO{" +
                "loginId='" + loginId + '\'' +
                ", storeQaIdx=" + storeQaIdx +
                ", nickname='" + nickname + '\'' +
                ", storeQaDes='" + storeQaDes + '\'' +
                ", unknownCheck='" + unknownCheck + '\'' +
                ", storeNickname='" + storeNickname + '\'' +
                '}';
    }


    public String getStoreNickname() {
        return storeNickname;
    }

    public void setStoreNickname(String storeNickname) {
        this.storeNickname = storeNickname;
    }


    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public int getStoreQaIdx() {
        return storeQaIdx;
    }

    public void setStoreQaIdx(int storeQaIdx) {
        this.storeQaIdx = storeQaIdx;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getStoreQaDes() {
        return storeQaDes;
    }

    public void setStoreQaDes(String storeQaDes) {
        this.storeQaDes = storeQaDes;
    }

    public String getUnknownCheck() {
        return unknownCheck;
    }

    public void setUnknownCheck(String unknownCheck) {
        this.unknownCheck = unknownCheck;
    }









}
