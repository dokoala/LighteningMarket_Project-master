package com.project.lighteningmarket.commons.images.domain;

import org.springframework.web.multipart.MultipartFile;

public class ImageDTO {
    private MultipartFile imgFile;

    public MultipartFile getImgFile() {
        return imgFile;
    }

    public void setImgFile(MultipartFile imgFile) {
        this.imgFile = imgFile;
    }
}
