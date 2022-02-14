package com.project.lighteningmarket.commons.images.service;

import com.project.lighteningmarket.commons.images.persistence.ImageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class imageServiceImpl implements ImageService{

    @Autowired
    private ImageDAO imageDao;

    /** 이미지 저장 **/
    @Override
    public void saveImage(Map<String, Object> map) throws Exception {
        imageDao.saveImage(map);
    }

    /** 이미지 불러오기 **/
    @Override
    public String loadImage() throws Exception {
        return imageDao.loadImage();
    }

    /** 이미지 불러오기 **/
    @Override
    public Map<String, Object> getByteImage() throws Exception {
        return imageDao.getByteImage();
    }
}
