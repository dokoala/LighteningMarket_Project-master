package com.project.lighteningmarket.mystore.persistence;

import com.project.lighteningmarket.mystore.domain.*;

import java.util.List;
public interface MyStoreDAO {

    // 상품 테이블 읽기
    List<ProductVO> product_listAll(ProductVO productVO) throws Exception;

    // 찜 테이블 읽기
    List<ProductVO> favorites_listAll(ProductVO productVO) throws Exception;

    // 이미지 테이블 읽기
    ImagesVO image_read(int imgIdx) throws Exception;

    // 상점문의 테이블 읽기
    List<StoreQaVO> storeQa_listAll(StoreQaVO storeQaVO) throws Exception;

    // 상점문의 테이블 추가
    void storeQaCreate(StoreQaVO storeQaVO) throws Exception;

    // 상점문의 테이블 삭제
    void storeQaDelete(StoreQaVO storeQaVO) throws Exception;

    // 팔로워 테이블 읽기
    List<FollowerVO> follower_listAll(FollowerVO followerVO) throws Exception;

    // 팔로잉 테이블 읽기
    List<FollowingVO> following_listAll(FollowingVO followingVO) throws Exception;


}
