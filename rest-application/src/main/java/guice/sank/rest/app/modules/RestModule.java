package guice.sank.rest.app.modules;

import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import com.sun.jersey.spi.container.servlet.ServletContainer;
import guice.sank.rest.app.filters.JerseyRestApplication;

import java.util.HashMap;
import java.util.Map;

public class RestModule extends ServletModule {

	@Override
	public void configureServlets() {
		serve("*").with(GuiceContainer.class, getApplicationMap());
	}

	private Map<String, String> getApplicationMap() {
		return new HashMap<String, String>(){{
			put(ServletContainer.APPLICATION_CONFIG_CLASS, getRestApplicationName());
		}};
	}

	protected String getRestApplicationName() {
		return JerseyRestApplication.class.getName();
	}
}