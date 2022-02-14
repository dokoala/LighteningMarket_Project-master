package com.project.lighteningmarket.mystore.domain;

import java.sql.Blob;

public class ImagesVO {
    private int imgIdx; // 이미지 번호
    private int proIdx; // 상품번호 (product.proIdx)
    private Blob imgUrl; // 이미지 주소


    public Blob getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(Blob imgUrl) {
        this.imgUrl = imgUrl;
    }



    public int getImgIdx() {
        return imgIdx;
    }

    public void setImgIdx(int imgIdx) {
        this.imgIdx = imgIdx;
    }

    public int getProIdx() {
        return proIdx;
    }

    public void setProIdx(int proIdx) {
        this.proIdx = proIdx;
    }






}
