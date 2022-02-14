package com.project.lighteningmarket.products.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.project.lighteningmarket.commons.category.domain.CategoryDTO;
import com.project.lighteningmarket.products.domain.ProductsVO;
import com.project.lighteningmarket.products.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
@RequestMapping("product/")
public class ProductsController {

    @Autowired
    private ProductsService productService;

    // 1. 상품 전체 목록
    @RequestMapping(value = "/productList", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView list(@RequestBody String param, ModelAndView mav) throws Exception {
        mav.setViewName("/product/productList");
        mav.addObject("list", productService.listProduct());
        return mav;
    }
    // 2. 상품 상세보기
    @RequestMapping("/detail/{productId}")
    public ModelAndView detail(@PathVariable("productId") int productId, ModelAndView mav) throws Exception {
        mav.setViewName("/product/productDetail");
        mav.addObject("vo", productService.detailProduct(productId));
        return mav;
    }

    // 3. 상품등록 처리 매핑
    @RequestMapping("insert.do")
    public String insert(ProductsVO vo, HttpServletRequest request) throws Exception {
        String filename = "";

        Cookie[] cookies = request.getCookies();
        String a = "";
        if(cookies != null){

            for(int i=0; i < cookies.length; i++){
                Cookie c = cookies[i] ;
                // 저장된 쿠키 이름을 가져온다
                String cName = c.getName();
                if(cName.equals("loginCookie")){
                    a = c.getValue();
                    break;
                }
            }
        }
        System.out.println("쿠키 값 : " + a);

        if(!vo.getProductPhoto().isEmpty()) {
            filename = vo.getProductPhoto().getOriginalFilename();
            // 개발디렉토리 - 파일 업로드 경로
            String path = "C:\\projects\\LighteningMarket_Project\\src\\main\\webapp\\resources\\upload\\img\\"; //
            try {
                new File(path).mkdirs(); // 디렉토리 생성
                // 임시디렉토리(서버)에 저장된 파일을 지정된 디렉토리로 전송
                vo.getProductPhoto().transferTo(new File(path+filename));
            } catch (Exception e) {
                e.printStackTrace();
            }
            vo.setProductUrl(filename);
            vo.setId(a);
            productService.insertProduct(vo);
        }
        System.out.println(vo);
        return "redirect:/product/productList";
    }
}