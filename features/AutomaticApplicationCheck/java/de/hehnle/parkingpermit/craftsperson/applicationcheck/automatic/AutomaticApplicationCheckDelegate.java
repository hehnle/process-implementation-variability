package de.hehnle.parkingpermit.craftsperson.applicationcheck.automatic;

import org.springframework.stereotype.Component;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Value;

import de.hehnle.parkingpermit.craftsperson.entities.Application;

@Component
public class AutomaticApplicationCheckDelegate implements JavaDelegate {
	
	@Value("${parkingpermit.commcercialregister.url}")
	private String url;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {

		System.out.println("connecting to " + url);
		
		Application application = (Application) execution.getVariable("application");
		System.out.println("Checking application automatically for commercial register number: "
				+ application.getCompany().getCommercialRegisterNumber());

		execution.setVariable("justified", false);
		System.out.println("Application for Parking Permit is NOT JUSTIFIED");
	}
}