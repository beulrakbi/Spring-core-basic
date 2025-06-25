package hello.core.member;


public class MemberServiceImpl implements MemberService{

    /*
    * Service는 결국 비즈니스 로직만을 다루기 때문에
    * CRUD를 다루는 memberRepository와 연결 */
    private  MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
