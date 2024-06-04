package com.example.servlet.basic.web.springmvc.v1;

import com.example.servlet.basic.domain.Member;
import com.example.servlet.basic.repository.MemberRepository;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class SpringMemberListControllerV1 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/springmvc/v1/members")
    public ModelAndView process() {
        List<Member> members = memberRepository.findAll();

        ModelAndView mv = new ModelAndView("members");

        mv.addObject("members", members);

        return mv;
    }
}
