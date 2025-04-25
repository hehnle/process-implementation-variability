package de.hehnle.parkingpermit.craftsperson.applicationcheck;

import java.util.ArrayList;
import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateVariableMapping;
import org.camunda.bpm.engine.delegate.VariableScope;
import org.camunda.bpm.engine.variable.VariableMap;
import org.springframework.stereotype.Service;

@Service
public class ApplicationCheckVariableMapper implements DelegateVariableMapping {

	@Override
	public void mapInputVariables(DelegateExecution execution, VariableMap variables) {
		
		variables.put("application", execution.getVariable("application"));
	}

	@Override
	public void mapOutputVariables(DelegateExecution execution, VariableScope variables) {

		List<Boolean> applicationCheckResults = (List<Boolean>) execution.getVariable("applicationCheckResults");
		Boolean justified = (Boolean) variables.getVariable("justified");
		
		if(applicationCheckResults==null) {
			applicationCheckResults = new ArrayList<Boolean>();
		}
		applicationCheckResults.add(justified);
		execution.setVariable("applicationCheckResults", applicationCheckResults);
		
		boolean isAnyUnjustified = false;
		for (Boolean result : applicationCheckResults) {
			if(!result) {
				isAnyUnjustified = true;
				break;
			}
		}

		execution.setVariable("justified", !isAnyUnjustified);
	}
}