package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Samsung {

	@Autowired
	private App app;

	public String getAppName() {

		return app.getAppName();

	}

}
