package com.project.lighteningmarket.user.persistence;

import com.project.lighteningmarket.user.domain.LoginDTO;
import com.project.lighteningmarket.user.domain.UserSearchDTO;
import com.project.lighteningmarket.user.domain.UserVO;

import java.util.Date;

public interface UserDAO {

    // 회원가입 처리
    void signup(UserVO userVO) throws Exception;

    // 로그인 처리
    UserVO login(LoginDTO loginDTO) throws Exception;

    // 로그인 유지 처리
    void keepLogin(String id, String sessionId, Date sessionLimit) throws Exception;

    // 세션키 인증
    UserVO checkUserWithSessionKey(String value) throws Exception;

    // 아이디 찾기
    UserVO idsearch(UserSearchDTO userSearchDTO) throws Exception;

    // 비밀번호 찾기 (1. 인증번호 받기)
    UserVO emaildice(UserSearchDTO userSearchDTO) throws Exception;

    // 비밀번호 찾기 (2. 인증번호 확인된 회원 비밀번호 수정)
    void pwchange(UserVO userVO) throws Exception;
}
