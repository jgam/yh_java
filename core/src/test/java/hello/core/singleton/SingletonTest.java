package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.asserts.Assertion;

public class SingletonTest {

    @Test
    @DisplayName("pure DI container without spring")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();

        //1. access: create object when gets called
        MemberService memberService1 = appConfig.memberService();

        //2 access: create object whenever gets called
        MemberService memberService2 = appConfig.memberService();

        //check the references
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //memberService1 !== memberService2
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);

        //as you could see all the objects are created everytime we request for it when calling allConfig.memberService()
    }

    @Test
    @DisplayName("Spring Container and songleton")
    void springContainer(){
//        AppConfig appConfig = new AppConfig();

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        //1. access: create object when gets called
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);

        //2 access: create object whenever gets called
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        //check the references
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //memberService1 !== memberService2
        Assertions.assertThat(memberService1).isSameAs(memberService2);

        //as you could see all the objects are created everytime we request for it when calling allConfig.memberService()
    }
}
