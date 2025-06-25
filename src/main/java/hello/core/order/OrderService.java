package hello.core.order;

public interface OrderService {

    /*
    * 서비스에서 주문을 등록하는 기능을 정의했다.*/
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
