package hello.core.member;

public interface MemberRepository {
    /*
    * 인터페이스로 기능을 구현한다.*/

    //회원 정보를 저장
    void save(Member member);

    //memberId를 통해서 아이디를 찾는다.
    Member findById(Long memberId);
}
