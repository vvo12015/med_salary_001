package net.vrakin.med_salary.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name="user_position_user")
public class StaffList {
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
        return "StaffList{" +
                "id=" + id +
                ", username=" + user.getName() +
                ", userPositionName=" + userPosition.getName() +
                ", employment=" + employment +
                '}';
    }
}
