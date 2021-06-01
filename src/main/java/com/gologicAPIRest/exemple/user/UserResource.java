package com.gologicAPIRest.exemple.user;

import lombok.Data;

@Data
public class UserResource {

        private String name;

        private String email;

        private String phone;

        private Integer credit;
}
