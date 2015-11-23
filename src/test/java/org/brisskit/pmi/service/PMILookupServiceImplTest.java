package org.brisskit.pmi.service;

import static org.junit.Assert.*;

import org.brisskit.pmi.utils.TestSetup;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.obiba.onyx.core.domain.participant.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
//specifies the Spring configuration to load for this test fixture
@ContextConfiguration("classpath:TestContextConfig.xml")
@TransactionConfiguration(transactionManager="txManager", defaultRollback=false)
@Transactional
public class PMILookupServiceImplTest {
	
	PMILookupService pmiLookupService = null ; 
	
	@Autowired
	public void setPMILookupService( PMILookupService pmiLookupService ) {
	    this.pmiLookupService = pmiLookupService;
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		TestSetup.initDB() ;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetKnownParticipant() {		
		try {
			Participant participant = pmiLookupService.getParticipant( "S0000001" ) ;
			assertNotNull( participant ) ;
			String id = participant.getEnrollmentId() ;
			if( id == null || !id.equalsIgnoreCase( "S0000001" ) ) {
				fail( "Participant enrollment Id not set up correctly." ) ;
			}
			else {
				assertEquals( "Arthur", participant.getFirstName() ) ;
				assertEquals( "Smith", participant.getLastName() ) ;
				assertEquals( "MALE", participant.getGender().toString() ) ;
				//
				// Some more checking in detail here...
			}	
		}
		catch( PMILookupService.PatientNotFoundException pnfe ) {
			fail("Could not find patient S0000001");
		}
			
	}
	
	@Test
	public void testGetUnknownParticipant() {
		try {
			Participant participant = pmiLookupService.getParticipant( "S1234567" ) ;
			fail("Found unknown patient S1234567!!!");
		}
		catch( PMILookupService.PatientNotFoundException pnfe ) {
			;
		}
	}

}
