package de.hehnle.parkingpermit.craftsperson.notification.manual; 

import javax.inject.Named; 

import de.hehnle.parkingpermit.craftsperson.interfaces.NotificationPlugin; 

@Named
public  class  ManualNotificationPlugin  implements NotificationPlugin {
	

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
