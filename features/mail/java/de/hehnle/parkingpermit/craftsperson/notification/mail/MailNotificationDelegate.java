package de.hehnle.parkingpermit.craftsperson.notification.mail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import de.hehnle.parkingpermit.craftsperson.entities.Application;

@Component 
public class MailNotificationDelegate implements JavaDelegate {
	
	@Value("${parkingpermit.mail.imap.url}")
	private String imapUrl;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		Application application = (Application) execution.getVariable("application");

		System.out.println("Connecting to: "+ imapUrl);
		System.out.println("Sending mail to: " + application.getApplicant().geteMail());
	}
}