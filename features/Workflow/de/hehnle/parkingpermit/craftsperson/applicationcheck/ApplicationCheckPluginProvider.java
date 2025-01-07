package de.hehnle.parkingpermit.craftsperson.applicationcheck;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationCheckPluginProvider {

	@Autowired
	private ApplicationCheckPluginRegistration applicationCheckPlugins;

	public List<String> getProcessIds() {

		List<String> processIds = new ArrayList<String>();

		for (Entry<String, String> plugin : applicationCheckPlugins.getPluginProcessIdsByPluginId().entrySet()) {
			String processId = plugin.getValue();
			processIds.add(processId);

		}
		
		return processIds;
	}
}