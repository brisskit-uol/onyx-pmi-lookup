package org.brisskit.pmi.bean;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import org.junit.BeforeClass;
import org.junit.Test;

public class PatientTest {
	
	private static Patient patient = null ;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		patient = new Patient() ;
		patient.setId( 1234567 ) ;
		patient.setsNumber( "S7654321" ) ;
		patient.setFirstName( "Keith" ) ;
		patient.setLastName( "Marmaduke" ) ;
		patient.setGender( 'M' ) ;
		patient.setEthnicity( "Caucasian" ) ;
		patient.setTitle( "Mr" ) ;
		patient.setDateOfBirth( new Date() ) ;
	}

	@Test
	public void testGetGender() {
		char cg = patient.getGender() ;
		assertEquals( 'M', cg ) ;
	}
	
	@Test
	public void testGetGenderAsString() {
		String sg = patient.getGenderAsString() ;
		assertEquals( "Incorrect mapping for gender returned:", "MALE", sg) ; 
	}

}
