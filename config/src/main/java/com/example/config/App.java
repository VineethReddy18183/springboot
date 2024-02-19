package com.example.config;

import org.springframework.stereotype.Component;

@Component
public class App {

	private String appName;

	public App(String appName) {
		super();
		this.appName = appName;
	}

	public String getAppName() {
		return appName;
	}

}