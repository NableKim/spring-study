package hello.itemservice.domain.item;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * FAST : 빠른배송
 * NORMAL : 일반배송
 * SLOW : 느린배송
 */

@Data
@AllArgsConstructor
public class DeliveryCode {
    private String Code;        // 서버 측에 보낼 때 사용할 값
    private String DisplayName; // 고객에게 보여줄 값
}
