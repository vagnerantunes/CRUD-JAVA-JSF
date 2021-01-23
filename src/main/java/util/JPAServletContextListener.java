package util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class JPAServletContextListener implements ServletContextListener{
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		JPAUtil.getEntityManager();
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		JPAUtil.close();
	}
	
}
