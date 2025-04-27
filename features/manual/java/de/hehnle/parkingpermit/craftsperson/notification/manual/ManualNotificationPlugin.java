package de.hehnle.parkingpermit.craftsperson.notification.manual;

import org.springframework.stereotype.Component;

import de.hehnle.parkingpermit.craftsperson.interfaces.NotificationPlugin;

@Component 
public class ManualNotificationPlugin implements NotificationPlugin{

	@Override
	public String getId() {
		return "notificationmanual";
	}

	@Override
	public String getProcessId() {
		return "ManualNotification";
	}

	@Override
	public String getLabel() {
		return "Phone Call by Clerk";
	}
}