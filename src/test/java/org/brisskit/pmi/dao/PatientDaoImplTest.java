/**
 * 
 */
package org.brisskit.pmi.dao;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.brisskit.pmi.bean.Patient;
import org.brisskit.pmi.utils.TestSetup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jl99
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
//specifies the Spring configuration to load for this test fixture
@ContextConfiguration("classpath:TestContextConfig.xml")
@TransactionConfiguration(transactionManager="txManager", defaultRollback=false)
@Transactional
public class PatientDaoImplTest {
	
	private static Logger log = Logger.getLogger( PatientDaoImplTest.class.getName() ) ;
	
	private PatientDao patientDao;
		
	@Autowired
	public void setPatientDao( PatientDao patientDao ) {
	    this.patientDao = patientDao;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		log.entering( PatientDaoImplTest.class.getSimpleName(), "setUp" ) ;
		TestSetup.initDB() ;
		log.exiting( PatientDaoImplTest.class.getSimpleName(), "setUp" ) ;
	}

	/**
	 * Test method for {@link org.brisskit.pmi.dao.PatientDaoImpl#findPatientById(java.lang.String)}.
	 */
	@Test
	public void testFindNonExistentPatientById() {
		Patient patient = patientDao.findPatientById( "S1234567" ) ;
		if( patient != null ) {
			fail( "Non-existent patient S1234567 was found!!!" );
		} ;
	}
	
	/**
	 * Test method for {@link org.brisskit.pmi.dao.PatientDaoImpl#findPatientById(java.lang.String)}.
	 */
	@Test
	public void testFindExistingPatientById() {
		Patient patient = patientDao.findPatientById( "S0000001" ) ;
		if( patient == null ) {
			fail( "Existing patient S0000001 not found!!!" );
		} ;
	}

}
