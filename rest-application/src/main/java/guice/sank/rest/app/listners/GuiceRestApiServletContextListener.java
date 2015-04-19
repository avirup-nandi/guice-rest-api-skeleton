package guice.sank.rest.app.listners;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Stage;
import com.google.inject.servlet.GuiceServletContextListener;
import guice.sank.rest.app.di.GuiceRestApiContext;

import java.util.List;

public class GuiceRestApiServletContextListener extends GuiceServletContextListener {

	final Injector injector;

	GuiceRestApiServletContextListener() {
		injector = createInjectors();
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}

	private Injector createInjectors() {
		return Guice.createInjector(Stage.PRODUCTION, getModules());
	}

	private Module[] getModules() {
		try {
			String applicationContext = System.getProperty("");
			List<Module> modules = Class.forName(applicationContext).asSubclass(GuiceRestApiContext.class).newInstance().getModules();
			return modules.toArray(new Module[modules.size()]);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new RuntimeException(e.getCause());
		}
	}
}
