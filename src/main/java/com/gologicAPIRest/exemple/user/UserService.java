package com.gologicAPIRest.exemple.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public void save(User user){
        repo.save(user);
    }

    public User update(Long id, User user){
        User userbyId = repo.getOne(id);
        userbyId.setName(user.getName());
        userbyId.setEmail(user.getEmail());
        userbyId.setPhone(user.getPhone());
        userbyId.setCredit(user.getCredit());
        return repo.save(userbyId);
    }
    public User patch(Long id, Integer val){
        User userbyId = repo.getOne(id);
        userbyId.setCredit(val);
        return repo.save(userbyId);
    }

    public User get(Long id){
        return repo.findById(id).get();
    }

    public void delete(Long id){
        repo.deleteById(id);
    }
}

