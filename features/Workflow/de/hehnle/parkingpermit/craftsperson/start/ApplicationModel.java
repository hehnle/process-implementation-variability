package de.hehnle.parkingpermit.craftsperson.start;

import java.util.ArrayList;
import java.util.List;

import de.hehnle.parkingpermit.craftsperson.entities.Application;

public class ApplicationModel {
	
	private Application application;
	private List<String> notificationWays = new ArrayList<String>();

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public List<String> getNotificationWays() {
		return notificationWays;
	}

	public void setNotificationWays(List<String> notificationWays) {
		this.notificationWays = notificationWays;
	}
}