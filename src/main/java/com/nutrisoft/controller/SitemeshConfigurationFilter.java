package com.nutrisoft.controller;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class SitemeshConfigurationFilter extends ConfigurableSiteMeshFilter {

	@Override
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
		builder
			.addDecoratorPath("/*", "/WEB-INF/views/decorator.jsp")
			.addExcludedPath("*.json")
			.addExcludedPath("*.xml")
			.addExcludedPath("*.js")
			.addExcludedPath("*.png")
			.addExcludedPath("*.gif")
			.addExcludedPath("*.jpg")
			.addExcludedPath("*.jpeg");
	}
}
