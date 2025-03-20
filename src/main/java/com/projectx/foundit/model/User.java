package com.projectx.foundit.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private boolean enabled;

    @Column(name = "verification_code")
    private String verificationCode;

    @Column(name = "verification_code_expiry")
    private LocalDateTime verificationCodeExpiresAt;

    private String address1;

    private String address2;

    private String pobox;

    private String city;

    private String province;

    private String country;

    private String gender;

    private Integer phoneno;


    @OneToMany(mappedBy = "user")
    private List<Token> tokens;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public User(String username, String email, String address1, String address2, String pobox, String city, String province, String country, String gender, Integer phoneno) {
        this.username = username;
        this.email = email;
        this.address1 = address1;
        this.address2 = address2;
        this.pobox = pobox;
        this.city = city;
        this.province = province;
        this.country = country;
        this.gender = gender;
        this.phoneno = phoneno;
    }

    public User(int id, String username, String email, String address1, String address2, String pobox, String city, String province, String country, String gender, Integer phoneno) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.address1 = address1;
        this.address2 = address2;
        this.pobox = pobox;
        this.city = city;
        this.province = province;
        this.country = country;
        this.gender = gender;
        this.phoneno = phoneno;
    }

    public User() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
