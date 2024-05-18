package com.example.servlet.basic.web.frontcontroller.v3;

import com.example.servlet.basic.domain.Member;
import com.example.servlet.basic.repository.MemberRepository;
import com.example.servlet.basic.web.frontcontroller.ModelView;
import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3{

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username,age);
        memberRepository.save(member);

        ModelView mv = new ModelView("save-result");
        mv.getModel().put("member",member);
        return mv;
    }
}