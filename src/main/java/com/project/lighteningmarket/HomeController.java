package com.project.lighteningmarket;

import com.project.lighteningmarket.products.service.ProductsService;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ProductsService productService;

    @RequestMapping("/")
    public ModelAndView home(Model model, ModelAndView mav) throws Exception {
        model.addAttribute("greeting", "hello world");
        mav.setViewName("home/home");
        mav.addObject("list", productService.listProduct());

        return mav;
    }

    @RequestMapping(value = "search.do", method = RequestMethod.GET)
    public ModelAndView search(@RequestParam String searchData, ModelAndView mav) throws Exception {
        System.out.println(searchData);
        mav.setViewName("/search/searchResult");
        mav.addObject("list", productService.searchProduct(searchData));

        return mav;
    }

/*    @RequestMapping("/login/login")
    public void login( ) {
    }

    @RequestMapping("/product/productRegister")
    public void productsUpload( ) {
    }*/
}
