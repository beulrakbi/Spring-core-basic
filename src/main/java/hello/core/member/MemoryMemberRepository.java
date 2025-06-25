package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    //store를 통해서 Member를 찾기 위함
    private static Map<Long, Member> store = new HashMap<>();

    //store에 put 메소드를 이용해 get을 이용해 가져온 member를 넣어준다.
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    //member의 정보가 저장된 store에서 get 메소드를 이용해 memberId를 조회한다.
    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
