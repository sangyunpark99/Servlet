package com.example.servlet.basic.web.springmvc.v3;

import com.example.servlet.basic.domain.Member;
import com.example.servlet.basic.repository.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();


    @GetMapping("/new-form")
    public String newForm() {
        return "new-form";
    }

    @PostMapping("/save")
    public String save(HttpServletRequest request, HttpServletResponse response, Model model) {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        System.out.println("member = " + member);
        memberRepository.save(member);

        model.addAttribute("member",member);

        return "save-result";
    }

    @GetMapping("/members")
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();

        ModelAndView mv = new ModelAndView("members");

        model.addAttribute("members", members);

        return "members";
    }
}
