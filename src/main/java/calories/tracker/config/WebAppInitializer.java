package calories.tracker.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.ServletContext;

import org.hdiv.filter.ValidatorFilter;
import org.hdiv.listener.InitListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import calories.tracker.config.root.AppSecurityConfig;
import calories.tracker.config.root.DevelopmentConfiguration;
import calories.tracker.config.root.HdivSecurityConfig;
import calories.tracker.config.root.RootContextConfig;
import calories.tracker.config.root.TestConfiguration;
import calories.tracker.config.servlet.ServletContextConfig;

/**
 *
 * Replacement for most of the content of web.xml, sets up the root and the servlet context config.
 *
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { RootContextConfig.class, DevelopmentConfiguration.class, TestConfiguration.class, AppSecurityConfig.class,
				HdivSecurityConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { ServletContextConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected void registerContextLoaderListener(final ServletContext servletContext) {
		super.registerContextLoaderListener(servletContext);

		servletContext.addListener(InitListener.class);
		servletContext.addListener(RequestContextListener.class);

		Dynamic dynamic = servletContext.addFilter("ValidatorFilter", ValidatorFilter.class);
		dynamic.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
		// dynamic.addMappingForServletNames(EnumSet.of(DispatcherType.REQUEST), true, "dispatcher");
	}

}
