package com.mudo.jackson;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class JacksonFilterContext {

	private Set<String> includeProperties = new HashSet<String>();
	private Set<String> excludeProperties = new HashSet<String>(Arrays.asList("hibernate_lazy_initializer", "handler"));

	public void includeProperty(String... propertyNames) {
		for (String propertyName : propertyNames) {
			includeProperties.add(propertyName);
		}
	}

	public void excludeProperty(String... propertyNames) {
		for (String propertyName : propertyNames) {
			excludeProperties.add(propertyName);
		}
	}

	public boolean isIncludedProperty(String propertyName) {
		return includeProperties.contains(propertyName);
	}

	public boolean isExcludedProperty(String propertyName) {
		return excludeProperties.contains(propertyName);
	}
}