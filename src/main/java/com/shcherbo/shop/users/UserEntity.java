package com.shcherbo.shop.users;

import com.shcherbo.shop.orders.OrderEntity;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "USERINFO")
public class UserEntity {
    @Setter(AccessLevel.PROTECTED)
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;


    @Setter(AccessLevel.PROTECTED)
    @Column(name = "number", nullable = false, unique = true)
    @NaturalId(mutable = true)
    private String number;

    @Setter(AccessLevel.PROTECTED)
    @Column(name = "name")
    private String name;

    @Setter(AccessLevel.NONE)
    @ToString.Exclude
    @OneToMany()
    private List<OrderEntity> order=new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserEntity that = (UserEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
