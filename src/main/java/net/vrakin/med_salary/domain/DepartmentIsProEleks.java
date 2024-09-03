package net.vrakin.med_salary.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "department_ispro_eleks")
public class DepartmentIsProEleks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nameIsPro;

    @Override
    public String toString() {
        return "DepartmentIsPro{" +
                "id=" + id +
                ", name='" + nameIsPro + '\'' +
                '}';
    }
}
