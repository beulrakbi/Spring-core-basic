package hello.core.autowired;

import hello.core.AppConfig;
import hello.core.member.Member;
import io.micrometer.common.lang.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class AutowiredTest {
    /*
    * 스프링에서 의존성 주입 대상이 빈으로 등록되어 있지 않을 때 어떻게 처리할 수 있는지 테스트*/
    @Test
    void AutowiredOption(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean{
        /*Member는 주입한적이 없음
        * 아무것도 안나오는게 정상*/

        @Autowired(required = false) //주입할 빈이 없어도 아예 이 메서드를 호출하지 않음
        public void setNoBean1(Member member) {
            System.out.println("setNoBean1 = " + member);
        }
        //null 호출
        @Autowired
        public void setNoBean2(@Nullable Member member) { //nullable을 사용하면 빈이 없어도 메서드가 호출되고, 매개변수로 Null
            System.out.println("setNoBean2 = " + member);
        }
        //Optional.empty 호출
        @Autowired(required = false)
        public void setNoBean3(Optional<Member> member) { //빈이 없어도 메서드가 호출되고 Optional.empty가 들어옴
            System.out.println("setNoBean3 = " + member);
        }

    }
}
