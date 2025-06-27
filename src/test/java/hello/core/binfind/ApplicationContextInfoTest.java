package hello.core.binfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    //자바 설정 클래스를 읽어서 스프링 컨테이너를 생성하는 클래스
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); //현재 스프링 컨테이너에 등록된 모든 빈 이름을 문자열로 배열로 반환
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName); //해당 이름을 가진 빈을 실제 객체로 조회
            System.out.println("beanDefinitionName = " + beanDefinitionName + "object = " + bean);
        }
    }

    //스프링이 자동으로 등록한 내부 빈은 제외하고, 개발자가 직접 등록한 빈만 출력한다.
    @Test
    @DisplayName("애플리케이션 빈 출력")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName); //빈 정의 정보 가져오기

            /* beanDefinition.getRole() : 스프링의 역할에 나타냄
            Role_Application : 개발자가 직접 등록한 빈
            Role_INFRASTRUCTURE : 스프링 내부에서 사용하는 빈*/
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){ //오풀라캐아숀 등록 빈만 필터링
                Object bean = ac.getBean(beanDefinitionName); //빈 객체 조회
                System.out.println("beanDefinitionName = " + beanDefinitionName + "object = " + bean);
            }
        }
    }
}
