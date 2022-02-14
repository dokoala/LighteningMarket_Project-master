package com.project.lighteningmarket.commons.category.domain;

public class CategoryDTO {
    private String cateName;
    private String cateCode;
    private String cateCodeRef;
    private int level;

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getCateCode() {
        return cateCode;
    }

    public void setCateCode(String cateCode) {
        this.cateCode = cateCode;
    }

    public String getCateCodeRef() {
        return cateCodeRef;
    }

    public void setCateCodeRef(String cateCodeRef) {
        this.cateCodeRef = cateCodeRef;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "cateName='" + cateName + '\'' +
                ", cateCode='" + cateCode + '\'' +
                ", cateCodeRef='" + cateCodeRef + '\'' +
                ", level=" + level +
                '}';
    }
}
