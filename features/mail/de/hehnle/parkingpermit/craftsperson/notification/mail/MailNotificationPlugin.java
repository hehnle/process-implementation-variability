package de.hehnle.parkingpermit.craftsperson.notification.mail;

import javax.inject.Named;

import de.hehnle.parkingpermit.craftsperson.interfaces.NotificationPlugin;

@Named
public class MailNotificationPlugin implements NotificationPlugin{

	@Override
	public String getId() {
		return "notification.mail";
	}

	@Override
	public String getProcessId() {
		return "mail";
	}

	@Override
	public String getLabel() {
		return "E-Mail";
	}
}