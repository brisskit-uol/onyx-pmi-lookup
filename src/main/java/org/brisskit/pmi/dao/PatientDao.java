package org.brisskit.pmi.dao;

import org.springframework.dao.DataAccessException;
import org.brisskit.pmi.bean.Patient;
import org.hibernate.SessionFactory;


/**
 * Patient DAO interface.
 * 
 * @author Jeff Lusted
 */
public interface PatientDao {

    /**
     * Find patient using S Number, Clinicom Internal Number or a casenote number.
     */
    public Patient findPatientById( String identifier ) throws DataAccessException;
    
    public SessionFactory getSessionFactory() ;
    
}
