package com.gologicAPIRest.exemple.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResource {

        private Long id;

        private String name;

        private String email;

        private String phone;

        private Integer credit;
}
