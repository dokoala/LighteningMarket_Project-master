package com.project.lighteningmarket.mystore.domain;

import java.util.Date;

public class ProductVO {
    private int proIdx; // 상품번호
    private String id; // 아이디 (member.id)
    private String title; // 제목
    private String tradeArea; // 거래지역
    private String statement; // 상태
    private String exchange; //교환 (Y/N)
    private String price; // 가격
    private String description;// 설명
    private int count; //수량
    private Date regDate; // 등록일자
    private String productUrl; // 이미지 파일 경로

    @Override
    public String toString() {
        return "ProductVO{" +
                "proIdx=" + proIdx +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", tradeArea='" + tradeArea + '\'' +
                ", statement='" + statement + '\'' +
                ", exchange='" + exchange + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                ", count=" + count +
                ", regDate=" + regDate +
                ", productUrl='" + productUrl + '\'' +
                '}';
    }



    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }



    public int getProIdx() {
        return proIdx;
    }

    public void setProIdx(int proIdx) {
        this.proIdx = proIdx;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

}
