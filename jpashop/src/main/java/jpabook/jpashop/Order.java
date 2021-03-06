package jpabook.jpashop;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
@Getter @Setter
public class Order {

    @Id @GeneratedValue
    @Column(name="order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;  // 주문자 정보

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>(); // 주문 목록

    @OneToOne
    @JoinColumn(name="delivery_id")
    private Delivery delivery;          // 배송 정보

    private LocalDateTime orderDate;    // 주문 시간

    @Enumerated(EnumType.STRING)
    private OrderStatus status;    // 주문 상태
}
