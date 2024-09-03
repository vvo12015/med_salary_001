package net.vrakin.med_salary.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "security_user")
public class SecurityUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;
    private String password;

    @Enumerated(EnumType.STRING)
    private SecurityRole securityRole;

    private String email;
    private String phone;
    private String address;

    public SecurityUser(String login, String password,
                        SecurityRole securityRole, String email,
                        String phone, String address) {
        this.login = login;
        this.password = password;
        this.securityRole = securityRole;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
}
