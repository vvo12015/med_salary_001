package net.vrakin.med_salary.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name="user_position_user")
public class UserPositionUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_position_id")
    private UserPosition userPosition;

    @Column
    private Float employment;

    @Override
    public String toString() {
        return "UserPositionUser{" +
                "id=" + id +
                ", username=" + user.getName() +
                ", userPositionName=" + userPosition.getName() +
                ", employment=" + employment +
                '}';
    }
}
