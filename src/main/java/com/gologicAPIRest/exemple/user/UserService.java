package com.gologicAPIRest.exemple.user;

public interface UserService {

	public UserResource create(UserResource userResource);
	
    public UserResource update(Long id, UserResource userResource) ;
    
    public UserResource patch(Long id,UserResource userResource);
    
    public UserResource get(Long id);
    
    public UserResource delete(Long id);
    
}
