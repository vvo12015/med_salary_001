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
@Table(name = "user_position")
public class UserPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true, nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user_position_user")
    List<UserPositionUser> userPositionUserList;

    @Override
    public String toString() {
        return "UserPosition{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
