package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{
    /*
    * 기획자가 할인을 1000원 고정으로 하지 않고
    * 10퍼센트로 변경하였을 때
    * 새로운 클래스를 만들어주기만 하면 된다.
    * 기존의 클래스를 수정할 필요 없음
    *
    * 코드를 작성하고 로직을 의심하기!
    * 테스트 코드를 통해 제대로 작동하는지 확인
    * command + T + shift 하면 테스트 파일을 만들어준다.*/
    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountPercent /100;
        } else {
            return 0;
        }
    }
}
