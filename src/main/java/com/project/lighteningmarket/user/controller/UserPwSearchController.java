package com.project.lighteningmarket.user.controller;

import com.project.lighteningmarket.user.domain.UserSearchDTO;
import com.project.lighteningmarket.user.domain.UserVO;
import com.project.lighteningmarket.user.service.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.Random;

@Controller
@RequestMapping("/login")
public class UserPwSearchController {

    private final UserService userService;

    @Inject
    public UserPwSearchController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private JavaMailSenderImpl mailSender;

    // 비밀번호 찾기 페이지
    @RequestMapping(value = "/pwSearch", method = RequestMethod.GET)
    public String pwSearchGET(@ModelAttribute("UserSearchDTO") UserSearchDTO userSearchDTO) {
        return "login/pwSearch";
    }

    // 비밀번호 찾기 (1. 이메일 발송)
    @RequestMapping(value = "/pwCheck", method = RequestMethod.POST)
    public ModelAndView pwSearchPOST(UserSearchDTO userSearchDTO, String id, String email, HttpServletRequest request) throws Exception {

        ModelAndView mv = new ModelAndView();    // ModelAndView로 보낼 페이지를 지정하고, 보낼 값을 지정한다.
        mv.setViewName("/login/pwCheck");    // 인증번호 view

        // email 일치하는 사용자 mapping
        UserVO userVO = userService.emaildice(userSearchDTO);

        System.out.println(userVO);

        // email이 일치하는 사용자
        if (userVO.getEmail().equals(userSearchDTO.getEmail())) {

            Random random = new Random();
            int dice = random.nextInt(157211) + 48271;

            String setfrom = "dtc13579@gmail.com";  // 보내는 사람
            String tomail = request.getParameter("email");  // 받는 사람
            String title = "[번개장터] 비밀번호 찾기 인증 이메일 입니다.";    // 제목
            // 내용
            String content =
                    System.getProperty("line.separator") +
                            System.getProperty("line.separator") +
                            "안녕하세요 회원님. 저희 홈페이지를 찾아주셔서 감사합니다." +
                            System.getProperty("line.separator") +
                            System.getProperty("line.separator") +
                            "비밀번호 찾기 인증번호는 " + dice + "입니다." +
                            System.getProperty("line.separator") +
                            System.getProperty("line.separator") +
                            "받으신 인증번호를 홈페이지에 입력해주세요.";

            try {

                MimeMessage message = mailSender.createMimeMessage();
                MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

                messageHelper.setFrom(setfrom); // 보내는사람 생략하면 정상작동을 안함
                messageHelper.setTo(tomail); // 받는사람 이메일
                messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
                messageHelper.setText(content); // 메일 내용

                mailSender.send(message);

            } catch (Exception e) {
                System.out.println(e);
            }

            mv.addObject("id", id);
            mv.addObject("email", email);
            mv.addObject("dice", dice);
        }
        // email이 일치하지 않은 사용자
        else {
            mv.addObject("dice", "NOEMAIL");
        }

        System.out.println("pwCheck mv : " + mv);

        return mv;
    }

    // 비밀번호 찾기 (2. 인증번호 일치 시, 비밀번호 수정 페이지로 넘어가기)
    @RequestMapping(value = "/pwChange", method = RequestMethod.POST)
    public ModelAndView correctdicePost(String requestdice, String id, String email, String dice) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/login/pwChange");

        if(requestdice.equals(dice)) {
            mv.addObject("id", id);
            mv.addObject("email", email);
            mv.addObject("result", "SAMEDICE");
        }
        else {
            mv.addObject("result", "DIFFERENTDICE");
        }

        System.out.println("pwChange mv : " + mv);

        return mv;
    }

    // 비밀번호 찾기 (3. 인증번호 확인된 회원 비밀번호 수정)
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String pwchangePost(UserVO userVO, RedirectAttributes redirectAttributes) throws Exception {

        String changePw = BCrypt.hashpw(userVO.getPassword(), BCrypt.gensalt());
        userVO.setPassword(changePw);
        userService.pwchange(userVO);
        redirectAttributes.addFlashAttribute("msg", "UPDATEPW");

        return "redirect:/login/login";
    }
}
