package org.brisskit.pmi;

import org.brisskit.pmi.utils.BaseWebApplicationContext;
import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:TestContextConfig_Controller.xml" } )
public class ParticipantControllerIntegrationTest extends BaseWebApplicationContext {

	@Test
	public void retrieveKnownParticipant() throws Exception {

		MockHttpServletRequest request = new MockHttpServletRequest("GET", "/participant/S0000001/onyx.xml");
		request.setParameter( "mode", "unit_test" ) ;
		
		MockHttpServletResponse response = new MockHttpServletResponse();
		
		MockServletConfig config = new MockServletConfig() ;
		
		servlet.init(  config ) ;

		servlet.service(request, response);
		String result = response.getContentAsString();
		String expected = "<address><street>patentlaan</street><postcode>2288EE</postcode></address>";
		
		System.out.println( result ) ;
		
//		Assert.assertTrue(result.contains(expected));
		
	}
	
}
