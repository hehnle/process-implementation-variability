package de.hehnle.parkingpermit.craftsperson.applicationcheck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import de.hehnle.parkingpermit.craftsperson.interfaces.ApplicationCheckPlugin;

@Service
public class ApplicationCheckPluginRegistration {

	@Value("${excludeApplicationCheck:}")
	private List<String> excludedPlugins = new ArrayList<String>();

	@Autowired
	private List<ApplicationCheckPlugin> plugins;

	public Map<String, String> getPluginProcessIdsByPluginId() {
		
		Map<String, String> pluginProcessIdsByPluginId = new HashMap<String, String>();
		for (ApplicationCheckPlugin plugin : plugins) {
			if (!excludedPlugins.contains(plugin.getId())) {
				pluginProcessIdsByPluginId.put(plugin.getId(), plugin.getProcessId());
			}
		}
		
		return pluginProcessIdsByPluginId;
	}
}