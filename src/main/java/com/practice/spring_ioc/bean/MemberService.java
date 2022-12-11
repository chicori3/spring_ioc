package com.practice.spring_ioc.bean;

public class MemberService {
    public MemberRepository memberRepository;

    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
}
