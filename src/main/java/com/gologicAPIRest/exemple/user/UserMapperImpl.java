package com.gologicAPIRest.exemple.user;

import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper{
    @Override
    public UserResource populateResource(User user){
        UserResource userResource = new UserResource();
        userResource.setId(user.getId());
        userResource.setName(user.getName());
        userResource.setEmail(user.getEmail());
        userResource.setPhone(user.getPhone());
        userResource.setCredit(user.getCredit());
        return userResource;
    }
}
