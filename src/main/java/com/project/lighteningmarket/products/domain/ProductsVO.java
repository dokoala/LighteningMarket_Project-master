package com.project.lighteningmarket.products.domain;

import org.springframework.web.multipart.MultipartFile;

public class ProductsVO {
    private int productIdx; // 상품번호
    private String id; // 등록자아이디
    private String productTitle;// 상품제목
    private String tradeArea;// 거래지역
    private String statement; // 상품상태
    private String exchange; // 교환 가능 여부
    private String productPrice; // 상품 가격
    private String description; // 상품설명
    private String count; // 상품 수량
    private String regDate; // 등록일자
    private String productUrl; // 경로
    private MultipartFile productPhoto; // 상품이미지 파일

    public int getProductIdx() {
        return productIdx;
    }

    public void setProductIdx(int productIdx) {
        this.productIdx = productIdx;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getTradeArea() {
        return tradeArea;
    }

    public void setTradeArea(String tradeArea) {
        this.tradeArea = tradeArea;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public MultipartFile getProductPhoto() {
        return productPhoto;
    }

    public void setProductPhoto(MultipartFile productPhoto) {
        this.productPhoto = productPhoto;
    }

    @Override
    public String toString() {
        return "ProductsVO{" +
                "productIdx=" + productIdx +
                ", id='" + id + '\'' +
                ", productTitle='" + productTitle + '\'' +
                ", tradeArea='" + tradeArea + '\'' +
                ", statement='" + statement + '\'' +
                ", exchange='" + exchange + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", description='" + description + '\'' +
                ", count='" + count + '\'' +
                ", regDate='" + regDate + '\'' +
                ", productUrl='" + productUrl + '\'' +
                ", productPhoto=" + productPhoto +
                '}';
    }
}
