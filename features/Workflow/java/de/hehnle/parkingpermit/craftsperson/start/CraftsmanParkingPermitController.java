package de.hehnle.parkingpermit.craftsperson.start;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import de.hehnle.parkingpermit.craftsperson.entities.Application;
import de.hehnle.parkingpermit.craftsperson.notification.NotificationPluginRegistration;

@Controller
public class CraftsmanParkingPermitController {

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private NotificationPluginRegistration notificationPlugins;

	@GetMapping("/parking-permit")
	public String getForm(Model model) {

		Map<String, String> notificationwaysById = notificationPlugins.getPluginLabelsById();

		model.addAttribute("model", new ApplicationModel());
		model.addAttribute("notificationwaysById", notificationwaysById);

		return "craftsmanParkingPermit";
	}

	@PostMapping("/parking-permit")
	public String submit(@ModelAttribute ApplicationModel model) {

		VariableMap variables = Variables.createVariables()//
				.putValue("application", model.getApplication())//
				.putValue("notificationWays", model.getNotificationWays());

		runtimeService.startProcessInstanceByKey("CraftsmanParkingPermit_Wf", variables);

		return "craftssmanParkingPermitResult";
	}
}