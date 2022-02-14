package com.project.lighteningmarket.mystore.domain;

public class FavoritesVO {
    private int favor_idx; // 찜고유번호
    private String id; //아이디 (member.id)
    private int proIdx; //상품번호(product.proidx)
    private String productUrl; // 이미지 파일 경로


    @Override
    public String toString() {
        return "FavoritesVO{" +
                "favor_idx=" + favor_idx +
                ", id='" + id + '\'' +
                ", proIdx=" + proIdx +
                ", productUrl='" + productUrl + '\'' +
                ", imagesVO=" + imagesVO +
                ", productVO=" + productVO +
                '}';
    }



    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }



    public ImagesVO getImagesVO() {
        return imagesVO;
    }

    public void setImagesVO(ImagesVO imagesVO) {
        this.imagesVO = imagesVO;
    }

    public ProductVO getProductVO() {
        return productVO;
    }

    public void setProductVO(ProductVO productVO) {
        this.productVO = productVO;
    }

    private ImagesVO imagesVO;
    private ProductVO productVO;

    public int getFavor_idx() {
        return favor_idx;
    }

    public void setFavor_idx(int favor_idx) {
        this.favor_idx = favor_idx;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getProIdx() {
        return proIdx;
    }

    public void setProIdx(int proIdx) {
        this.proIdx = proIdx;
    }


}
