package com.project.lighteningmarket.products.persistence;

import com.project.lighteningmarket.products.domain.ProductsVO;
import com.project.lighteningmarket.products.persistence.ProductsDAO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductsDAOImpl implements ProductsDAO {

    private static final String NAMESPACE = "com.project.lighteningmarket.mappers.products.productMapper";

    @Autowired
    private SqlSession sqlSession;

    // 01. 상품목록
    @Override
    public List<ProductsVO> listProduct() {
        return sqlSession.selectList(NAMESPACE + ".listProduct");
    }

    // 02. 상품상세
    @Override
    public ProductsVO detailProduct(int productId) {
        return sqlSession.selectOne(NAMESPACE + ".detailProduct", productId);
    }

    // 03. 상품 등록
    @Override
    public void insertProduct(ProductsVO vo) throws Exception {
        String sessionValue = vo.getId();
        String id = sqlSession.selectOne(NAMESPACE + ".searchId", sessionValue);
        System.out.println("id는 "+ id);
        vo.setId(id);
        sqlSession.insert(NAMESPACE + ".insertProduct", vo);
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
    public List<ProductsVO> searchProductList(String searchData) throws Exception {return sqlSession.selectList(NAMESPACE + ".searchProductList", searchData);
    }

}