package net.vrakin.med_salary.domain;

import jakarta.persistence.*;
import lombok.*;

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

    @Column
    private String userPositionCodeIdPro;

    @Column
    private Integer maxPoint;

    @Column
    private Float pointValue;

    @Override
    public String toString() {
        return "UserPosition{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userIsProId='" + userPositionCodeIdPro + '\'' +
                '}';
    }
}
