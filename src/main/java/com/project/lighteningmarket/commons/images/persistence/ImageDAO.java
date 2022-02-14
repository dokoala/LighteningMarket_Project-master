package com.project.lighteningmarket.commons.images.persistence;

import com.project.lighteningmarket.commons.images.service.ImageService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.Map;

public interface ImageDAO {

    // 이미지 BLOB 처리
    void saveImage(Map<String, Object> map) throws Exception;

    // 이미지 BLOB 가져오기
    String loadImage() throws Exception;

    // test
    Map<String, Object> getByteImage() throws Exception;
}
