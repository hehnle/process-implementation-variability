package de.hehnle.parkingpermit.craftsperson.entities;

public class Application {

	private Applicant applicant;
	private Company company;

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
}