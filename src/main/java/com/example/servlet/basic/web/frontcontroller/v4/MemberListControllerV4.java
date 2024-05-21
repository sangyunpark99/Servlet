package com.example.servlet.basic.web.frontcontroller.v4;

import com.example.servlet.basic.domain.Member;
import com.example.servlet.basic.repository.MemberRepository;
import java.util.List;
import java.util.Map;

public class MemberListControllerV4 implements ControllerV4{

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        List<Member> members = memberRepository.findAll();
        model.put("members", members);

        return "members";
    }
}
