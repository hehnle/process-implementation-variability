package de.hehnle.parkingpermit.craftsperson.notification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationPluginProvider{

	@Autowired
	private NotificationPluginRegistration notificationPlugins;
	
	public List<String> getProcessIds(DelegateExecution execution){
		List<String> notificationWays = (List<String>) execution.getVariable("notificationWays");

		List<String> processIds = new ArrayList<String>();

		for (Entry<String, String> plugin : notificationPlugins.getPluginProcessIdsByPluginId().entrySet()) {
			String pluginId = plugin.getKey();

			if (notificationWays.contains(pluginId)) {

				String processId = plugin.getValue();
				processIds.add(processId);

			}
		}
		return processIds;
	}
}