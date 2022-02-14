package com.project.lighteningmarket.user.controller;

import com.project.lighteningmarket.user.domain.UserSearchDTO;
import com.project.lighteningmarket.user.domain.UserVO;
import com.project.lighteningmarket.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class UserIdSearchController {

    private final UserService userService;

    @Inject
    public UserIdSearchController(UserService userService) {
        this.userService = userService;
    }

    // 아이디 찾기 페이지
    @RequestMapping(value = "/idSearch", method = RequestMethod.GET)
    public String idSearchGET(@ModelAttribute("UserSearchDTO") UserSearchDTO userSearchDTO) {
        return "login/idSearch";
    }


    // 아이디 찾기
    @RequestMapping(value = "/idSearch", method = RequestMethod.POST)
    public String idsearchPOST(UserSearchDTO userSearchDTO, RedirectAttributes redirectAttributes) throws Exception {
        Map<String, Object> map = new HashMap<String,Object>();
        // userSearchDTO 값 출력
        System.out.println(userSearchDTO.toString());
        // mapper에서 query 실행한 결과값 출력
        UserVO userVO = userService.idsearch(userSearchDTO);
        System.out.println(userVO);

        if(userVO.getEmail().equals(userSearchDTO.getEmail())) {
            map.put("msg", "IDSEARCH");
            map.put("id", userVO.getId());
            redirectAttributes.addFlashAttribute("map", map);
        }
        else {
            map.put("msg", "NOID");
            redirectAttributes.addFlashAttribute("map", map);
        }

        return "redirect:/login/idSearch";
    }
}
