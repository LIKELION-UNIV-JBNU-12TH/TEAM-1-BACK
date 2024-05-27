package com.example.likelion.login;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.Null;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Getter
@Setter
@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final LoginMapper LoginMapper;

    //로그인 폼 불러오기
    @GetMapping("/login")
    public String login() {

        return "/login";
    }

    //로그인 폼에서 사용자 id, password 받아온후 검증
    //검증 성공시 상품 리스트로, 실패시 다시 로그인 창으로 이동
    @PostMapping("/login")
    public String login(@ModelAttribute MemberInfo member) {

        String id = member.getMemberId();
        String password = member.getMemberPassword();

        //db에 저장된 password와 입력 받은 비밀번호가 같은지 비교
        if (password.equals(LoginMapper.findByPassword(id))) {

            log.info("로그인 성공");
            return "/index";

        } else {

            log.info("로그인 실패");
            return "redirect:/login";
        }
    }

    //회원가입 창 이동
    @GetMapping("/signUp")
    public String signUp() {
        return "/signup";
    }

    //회원가입 창에서 받아온 회원정보 저장 후 로그인 페이지로 이동
    @PostMapping("/signUp")
    public String signUp(@ModelAttribute MemberInfo member) {

        log.info("아아디 : " + member.getMemberId());
        log.info("비밀번호 : " + member.getMemberPassword());

        //만약 같은 아이디가 없다면 db에 회원 정보 저장
        if (LoginMapper.findByPassword(member.getMemberId()) == null) {
            LoginMapper.saveMemberInfo(member);
            log.info("사용할 수 있는 아이디");
            return "redirect:/login";
        }

        //같은 아이디가 있다면 다시 회원가입 창으로 이동
        else {
            log.info("사용할 수 없는 아이디");
            return "redirect:/signUp";
        }
    }
}
