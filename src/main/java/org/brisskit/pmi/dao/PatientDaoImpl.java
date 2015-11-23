package org.brisskit.pmi.dao;

import org.brisskit.pmi.bean.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Patient DAO implementation.
 * 
 * @author Jeff Lusted
 */
@Repository
@Transactional(readOnly = true)
public class PatientDaoImpl implements PatientDao {

	@Autowired
    protected SessionFactory sessionFactory = null;
	
	private String query ;
	
	private PatientDaoImpl() {}
	
	public PatientDaoImpl( String query ) {
		this.query = query ;
	}

    /**
     * Set Hibernate session factory.
     */
    public void setSessionFactory( SessionFactory sessionFactory ) {
        this.sessionFactory = sessionFactory ;
    }
    
    public SessionFactory getSessionFactory() {
    	return sessionFactory ;
    }

	/* 
	 * Find patient using S Number, Clinicom Internal Number or a casenote number.
	 */
	public Patient findPatientById( String identifier ) throws DataAccessException {		
		Session session = sessionFactory.getCurrentSession() ;
		Patient patient = (Patient) session.createSQLQuery( query ).addEntity( Patient.class ).setString("searchID", identifier ).uniqueResult() ; ;						
		return patient ;
	}
	
}
