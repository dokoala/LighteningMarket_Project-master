package com.project.lighteningmarket.products.service;

import com.project.lighteningmarket.products.domain.ProductsVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsService {
    // 01. 상품목록
    List<ProductsVO> listProduct() throws Exception;

    // 02. 상품상세
    ProductsVO detailProduct(int productId) throws Exception;

    // 03. 상품등록
    void insertProduct(ProductsVO vo) throws Exception;

    // 03. 상품수정
    void updateProduct(ProductsVO vo) throws Exception;

    // 04. 상품삭제
    void deleteProduct(int productId) throws Exception;

    // 05. 검색 후 목록
    List<ProductsVO> searchProduct(String searchData) throws Exception;
}
