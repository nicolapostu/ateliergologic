package com.gologicAPIRest.exemple.user;

public interface UserService {

	public User create(User user);
	
    public User update(Long id, User user);
    
    public User patch(Long id,String field , String value);
    
    public User get(Long id);
    
    public void delete(Long id);
    
}
