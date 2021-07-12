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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//APP cglib that checks if repos were created beforehand or not, this results in that using@bean guarantees the spring beans
//howveer, it  does not guarantee the singleton pattern
@Configuration
public class AppConfig {
    //implementation
    @Bean
    public MemberService memberService(){
        //constructor injection to follow the policy
        return new MemberServiceImpl(memberRepository());
    }

    //roles
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    //implementation
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    //roles
    @Bean
    public DiscountPolicy discountPolicy(){
        //rate discount policy
        return new RateDiscountPolicy();
        //fix disciount policy
        //return new FixDiscountPolicy();
    }
}
