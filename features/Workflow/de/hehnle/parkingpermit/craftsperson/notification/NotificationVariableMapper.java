package de.hehnle.parkingpermit.craftsperson.notification;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateVariableMapping;
import org.camunda.bpm.engine.delegate.VariableScope;
import org.camunda.bpm.engine.variable.VariableMap;
import org.springframework.stereotype.Service;

@Service
public class NotificationVariableMapper implements DelegateVariableMapping {

	@Override
	public void mapInputVariables(DelegateExecution execution, VariableMap variables) {
		variables.put("application", execution.getVariable("application"));
	}

	@Override
	public void mapOutputVariables(DelegateExecution execution, VariableScope variables) {
	}
}