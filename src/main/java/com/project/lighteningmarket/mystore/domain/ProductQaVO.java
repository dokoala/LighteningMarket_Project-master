package com.project.lighteningmarket.mystore.domain;

public class ProductQaVO {
    private String proQaIdx; // 상품문의번호
    private String nickname; // 닉네임(member.nickname)
    private String proQaDes; // 상품문의내용
    private String unknownCheck; // 익명여부

    public String getProQaIdx() {
        return proQaIdx;
    }

    public void setProQaIdx(String proQaIdx) {
        this.proQaIdx = proQaIdx;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getProQaDes() {
        return proQaDes;
    }

    public void setProQaDes(String proQaDes) {
        this.proQaDes = proQaDes;
    }

    public String getUnknownCheck() {
        return unknownCheck;
    }

    public void setUnknownCheck(String unknownCheck) {
        this.unknownCheck = unknownCheck;
    }

    @Override
    public String toString() {
        return "ProductQaVO{" +
                "proQaIdx='" + proQaIdx + '\'' +
                ", nickname='" + nickname + '\'' +
                ", proQaDes='" + proQaDes + '\'' +
                ", unknownCheck='" + unknownCheck + '\'' +
                '}';
    }
}
