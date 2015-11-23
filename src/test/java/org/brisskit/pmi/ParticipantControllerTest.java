package org.brisskit.pmi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.springframework.test.web.ModelAndViewAssert.assertViewName;

import org.brisskit.pmi.service.PMILookupService;
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
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;


/*
 * ModelAndViewAssert combined with MockHttpServletRequest, MockHttpSession,

 */

@RunWith(SpringJUnit4ClassRunner.class)
//specifies the Spring configuration to load for this test fixture
@ContextConfiguration("classpath:TestContextConfig_Controller.xml")
@TransactionConfiguration(transactionManager="txManager", defaultRollback=false)
@Transactional
public class ParticipantControllerTest {
	
	ParticipantController controller = null ; 
	
	@Autowired
	public void setParticipantController( ParticipantController participantController ) {
		this.controller = participantController;
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
	public void testLoadGoodParticipant() {		
		ModelAndView mav = null ;
		try {
			mav = controller.loadParticipant( "S0000001" ) ;
		}
		catch( PMILookupService.PatientNotFoundException pnfe ) {
			fail( "Did not find patient S0000001" ) ;
		}		
		assertNotNull( "ModelAndView should not be null", mav ) ;
		assertViewName( mav, "participantXmlView" ) ;
		Participant participant = (Participant)mav.getModel().get(BindingResult.MODEL_KEY_PREFIX + "participant");
		assertNotNull("Participant S0000001 should not be null", participant ) ;
		assertEquals( "S0000001", participant.getEnrollmentId() ) ;
	}
	
	@Test
	public void testLoadBadParticipant() {	
		try {
			ModelAndView mav = controller.loadParticipant( "S1234567" ) ;
		}
		catch( PMILookupService.PatientNotFoundException pnfe ) {
			return ;
		}
		fail( "Found non-existent Participant S1234567" ) ;
	}

}
