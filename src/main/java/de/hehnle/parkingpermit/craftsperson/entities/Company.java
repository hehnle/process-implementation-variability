package de.hehnle.parkingpermit.craftsperson.entities; 

public   class  Company {
	

	private String name;

	
	private String street;

	
	private String city;

	
	private String zipCode;

	

	public String getName() {
		return name;
	}

	

	public void setName(String name) {
		this.name = name;
	}

	

	public String getStreet() {
		return street;
	}

	

	public void setStreet(String street) {
		this.street = street;
	}

	

	public String getCity() {
		return city;
	}

	

	public void setCity(String city) {
		this.city = city;
	}

	

	public String getZipCode() {
		return zipCode;
	}

	

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	

	private String commercialRegisterNumber;

	
	
	public void setCommercialRegisterNumber(String commercialRegisterNumber) {
		this.commercialRegisterNumber = commercialRegisterNumber;
	}

	
	
	public String getCommercialRegisterNumber() {
		return this.commercialRegisterNumber;
	}


}
