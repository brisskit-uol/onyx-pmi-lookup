package org.brisskit.pmi;

import javax.servlet.http.HttpServletResponse;

import org.brisskit.pmi.service.PMILookupService;
import org.brisskit.pmi.service.PMILookupService.PatientNotFoundException;
import org.obiba.onyx.core.domain.participant.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Spring MVC controller for processing PMI Lookup Service
 * 
 * @author Jeff Lusted
 */
@Controller
public class ParticipantController
{
	/**
	 * Provides access to PMI Lookup Service
	 */
	@Autowired
	private PMILookupService pmiLookupService;
	
	@ExceptionHandler( PatientNotFoundException.class )
	@ResponseStatus( HttpStatus.NOT_FOUND )
	public void handleNotFoundException( PatientNotFoundException ex, HttpServletResponse response ) {		
	  return ;
	}

	// "GET", "/participant/S0000001/onyx.xml"
	@RequestMapping( value="/participant/{id}/onyx.xml", method=RequestMethod.GET )
	public ModelAndView loadParticipant( @PathVariable String id ) 
						throws PatientNotFoundException
	{
		//
		// Access the PMI Service, which in this instance builds a participant ...
		Participant participant = pmiLookupService.getParticipant( id ) ;
		//
		// Create and return a ModelAndView that represents the Participant
		ModelAndView mav = new ModelAndView( "participantXmlView", BindingResult.MODEL_KEY_PREFIX + "participant", participant );
		return mav;
	}

}
