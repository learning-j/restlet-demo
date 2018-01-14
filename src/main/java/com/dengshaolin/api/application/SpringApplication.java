package com.dengshaolin.api.application;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import com.dengshaolin.api.resources.PersonResource;
import com.dengshaolin.api.resources.UploadResource;

public class SpringApplication extends Application {

	@Override
	public Restlet createInboundRoot() {
		Router router = new Router(this.getContext());
		router.attach("/person", PersonResource.class);
		router.attach("/upload", UploadResource.class);
		return router;
	}
}
