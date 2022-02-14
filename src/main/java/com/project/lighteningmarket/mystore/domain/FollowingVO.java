package com.project.lighteningmarket.mystore.domain;
public class FollowingVO {

    private String loginId; // 로그인한 아이디
    private String followingProIdx; // 상품번호
    private String followingNickname; // 팔로잉 할 사람
    private int followingProdutCount; // 팔로잉 한 유저 상품개수
    private int followerCount; // 팔로잉 한 유저 팔로워수
    private String productUrl; // 경로


    @Override
    public String toString() {
        return "FollowingVO{" +
                "loginId='" + loginId + '\'' +
                ", followingProIdx='" + followingProIdx + '\'' +
                ", followingNickname='" + followingNickname + '\'' +
                ", followingProdutCount=" + followingProdutCount +
                ", followerCount=" + followerCount +
                ", productUrl='" + productUrl + '\'' +
                '}';
    }


    public String getFollowingProIdx() {
        return followingProIdx;
    }

    public void setFollowingProIdx(String followingProIdx) {
        this.followingProIdx = followingProIdx;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getFollowingNickname() {
        return followingNickname;
    }

    public void setFollowingNickname(String followingNickname) {
        this.followingNickname = followingNickname;
    }

    public int getFollowingProdutCount() {
        return followingProdutCount;
    }

    public void setFollowingProdutCount(int followingProdutCount) {
        this.followingProdutCount = followingProdutCount;
    }

    public int getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(int followerCount) {
        this.followerCount = followerCount;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

}
