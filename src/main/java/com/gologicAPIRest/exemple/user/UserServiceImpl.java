package com.gologicAPIRest.exemple.user;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserResource create(UserResource userResource){
        User addedUser = new User() ;
        addedUser.setName(userResource.getName());
        addedUser.setEmail(userResource.getEmail());
        addedUser.setPhone(userResource.getPhone());
        addedUser.setCredit(userResource.getCredit());

        userRepository.save(addedUser);
        return userMapper.populateResource(addedUser);
    }

    @Override
    public UserResource update(Long id, UserResource userResource){
        User userbyId = userRepository.getOne(id);
        userbyId.setName(userResource.getName());
        userbyId.setEmail(userResource.getEmail());
        userbyId.setPhone(userResource.getPhone());
        userbyId.setCredit(userResource.getCredit());
        userRepository.save(userbyId);
        return userMapper.populateResource(userbyId);
    }
    @Override
    public UserResource patch(Long id, UserResource userResource){
        User userById = userRepository.getOne(id);
        if(userResource.getName() != null){
            userById.setName(userResource.getName());
        }
        if (userResource.getEmail() != null){
            userById.setEmail(userResource.getEmail());
        }
        if (userResource.getPhone() != null){
            userById.setPhone(userResource.getPhone());
        }
        if (userResource.getCredit() != null){
            userById.setCredit(userResource.getCredit());
        }
        userRepository.save(userById);
        return userMapper.populateResource(userById);
    }

    @Override
    public UserResource get(Long id){ return userMapper.populateResource(userRepository.getOne(id)); }

    @Override
    public UserResource delete(Long id){
        UserResource userResourceDeleted = get(id);
        userRepository.deleteById(id);
        return userResourceDeleted;
    }

    @Override
    public List<UserResource> listeUsers(){
        List<UserResource> liste = new ArrayList<>();
        List<User> listeEntity =  userRepository.findAll();
        for (User user : listeEntity){
            liste.add(userMapper.populateResource(user));
        }
        return liste;
    }

}

