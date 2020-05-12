package config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.googlecode.objectify.ObjectifyService;

import model.*;


public class AppConfig implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent event) {
		ObjectifyService.init();
        ObjectifyService.register(User.class);
	                
	    //System.out.println("debug output content initialization");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		//System.out.println("content destroyed");
		
	}
}

