package de.hehnle.parkingpermit.craftsperson.applicationcheck.manual; 

import javax.inject.Named; 

import de.hehnle.parkingpermit.craftsperson.interfaces.ApplicationCheckPlugin; 

@Named
public  class  ManualCheckPlugin  implements ApplicationCheckPlugin {
	

	@Override
	public String getId() {
		return "applicationcheck.manual";
	}

	

	@Override
	public String getProcessId() {
		return "ManualApplicationCheck";
	}


}
