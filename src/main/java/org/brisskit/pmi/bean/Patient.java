package org.brisskit.pmi.bean ;

import java.util.Date;

/**
 * @author Jeff Lusted
 * 
 */
public class Patient {

	/*
	 * HISS Internal patient identifier
	 */
	private Integer id;

	/*
	 * Main patient identifier (S[0-9]{7})
	 */
	private String sNumber;

	/*
	 * Patient title (Mr, Mrs etc)
	 */
	private String title;

	/*
	 * Patient surname
	 */
	private String lastName;

	private String firstName;

	private Date dateOfBirth;

	private String ethnicity;

	private char gender;

	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String addressLine4;

	private String postcode;

	private String homephone;

	private String workphone;

	/*
	 * Patient year of birth. HISS allows users to specify a year of birth only
	 * if patient’s DOB is not known. If it is known the YOB will be the year
	 * from the date of birth.
	 */
	private String yearOfBirth;

	/*
	 * Need to confirm whether this is the required GP code National GP code
	 * /G[0-9]{7}/
	 */
	private String gpDOHCode;
	
	private String nhsNumber ;
	
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the sNumber
	 */
	public String getSNumber() {
		return sNumber;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @return the ethnicity
	 */
	public String getEthnicity() {
		return ethnicity;
	}

	/**
	 * @return the gender
	 */
	public char getGender() {
		return gender;
	}
	
	public String getGenderAsString() {
		if( gender == 'M' || gender == 'm' ) {
			return "MALE" ;
		}
		else {
			return "FEMALE" ;
		}
	}

	/**
	 * @return the addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}

	/**
	 * @return the addressLine2
	 */
	public String getAddressLine2() {
		return addressLine2;
	}

	/**
	 * @return the addressLine3
	 */
	public String getAddressLine3() {
		return addressLine3;
	}

	/**
	 * @return the addressLine4
	 */
	public String getAddressLine4() {
		return addressLine4;
	}

	/**
	 * @return the postcode
	 */
	public String getPostcode() {
		return postcode;
	}

	/**
	 * @return the homephone
	 */
	public String getHomephone() {
		return homephone;
	}

	/**
	 * @return the workphone
	 */
	public String getWorkphone() {
		return workphone;
	}

	/**
	 * @return the yearOfBirth
	 */
	public String getYearOfBirth() {
		return yearOfBirth;
	}

	/**
	 * @return the gpDOHCode
	 */
	public String getGpDOHCode() {
		return gpDOHCode;
	}

	/**
	 * @return the nhsNumber
	 */
	public String getNhsNumber() {
		return nhsNumber;
	}

	/**
	 * @return the sNumber
	 */
	public String getsNumber() {
		return sNumber;
	}

	/**
	 * @param sNumber the sNumber to set
	 */
	public void setsNumber(String sNumber) {
		this.sNumber = sNumber;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @param ethnicity the ethnicity to set
	 */
	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(char gender) {
		this.gender = gender;
	}

	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	/**
	 * @param addressLine2 the addressLine2 to set
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	/**
	 * @param addressLine3 the addressLine3 to set
	 */
	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	/**
	 * @param addressLine4 the addressLine4 to set
	 */
	public void setAddressLine4(String addressLine4) {
		this.addressLine4 = addressLine4;
	}

	/**
	 * @param postcode the postcode to set
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	/**
	 * @param homephone the homephone to set
	 */
	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}

	/**
	 * @param workphone the workphone to set
	 */
	public void setWorkphone(String workphone) {
		this.workphone = workphone;
	}

	/**
	 * @param yearOfBirth the yearOfBirth to set
	 */
	public void setYearOfBirth(String yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	/**
	 * @param gpDOHCode the gpDOHCode to set
	 */
	public void setGpDOHCode(String gpDOHCode) {
		this.gpDOHCode = gpDOHCode;
	}

	/**
	 * @param nhsNumber the nhsNumber to set
	 */
	public void setNhsNumber(String nhsNumber) {
		this.nhsNumber = nhsNumber;
	}

	/**
     * Returns a string representation of the object. 
     */
	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder() ;
		buffer
			.append( "[ " )
			.append( this.getClass().getName() )
			.append( ": " )
			.append( "id=" )
			.append( id )
			.append( " sNumber=" )
			.append( sNumber )
			.append( " title=" )
			.append( title )
			.append( " lastName=" )
			.append( lastName )
			.append( " firstName=" )
			.append( firstName )
			.append( " dateOfBirth=" )
			.append( dateOfBirth )
			.append( " ethnicity=" )
			.append( ethnicity )
			.append( " gender=" )
			.append( gender )
			.append( " addressLine1=" )
			.append( addressLine1 )
			.append( " addressLine2=" )
			.append( addressLine2 )
			.append( " addressLine3=" )
			.append( addressLine3 )
			.append( " addressLine4=" )
			.append( addressLine4 )
			.append( " postcode=" )
			.append( postcode )
			.append( " homephone=" )
			.append( homephone )
			.append( " workphone=" )
			.append( workphone )
			.append( " yearOfBirth=" )
			.append( yearOfBirth )
			.append( " gpDOHCode=" )
			.append( gpDOHCode ) 
			.append( " nhsNumber=" )
			.append( nhsNumber ) 
			.append( " ]" ) ;	
		return buffer.toString() ;
	}
}
