package com.fb.log;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Servlet implementation class LoggerInitializer
 */
public class LoggerInitializer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger LOG = Logger.getLogger(LoggerInitializer.class);

    /**
     * Default constructor. 
     */
    public LoggerInitializer() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		ServletContext context = config.getServletContext();
		String path = context.getRealPath("/");
		
		String logPropFile = path + "WEB-INF\\log4j.properties";
		PropertyConfigurator.configure(logPropFile);
		LOG.info("Application Initialized");
				
	}

}
