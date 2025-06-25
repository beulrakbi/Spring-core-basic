package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    /*
    * member 객체가 필요하기 때문에
    * memberRepository에서 아이디를 통해 찾을 수 있게
    * 객체 생성을 해줬다.
    * 미리 정의해둔 할인 금액을 적용하기 위해 할인쪽도 객체를 생성했다.*/

    private MemberRepository memberRepository;
    //인터페이스만 의존하게 변경하기
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    /*
    * 회원 Id를 먼저 조회하고
    * FixDiscountPolicy에서 설정한대로 등급을 조회하고 등급에 맞게 할인율을 등록한다.*/
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        //주문 목록에 값이 들어가게 해서 return한다.
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
