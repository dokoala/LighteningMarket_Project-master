package com.project.lighteningmarket.commons.images.persistence;

import com.project.lighteningmarket.user.domain.LoginDTO;
import com.project.lighteningmarket.user.domain.UserSearchDTO;
import com.project.lighteningmarket.user.domain.UserVO;
import com.project.lighteningmarket.user.persistence.UserDAO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.Map;

@Repository
public class ImageDAOImpl implements ImageDAO {


    private static final String NAMESPACE = "com.project.lighteningmarket.mappers.image.ImageMapper";

    @Autowired
    private SqlSession query;

    @Inject
    public ImageDAOImpl(SqlSession sqlSession) {
        this.query = sqlSession;
    }

    @Override
    public void saveImage(Map<String, Object> hmap) throws Exception{
        query.insert(NAMESPACE + ".saveImage", hmap);
    }

    @Override
    public String loadImage() throws Exception {
        return query.selectOne(NAMESPACE + ".loadImage");
    }

    @Override
    public Map<String, Object> getByteImage() {
        return query.selectOne(NAMESPACE + ".getByteImage");
    }
}
