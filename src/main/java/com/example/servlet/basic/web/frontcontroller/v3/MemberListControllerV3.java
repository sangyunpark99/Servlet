package com.example.servlet.basic.web.frontcontroller.v3;

import com.example.servlet.basic.domain.Member;
import com.example.servlet.basic.repository.MemberRepository;
import com.example.servlet.basic.web.frontcontroller.ModelView;
import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3{

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        List<Member> members = memberRepository.findAll();
        ModelView mv = new ModelView("members");
        mv.getModel().put("members", members);

        return mv;
    }
}
