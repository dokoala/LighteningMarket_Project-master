package com.project.lighteningmarket.commons.images.service;

import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface ImageService {

    // 이미지 BLOB 처리
    void saveImage(Map<String, Object> map) throws Exception;

    // 이미지 불러오기
    String loadImage() throws Exception;

    // test
    Map<String, Object> getByteImage() throws Exception;
}
