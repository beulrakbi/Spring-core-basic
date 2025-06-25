package hello.core.member;

public interface MemberService {
    /* MemberService는 기능을 정의해놓은 interface
    * 기능만 정의해두고 class를 따로 만들어서 기능에 대한 구현을 작성한다.
    * 1. 역할을 분리한다. 인터페이스 -> 무엇을 구현체 -> 어떻게
    * 2. 구현 변경/확장이 자유로움
    * 3. 가짜 구현을 끼워넣기 쉬움
    * 4. 클라이언트가 구현이 아닌 인터페이스에만 의존하게 됨*/

    //회원가입
    void join(Member member);
    //조회
    Member findMember(Long memberId);
}
