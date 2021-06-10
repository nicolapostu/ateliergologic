package com.gologicAPIRest.exemple.user;

import java.util.List;

public interface UserService {

	public UserResource create(UserResource userResource);
	
    public UserResource update(Long id, UserResource userResource) ;
    
    public UserResource patch(Long id,String field, String value);
    
    public UserResource get(Long id);
    
    public UserResource delete(Long id);

    public List<UserResource> listeUsers();
    
}
