package org.rafael.cachespike.util;

import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ServiceLocator {

	private static final String EAR_NAME = "cachespike/";

	@SuppressWarnings("rawtypes")
	public static Object lookupLocal(Class serviceClazz) {
		try {
			Properties properties = new Properties();  
			properties.put("java.naming.factory.initial","org.jnp.interfaces.NamingContextFactory");  
			properties.put("java.naming.factory.url.pkgs","=org.jboss.naming:org.jnp.interfaces");  
			properties.put("java.naming.provider.url","localhost:1099");  
			InitialContext ctx = new InitialContext(properties);
			return ctx.lookup(EAR_NAME + serviceClazz.getSimpleName() + "/local");
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}
}
