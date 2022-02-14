package com.project.lighteningmarket.products.persistence;

import com.project.lighteningmarket.products.domain.ProductsVO;

import java.util.List;

public interface ProductsDAO {

    // 01. 상품목록
    public List<ProductsVO> listProduct() throws Exception;
    // 02. 상품상세
    public ProductsVO detailProduct(int productId) throws Exception;
    // 03. 상품등록
    void insertProduct(ProductsVO vo) throws Exception;
    // 03. 상품수정
    public void updateProduct(ProductsVO vo) throws Exception;
    // 04. 상품삭제
    public void deleteProduct(int productId) throws Exception;
    // 05. 검색 후 목록
    public List<ProductsVO> searchProductList(String searchData) throws Exception;
}
