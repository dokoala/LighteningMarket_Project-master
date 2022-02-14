package com.project.lighteningmarket.mystore.controller;

import com.project.lighteningmarket.mystore.service.MyStoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.project.lighteningmarket.mystore.domain.*;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/mystore")
public class MyStoreController {

    private static final Logger logger = LoggerFactory.getLogger(MyStoreController.class);

    private final MyStoreService mystoreservice;

    @Inject
    public MyStoreController(MyStoreService mystoreservice) {this.mystoreservice = mystoreservice;}

    //------------------------------------------------------------------------------------------------------------------
    // 상품 페이지로 이동
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String productGET(Model model, HttpServletRequest request, ProductVO productVO) throws Exception {
        Cookie[] cookies = request.getCookies();
        String sessionkey = "";
        if(cookies != null){
            for(int i=0; i < cookies.length; i++){
                Cookie cookie = cookies[i] ;
                // 저장된 쿠키 이름을 가져온다
                String cName = cookie.getName();
                if(cName.equals("loginCookie")){
                    sessionkey = cookie.getValue();
                    break;
                }
            }
        }
        productVO.setId(sessionkey); // 세션키를 로그인된 아이디값에 넣는다

        model.addAttribute("products", mystoreservice.product_listAll(productVO)); // 상품 테이블 읽어서 jsp로 보내기
        return "/mystore/products";
    }
    //------------------------------------------------------------------------------------------------------------------

    //------------------------------------------------------------------------------------------------------------------
    // 찜 페이지로 이동
    @RequestMapping(value = "/favorites", method = RequestMethod.GET)
    public String FavoritesGET(Model model, HttpServletRequest request, ProductVO productVO) throws Exception {
        Cookie[] cookies = request.getCookies();
        String sessionkey = "";
        if(cookies != null){
            for(int i=0; i < cookies.length; i++){
                Cookie cookie = cookies[i] ;
                // 저장된 쿠키 이름을 가져온다
                String cName = cookie.getName();
                if(cName.equals("loginCookie")){
                    sessionkey = cookie.getValue();
                    break;
                }
            }
        }
        productVO.setId(sessionkey); // 세션키를 로그인된 아이디값에 넣는다

        model.addAttribute("products", mystoreservice.favorites_listAll(productVO)); // 상품 테이블 읽어서 jsp로 보내기
        return "/mystore/favorites";
    }
    //------------------------------------------------------------------------------------------------------------------

    // ------------------------------------------------------------------------------------------------------------------
    // 상점문의 페이지로 이동
    @RequestMapping(value = "/storeQa", method = RequestMethod.GET)
    public String storeQaGET(Model model, HttpServletRequest request, StoreQaVO storeQaVO) throws Exception {
        Cookie[] cookies = request.getCookies();
        String sessionkey = "";
        if(cookies != null){
            for(int i=0; i < cookies.length; i++){
                Cookie cookie = cookies[i] ;
                // 저장된 쿠키 이름을 가져온다
                String cName = cookie.getName();
                if(cName.equals("loginCookie")){
                    sessionkey = cookie.getValue();
                    break;
                }
            }
        }
        storeQaVO.setLoginId(sessionkey); // 세션키를 로그인된 아이디값에 넣는다


        model.addAttribute("storeQa", mystoreservice.storeQa_listAll(storeQaVO)); // 상점문의 테이블 읽어서 jsp로 보내기
        return "/mystore/storeQa";
    }

    // 상점문의 페이지 추가
    @RequestMapping(value = "/storeQaInsert", method = RequestMethod.POST)
    public String storeQaInsertPOST(StoreQaVO storeQaVO, HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        Cookie[] cookies = request.getCookies();
        String sessionkey = "";
        if(cookies != null){
            for(int i=0; i < cookies.length; i++){
                Cookie cookie = cookies[i] ;
                // 저장된 쿠키 이름을 가져온다
                String cName = cookie.getName();
                if(cName.equals("loginCookie")){
                    sessionkey = cookie.getValue();
                    break;
                }
            }
        }
        storeQaVO.setLoginId(sessionkey); // 세션키를 로그인된 아이디값에 넣는다


        mystoreservice.storeQaAddReply(storeQaVO); // 상점문의 테이블 insert처리
        return "redirect:/mystore/storeQa";
    }

    // 상점문의 페이지 삭제
    @RequestMapping(value = "/storeQaDelete", method = RequestMethod.POST)
    public String storeQaDeletePOST(StoreQaVO storeQaVO, RedirectAttributes redirectAttributes) throws Exception {
        mystoreservice.storeQaDelete(storeQaVO); // 상점문의 테이블 delete처리리

        return "redirect:/mystore/storeQa";
    }
    //------------------------------------------------------------------------------------------------------------------

    //------------------------------------------------------------------------------------------------------------------
    // 팔로워 페이지로 이동
    @RequestMapping(value = "/follower", method = RequestMethod.GET)
    public String followerGET(Model model, HttpServletRequest request, FollowerVO followerVO) throws Exception {

        Cookie[] cookies = request.getCookies();
        String sessionkey = "";
        if(cookies != null){
            for(int i=0; i < cookies.length; i++){
                Cookie cookie = cookies[i] ;
                // 저장된 쿠키 이름을 가져온다
                String cName = cookie.getName();
                if(cName.equals("loginCookie")){ // JSESSIONID
                    sessionkey = cookie.getValue();
                    break;
                }
            }
        }
        followerVO.setLoginId(sessionkey); // 세션키를 로그인된 아이디값에 넣는다
        List<FollowerVO> followerVOList = mystoreservice.follower_listAll(followerVO); // 직접 VO에 값넣기
        model.addAttribute("follower", followerVOList); // 팔로워 테이블 읽기 (jsp로 값만 넘기고 실제로 VO에 값은 넣지않음)

        return "/mystore/follower";
    }
    //------------------------------------------------------------------------------------------------------------------

    //------------------------------------------------------------------------------------------------------------------
    // 팔로잉 페이지로 이동
    @RequestMapping(value = "/following", method = RequestMethod.GET)
    public String followingGET(Model model, HttpServletRequest request, FollowingVO followingVO) throws Exception {
        Cookie[] cookies = request.getCookies();
        String sessionkey = "";
        if(cookies != null){
            for(int i=0; i < cookies.length; i++){
                Cookie cookie = cookies[i] ;
                // 저장된 쿠키 이름을 가져온다
                String cName = cookie.getName();
                if(cName.equals("loginCookie")){
                    sessionkey = cookie.getValue();
                    break;
                }
            }
        }
        followingVO.setLoginId(sessionkey); // 세션키를 로그인된 아이디값에 넣는다
        List<FollowingVO> followingVOList = mystoreservice.following_listAll(followingVO); // 직접 VO에 값넣기
        model.addAttribute("following", followingVOList); // 팔로잉 테이블 읽기 (jsp로 값만 넘기고 실제로 VO에 값은 넣지않음)

        return "/mystore/following";
    }

    //------------------------------------------------------------------------------------------------------------------
}
