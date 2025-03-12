package com.projectx.foundit.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileUserDto {

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
