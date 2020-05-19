package com.org.dao;

import com.googlecode.objectify.ObjectifyService;
import com.org.model.UserAccounts;




public class UserServiceImpl implements UserService
{
	
	public boolean createUserAcc(UserAccounts users)
	{
		UserAccounts existingUser = getUserByMail(users.getEmail());
		String existingMail = existingUser.getEmail();
			//System.out.println(users.getName()+" "+user.getMail());
		if(users.getEmail() != existingMail)
		{
			   ObjectifyService.ofy().save().entity(users);
		        return true;
		}
		return false;
	     
	}
	
	public UserAccounts getUserByMail(String email)
	{
        UserAccounts existingUser=ObjectifyService.ofy().load().type(UserAccounts.class).filter("email",email).first().now();
        
        //System.out.println(user.getName());
        return existingUser;
	}
}
