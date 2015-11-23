package org.brisskit.pmi.service ;

import org.brisskit.pmi.bean.Patient;
import org.brisskit.pmi.dao.PatientDao;
import org.obiba.onyx.core.domain.participant.Gender;
import org.obiba.onyx.core.domain.participant.Participant;
import org.obiba.onyx.core.domain.participant.RecruitmentType;
import org.obiba.onyx.util.data.Data;
import org.obiba.onyx.util.data.DataType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service( "participantService" )
public class PMILookupServiceImpl implements PMILookupService {
	
	@Autowired
	PatientDao patientDao = null ;
	
	public PMILookupServiceImpl() {}
	
	public PMILookupServiceImpl( PatientDao patientDao ) {
		this.patientDao = patientDao ;
	}
	
	public Participant getParticipant( String id ) throws PatientNotFoundException {
		
		Patient patient = patientDao.findPatientById( id ) ;
		if( patient == null ) {
			throw new PatientNotFoundException() ;
		}
		return buildParticipant( patient ) ;
	}
	
	private Participant buildParticipant( Patient patient ) {
		Participant participant = new Participant() ;
		participant.setEnrollmentId( patient.getSNumber() ) ;
		participant.setLastName( patient.getLastName() ) ;
		participant.setFirstName( patient.getFirstName() ) ;		
		participant.setBirthDate( patient.getDateOfBirth() ) ;		
		participant.setGender( Gender.valueOf( patient.getGenderAsString() ) ) ;
		participant.setRecruitmentType( RecruitmentType.VOLUNTEER ) ;
		
		participant.setConfiguredAttributeValue( "pat_title", new Data( DataType.TEXT, patient.getTitle() ) ) ;
		participant.setConfiguredAttributeValue( "pat_nhsnumber", new Data( DataType.TEXT, patient.getNhsNumber() ) ) ;
		participant.setConfiguredAttributeValue( "pat_ethnicity", new Data( DataType.TEXT, patient.getEthnicity() ) ) ;
		participant.setConfiguredAttributeValue( "pat_address1", new Data( DataType.TEXT, patient.getAddressLine1() ) ) ;
		participant.setConfiguredAttributeValue( "pat_address2", new Data( DataType.TEXT, patient.getAddressLine2() ) ) ;
		participant.setConfiguredAttributeValue( "pat_address3", new Data( DataType.TEXT, patient.getAddressLine3() ) ) ;
		participant.setConfiguredAttributeValue( "pat_address4", new Data( DataType.TEXT, patient.getAddressLine4() ) ) ;
		participant.setConfiguredAttributeValue( "pat_postcode", new Data( DataType.TEXT, patient.getPostcode() ) ) ;
		participant.setConfiguredAttributeValue( "pat_telephone", new Data( DataType.TEXT, patient.getHomephone() ) ) ;
		participant.setConfiguredAttributeValue( "pat_workphone", new Data( DataType.TEXT, patient.getWorkphone() ) ) ;
		participant.setConfiguredAttributeValue( "pat_gp", new Data( DataType.TEXT, patient.getGpDOHCode() ) ) ;
		return participant ;
	}

}
