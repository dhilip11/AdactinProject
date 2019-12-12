package com.maven.cucumbertask.CucumberProject;

import java.io.File;

import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class HooksConcept {
@Before
	public void beforeHook() {
	
	}
	@After
	public void afterHook(Scenario s) throws Throwable {
		if (s.isFailed()) {
			File takeScreenShot = Allmethods.takeScreenShot(s.getName());
			Reporter.addScreenCaptureFromPath(takeScreenShot.getAbsolutePath());
			
		}
	}

}
