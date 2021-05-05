package hello.core;

import hello.core.Order.OrderService;
import hello.core.Order.OrderServiceImpl;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;

public class AppConfig {
    //implementation
    public MemberService memberService(){
        //constructor injection to follow the policy
        return new MemberServiceImpl(memberRepository());
    }

    //roles
    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    //implementation
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    //roles
    public DiscountPolicy discountPolicy(){
        //rate discount policy
        return new RateDiscountPolicy();
        //fix disciount policy
        //return new FixDiscountPolicy();
    }
}
