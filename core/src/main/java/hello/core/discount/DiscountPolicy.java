package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {
    /*
    *
    * @return discount applied price
    * */
    //testing
    int discount(Member member, int price);
}
