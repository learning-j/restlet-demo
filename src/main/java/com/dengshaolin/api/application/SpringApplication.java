package com.dengshaolin.api.application;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import com.dengshaolin.api.resources.PersonResource;

public class SpringApplication extends Application {

	@Override
	public Restlet createInboundRoot() {
		Router router = new Router(this.getContext());
		// 绑定资源路径到对应的处理资源类
		router.attach("/persons", PersonResource.class);
		return router;
	}
}
