package de.hehnle.parkingpermit.craftsperson.notification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import de.hehnle.parkingpermit.craftsperson.interfaces.NotificationPlugin;

@Service
public class NotificationPluginRegistration {

	@Value("${excludeNotification:}")
	private List<String> excludedPlugins = new ArrayList<String>();

	@Autowired
	private List<NotificationPlugin> plugins;

	public Map<String, String> getPluginLabelsById() {

		System.out.println("//////////////excluded plugins");
//		excludedPlugins.forEach(System.out::println);

		Map<String, String> pluginLabelsById = new HashMap<String, String>();
		for (NotificationPlugin plugin : plugins) {
			if (!excludedPlugins.contains(plugin.getId())) {
				pluginLabelsById.put(plugin.getId(), plugin.getLabel());
			}
		}

		return pluginLabelsById;
//		return plugins//
//				.stream()//
//				.filter(plugin -> !excludedPlugins.contains(plugin.getId()))//
//				.collect(//
//						Collectors.toMap(//
//								NotificationPlugin::getId, //
//								NotificationPlugin::getLabel)//
//				);
	}

	public Map<String, String> getPluginProcessIdsByPluginId() {

		Map<String, String> pluginProcessIdsByPluginId = new HashMap<String, String>();
		for (NotificationPlugin plugin : plugins) {
			if (!excludedPlugins.contains(plugin.getId())) {
				pluginProcessIdsByPluginId.put(plugin.getId(), plugin.getProcessId());
			}
		}

		return pluginProcessIdsByPluginId;

//		return plugins//
//				.stream()//
//				.filter(plugin -> !excludedPlugins.contains(plugin.getId()))//
//				.collect(//
//						Collectors.toMap(//
//								NotificationPlugin::getId, //
//								NotificationPlugin::getProcessId)//
//				);
	}
}