package com.project.lighteningmarket.products.service;

import com.project.lighteningmarket.mystore.domain.ProductVO;
import com.project.lighteningmarket.products.domain.ProductsVO;
import com.project.lighteningmarket.products.persistence.ProductsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductsDAO productDao;

    // 01. 상품목록
    @Override
    public List<ProductsVO> listProduct() throws Exception {
        return productDao.listProduct();
    }
    // 02. 상품상세
    @Override
    public ProductsVO detailProduct(int productId) throws Exception {
        return productDao.detailProduct(productId);
    }

    // 03. 상품추가
    @Override
    public void insertProduct(ProductsVO vo) throws Exception {
        productDao.insertProduct(vo);
    }

    // 03. 상품수정
    @Override
    public void updateProduct(ProductsVO vo) {
        // TODO Auto-generated method stub

    }
    // 04. 상품삭제
    @Override
    public void deleteProduct(int productId) {
        // TODO Auto-generated method stub

    }

    // 05. 검색 후 목록
    @Override
    public List<ProductsVO> searchProduct(String searchData) throws Exception {
        return productDao.searchProductList(searchData);
    }

}