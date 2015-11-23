package org.brisskit.pmi.service;

import org.obiba.onyx.core.domain.participant.Participant ;

public interface PMILookupService {
	
	public class PatientNotFoundException extends Exception {
		private static final long serialVersionUID = 1L;		
	}

	public Participant getParticipant( String id ) throws PatientNotFoundException;
	
}
