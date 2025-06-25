package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{
    //할인금액을 미리 정의해둔다. -> 1000원
    private int discountFixAmount = 1000; //천원 할인

    /*할인 메서드 정의
    * member의 등급이 VIP이면
    * 1000원 할인을 return한다.*/
    @Override
    public int discount(Member member, int price) {
        if( member.getGrade() == Grade.VIP){
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
