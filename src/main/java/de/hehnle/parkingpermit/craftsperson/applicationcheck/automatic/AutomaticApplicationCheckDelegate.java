package de.hehnle.parkingpermit.craftsperson.applicationcheck.automatic; 

import javax.inject.Named; 

import org.camunda.bpm.engine.delegate.DelegateExecution; 
import org.camunda.bpm.engine.delegate.JavaDelegate; 

import de.hehnle.parkingpermit.craftsperson.entities.Application; 

@Named
public  class  AutomaticApplicationCheckDelegate  implements JavaDelegate {
	

	@Override
	public void execute(DelegateExecution execution) throws Exception {

		Application application = (Application) execution.getVariable("application");
		System.out.println("Checking application automatically for commercial register number: "
				+ application.getCompany().getCommercialRegisterNumber());

		execution.setVariable("justified", false);
		System.out.println("Application for Parking Permit is NOT JUSTIFIED");
	}


}
