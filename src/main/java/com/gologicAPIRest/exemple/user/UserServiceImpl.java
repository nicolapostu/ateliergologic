package com.gologicAPIRest.exemple.user;

import javax.transaction.Transactional;

import com.sun.jdi.IntegerValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repo;

    public User create(User user){
        return repo.save(user);
    }

    public User update(Long id, User user){
        User userbyId = repo.getOne(id);
        userbyId.setName(user.getName());
        userbyId.setEmail(user.getEmail());
        userbyId.setPhone(user.getPhone());
        userbyId.setCredit(user.getCredit());
        return repo.save(userbyId);
    }
    public User patch(Long id, String field, String value){
        User userById = repo.getOne(id);
        switch(field) {
            case "name":
                userById.setName(value);
            	break;
            case "email":
                userById.setEmail(value);
                break;
            case "phone":
                userById.setPhone(value);
                break;
            case "credit":
                userById.setCredit(Integer.parseInt(value));
                break;
        }
        return repo.save(userById);
    }

    public User get(Long id){
        return repo.findById(id).get();
    }

    public void delete(Long id){
        repo.deleteById(id);
    }
}

