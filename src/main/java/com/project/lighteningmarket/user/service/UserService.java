package com.project.lighteningmarket.user.service;

import com.project.lighteningmarket.user.domain.LoginDTO;
import com.project.lighteningmarket.user.domain.UserSearchDTO;
import com.project.lighteningmarket.user.domain.UserVO;

import java.util.Date;

public interface UserService {

    // 회원 가입 처리
    void signup(UserVO userVO) throws Exception;

    // 로그인 처리
    UserVO login(LoginDTO loginDTO) throws Exception;

    // 로그인 유지 처리
    void keepLogin(String id, String sessionId, Date next) throws Exception;

    // 세선키 검증
    UserVO checkLoginBefore(String value) throws Exception;

    // 아이디 찾기
    UserVO idsearch(UserSearchDTO userSearchDTO) throws Exception;

    // 비밀번호 찾기 (1. 인증번호 받기)
    UserVO emaildice(UserSearchDTO userSearchDTO) throws Exception;

    // 비밀번호 찾기
    void pwchange(UserVO userVO) throws Exception;
}
