package de.hehnle.parkingpermit.craftsperson.notification.sms; 

import javax.inject.Named; 

import org.camunda.bpm.engine.delegate.DelegateExecution; 
import org.camunda.bpm.engine.delegate.JavaDelegate; 

import de.hehnle.parkingpermit.craftsperson.entities.Application; 

@Named
public  class  SmsNotificationDelegate  implements JavaDelegate {
	

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		Application application = (Application) execution.getVariable("application");

		System.out.println("Sending SMS to: " + application.getApplicant().getPhoneNumber());
	}


}
