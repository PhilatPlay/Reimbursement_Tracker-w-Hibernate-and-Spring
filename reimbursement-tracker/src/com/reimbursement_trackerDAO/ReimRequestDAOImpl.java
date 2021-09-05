package com.reimbursement_trackerDAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.reimbursement_trackerContoller.entity.ReimRequest;

@Repository
public class ReimRequestDAOImpl implements ReimRequestDAO {
	
	// injecting the session factory
	@Autowired  
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<ReimRequest> getReimRequests() {
		
		// get the current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query
		Query<ReimRequest> theQuery = 
		currentSession.createQuery("from ReimRequest order by requestorId",
				ReimRequest.class);
		
		// execute and get results list
		List<ReimRequest>
		reimrequests = theQuery.getResultList();
		
		// return the results
		return reimrequests;
	}


	@Override
	public void saveReimRequest(ReimRequest theReimRequest) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save the reimrequest
		currentSession.saveOrUpdate(theReimRequest);
		
	}
	
	
	@Override
	public void approveReimRequest(ReimRequest theReimRequest) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//approve and save the reimrequest
		theReimRequest.setStatus("approved");
		currentSession.saveOrUpdate(theReimRequest);
		
	}
	
	
	@Override
	public void declineReimRequest(ReimRequest theReimRequest) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//decline and save the reimrequest
		theReimRequest.setStatus("declined");
		currentSession.saveOrUpdate(theReimRequest);
		
	}
	
	@Override
	public void deleteReimRequest(int theId) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//delete the reimrequest with the primqry key.ONG
		Query theQuery = currentSession.createQuery("delete from ReimRequest where id=: theReimRequestId");
		theQuery.setParameter("theReimRequestId", theId);
		
		theQuery.executeUpdate();
		
		
	}


	@Override
	@Transactional
	public ReimRequest getReimRequest(int theId) {
		
		// get the current hibernate session
		 Session currentSession = sessionFactory.getCurrentSession();
		 
		// retrieve / read from database using the primary key
		 ReimRequest theReimRequest = currentSession.get(ReimRequest.class, theId);
		 
		 return theReimRequest;
	}
	
//	@Override
//    public List<ReimRequest> searchReimRequests(String theSearch) {
//        // get the current hibernate session
//        Session currentSession = sessionFactory.getCurrentSession();
//        
//        Query theQuery = null;
//        
//        //
//        // only search by name if theSearchName is not empty
//        //
//        if (theSearch != null && theSearch.trim().length() > 0) {
//            // search for firstName or lastName ... case insensitive
//            theQuery =currentSession.createQuery("from ReimRequest where lower(firstName) like :theName or lower(lastName) like :theName", ReimRequest.class);
//            theQuery.setParameter("theName", "%" + theSearch.toLowerCase() + "%");
//        }
//        else {
//            // theSearchName is empty ... so just get all requests
//            theQuery =currentSession.createQuery("from ReimRequest", ReimRequest.class);            
//        }
//        
//        // execute query and get result list
//        List<ReimRequest> theReimRequests = theQuery.getResultList();
//                
//        // return the results        
//        return theReimRequests;
//        
//    }

}
