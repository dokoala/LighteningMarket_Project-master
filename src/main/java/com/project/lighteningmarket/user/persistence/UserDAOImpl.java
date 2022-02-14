package com.project.lighteningmarket.user.persistence;

import com.project.lighteningmarket.user.domain.LoginDTO;
import com.project.lighteningmarket.user.domain.UserSearchDTO;
import com.project.lighteningmarket.user.domain.UserVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDAOImpl implements UserDAO {
    private static final String NAMESPACE = "com.project.lighteningmarket.mappers.user.UserMapper";

    private final SqlSession sqlSession;

    @Inject
    public UserDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    // 회원가입 처리
    @Override
    public void signup(UserVO userVO) throws Exception {
        sqlSession.insert(NAMESPACE + ".signup", userVO);
    }

    // 로그인 처리
    @Override
    public UserVO login(LoginDTO loginDTO) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".login", loginDTO);
    }

    // 로그인 유지 처리
    @Override
    public void keepLogin(String id, String sessionId, Date sessionLimit) throws Exception {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        paramMap.put("sessionId", sessionId);
        paramMap.put("sessionLimit", sessionLimit);

        sqlSession.update(NAMESPACE + ".keepLogin", paramMap);
    }

    // 세선키 검증
    @Override
    public UserVO checkUserWithSessionKey(String value) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".checkUserWithSessionKey", value);
    }

    // 아이디 찾기
    @Override
    public UserVO idsearch(UserSearchDTO userSearchDTO) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".idsearch", userSearchDTO);
    }

    // 비밀번호 찾기 (1. 인증번호 받기)
    @Override
    public UserVO emaildice(UserSearchDTO userSearchDTO) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".emaildice", userSearchDTO);
    }

    // 비밀번호 찾기 (2. 인증번호 확인된 회원 비밀번호 수정)
    @Override
    public void pwchange(UserVO userVO) throws Exception {
        sqlSession.update(NAMESPACE + ".pwchange", userVO);
    }
}
