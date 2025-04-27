package de.hehnle.parkingpermit.craftsperson.applicationcheck.manual;

import org.springframework.stereotype.Component;

import de.hehnle.parkingpermit.craftsperson.interfaces.ApplicationCheckPlugin;

@Component 
public class ManualCheckPlugin implements ApplicationCheckPlugin{

	@Override
	public String getId() {
		return "applicationcheck.manual";
	}

	@Override
	public String getProcessId() {
		return "ManualApplicationCheck";
	}
}