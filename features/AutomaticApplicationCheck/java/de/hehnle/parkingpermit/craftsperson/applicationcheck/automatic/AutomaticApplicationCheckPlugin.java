package de.hehnle.parkingpermit.craftsperson.applicationcheck.automatic;

import org.springframework.stereotype.Component;

import de.hehnle.parkingpermit.craftsperson.interfaces.ApplicationCheckPlugin;

@Component
public class AutomaticApplicationCheckPlugin implements ApplicationCheckPlugin{

	@Override
	public String getId() {
		return "applicationcheck.automatic";
	}

	@Override
	public String getProcessId() {
		return "AutomaticApplicationCheck";
	}
}