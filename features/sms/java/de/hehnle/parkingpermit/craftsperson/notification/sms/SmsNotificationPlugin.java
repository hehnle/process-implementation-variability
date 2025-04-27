package de.hehnle.parkingpermit.craftsperson.notification.sms;
import org.springframework.stereotype.Component;

import de.hehnle.parkingpermit.craftsperson.interfaces.NotificationPlugin;

@Component 
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