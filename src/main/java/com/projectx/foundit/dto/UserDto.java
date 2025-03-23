package com.projectx.foundit.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDto {

    private String username;
    private String email;
    private String address1;
    private String address2;
    private String pobox;
    private String city;
    private String province;
    private String country;
    private String gender;
    private Integer phoneno;
}
