package com.project.lighteningmarket.mystore.service;

import com.project.lighteningmarket.mystore.domain.*;
import com.project.lighteningmarket.mystore.persistence.MyStoreDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service
public class MyStoreServiceImpl implements MyStoreService{
    private final MyStoreDAO myStoreDAO;

    @Inject
    public MyStoreServiceImpl(MyStoreDAO myStoreDAO) {this.myStoreDAO = myStoreDAO;}

    // 상품 테이블 읽기
    @Override
    public List<ProductVO> product_listAll(ProductVO productVO) throws Exception {
        return myStoreDAO.product_listAll(productVO);
    }

    // 찜 테이블 읽기
    @Override
    public List<ProductVO> favorites_listAll(ProductVO productVO) throws Exception {
        return myStoreDAO.favorites_listAll(productVO);
    }


    // 이미지 테이블 읽기
    public ImagesVO image_read(int imgIdx) throws Exception {
        return myStoreDAO.image_read(imgIdx);
    }

    // 상점문의 테이블 읽기
    @Override
    public List<StoreQaVO> storeQa_listAll(StoreQaVO storeQaVO) throws Exception {
        return myStoreDAO.storeQa_listAll(storeQaVO);
    }

    // 상점문의 테이블 추가
    @Override
    public void storeQaAddReply(StoreQaVO storeQaVO) throws Exception {
       myStoreDAO.storeQaCreate(storeQaVO);
    }


    // 상점문의 테이블 삭제
    @Override
    public void storeQaDelete(StoreQaVO storeQaVO) throws Exception {
        myStoreDAO.storeQaDelete(storeQaVO);
    }

    // 팔로워 테이블 읽기
    @Override
    public List<FollowerVO> follower_listAll(FollowerVO followerVO) throws Exception {
        return myStoreDAO.follower_listAll(followerVO);
    }

    // 팔로잉 테이블 읽기
    @Override
    public List<FollowingVO> following_listAll(FollowingVO followingVO) throws Exception {
        return myStoreDAO.following_listAll(followingVO);
    }

}
