package de.hehnle.parkingpermit.craftsperson;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.authorization.Authorization;
import org.camunda.bpm.engine.authorization.Permissions;
import org.camunda.bpm.engine.authorization.Resources;
import org.camunda.bpm.engine.filter.Filter;
import org.camunda.bpm.engine.task.TaskQuery;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableProcessApplication
public class CamundaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamundaApplication.class, args);
	}
	
	@Autowired
	private ProcessEngine processEngine;

	@EventListener
	private void processPostDeploy(PostDeployEvent event) {
		System.out.println("postDeploy");
		
		// Filter
		TaskQuery myTasksQuery =  processEngine.getTaskService().createTaskQuery().taskAssigneeExpression("${ currentUser() }").active();
		Filter myTasksFilter = processEngine.getFilterService().newTaskFilter("Meine Aufgaben");
		myTasksFilter.setOwner("admin");
		myTasksFilter.setQuery(myTasksQuery);
		myTasksFilter = processEngine.getFilterService().saveFilter(myTasksFilter);
		
		Authorization authorization  = processEngine.getAuthorizationService().createNewAuthorization(Authorization.AUTH_TYPE_GLOBAL);
		authorization.setResource(Resources.FILTER);
		authorization.setResourceId(myTasksFilter.getId());
		authorization.setUserId(Authorization.ANY);
		authorization.addPermission(Permissions.READ);
		processEngine.getAuthorizationService().saveAuthorization(authorization);
		
		// Authorization for Tasklist
		Authorization authorizationTaskList  = processEngine.getAuthorizationService().createNewAuthorization(Authorization.AUTH_TYPE_GLOBAL);
		authorizationTaskList.setResource(Resources.APPLICATION);
		authorizationTaskList.setResourceId("tasklist");
		authorizationTaskList.setUserId(Authorization.ANY);
		authorizationTaskList.addPermission(Permissions.ALL);
		processEngine.getAuthorizationService().saveAuthorization(authorizationTaskList);
	}
}
