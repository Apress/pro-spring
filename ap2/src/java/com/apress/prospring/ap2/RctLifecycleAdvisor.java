/*
 * Created on 12-Nov-2004
 */
package com.apress.prospring.ap2;

import java.awt.Dimension;

import org.springframework.richclient.application.ApplicationWindow;
import org.springframework.richclient.application.config.ApplicationWindowConfigurer;
import org.springframework.richclient.application.config.DefaultApplicationLifecycleAdvisor;
import org.springframework.richclient.application.setup.SetupWizard;
import org.springframework.richclient.command.ActionCommand;

/**
 * @author janm
 */
public class RctLifecycleAdvisor extends DefaultApplicationLifecycleAdvisor {

	public void onPreWindowOpen(ApplicationWindowConfigurer configurer) {
		super.onPreWindowOpen(configurer);
		if (getApplicationServices().containsBean("setupWizard")) {
			SetupWizard setupWizard = (SetupWizard) getApplicationServices().getBean("setupWizard", SetupWizard.class);
			setupWizard.execute();
		}
		// comment out to hide the menubar, toolbar, or reduce window size...
		//configurer.setShowMenuBar(false);
		//configurer.setShowToolBar(false);
		configurer.setInitialSize(new Dimension(640, 480));
	}

	public void onCommandsCreated(ApplicationWindow window) {
		ActionCommand command = window.getCommandManager().getActionCommand("loginCommand");
		command.execute();
	}

}