package de.hehnle.parkingpermit.craftsperson.notification.sms;

import javax.inject.Named;

import de.hehnle.parkingpermit.craftsperson.interfaces.NotificationPlugin;

@Named
public class SmsNotificationPlugin implements NotificationPlugin{

	@Override
	public String getId() {
		return "notification.sms";
	}

	@Override
	public String getProcessId() {
		return "sms";
	}

	@Override
	public String getLabel() {
		return "SMS";
	}
}