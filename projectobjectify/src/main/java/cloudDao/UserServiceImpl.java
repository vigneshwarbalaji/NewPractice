package cloudDao;

import com.googlecode.objectify.ObjectifyService;

import model.User;



public class UserServiceImpl implements UserService
{
	
	
	
   	
	public boolean createUser(User user)
	{
		user.setId(4687864534564564L);
		System.out.println(user.getName()+" "+user.getMail());
        ObjectifyService.ofy().save().entity(user).now();
        return true;
	}
}
