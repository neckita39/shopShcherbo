package com.shcherbo.shop.orders;


import com.shcherbo.shop.purchase.PurchaseEntity;
import com.shcherbo.shop.rest.dto.statuses.Delivery;
import com.shcherbo.shop.rest.dto.statuses.OrderStatus;
import com.shcherbo.shop.rest.dto.statuses.Payment;
import com.shcherbo.shop.users.UserEntity;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "ORDERINFO")
public class OrderEntity {
    @Setter(AccessLevel.PROTECTED)
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;



    @Setter(AccessLevel.PROTECTED)
    @ToString.Exclude
    @ManyToOne()
    private UserEntity user;

    @Setter(AccessLevel.PROTECTED)
    @ToString.Exclude
    @OneToMany(mappedBy = "order",fetch = FetchType.LAZY,
            orphanRemoval = true, cascade = CascadeType.ALL)
    private List<PurchaseEntity> purchase;

    @Setter(AccessLevel.PROTECTED)
    private Delivery delivery;

    @Setter(AccessLevel.PROTECTED)
    private OrderStatus status;

    @Setter(AccessLevel.PROTECTED)
    private Payment payment;

    @Setter(AccessLevel.PROTECTED)
    private String deliveryAddress;

    @Setter(AccessLevel.PROTECTED)
    private LocalDateTime deliveryTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OrderEntity that = (OrderEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
