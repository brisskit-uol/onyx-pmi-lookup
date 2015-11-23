package org.brisskit.pmi.utils;

import org.junit.Before;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
/**
 * This class creates the basic setup for end-to-end (i.e. integration) testing
 * of controllers and their defined URIs w/o having to deploy them to any 
 * web container.
 *  
 * @author Roland Nelson
 *
 */
public abstract class BaseWebApplicationContext implements ApplicationContextAware {
		
	// this servlet is going to be instantiated by ourselves
	// so that we can test the servlet behaviour w/o actual web container
	// deployment
	protected DispatcherServlet servlet;

	
	// we need to get at the context already loaded via the
	// @ContextConfiguration annotation.
	// implementing the marker-interface
	// ApplicationContextAware#setApplicationContext will
	// allow us to reference this parent context 
	protected ApplicationContext appCtx;
	
	/*
	 * (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	@Autowired
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		appCtx = applicationContext;
	}

	/**
	 * using @Before is convenient, but with JUnit these annotated methods must be public (not like e.g. testNG)
	 * so be aware that no "secrets" are being set/got in these init-style methods ;_)! !
	 */
	@Before
	public void initDispatcherServlet() {
		servlet = new DispatcherServlet() {

			/**
			 * useless, but added so that eclipse doesn't annoy me....
			 */
			private static final long serialVersionUID = 4775400697981209825L;

			@Override
			protected WebApplicationContext createWebApplicationContext( WebApplicationContext parent) throws BeansException {

				GenericWebApplicationContext gwac = new GenericWebApplicationContext();
				gwac.setParent(appCtx);
				gwac.refresh();
				return gwac;
			}
		};
		
	}
}
