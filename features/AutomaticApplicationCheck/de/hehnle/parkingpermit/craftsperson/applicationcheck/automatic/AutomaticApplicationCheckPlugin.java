package de.hehnle.parkingpermit.craftsperson.applicationcheck.automatic;

import javax.inject.Named;

import de.hehnle.parkingpermit.craftsperson.interfaces.ApplicationCheckPlugin;

@Named
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