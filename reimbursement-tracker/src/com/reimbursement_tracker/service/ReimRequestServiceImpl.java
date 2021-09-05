package com.reimbursement_tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reimbursement_trackerContoller.entity.ReimRequest;
import com.reimbursement_trackerDAO.ReimRequestDAO;

@Service
public class ReimRequestServiceImpl implements ReimRequestService {
	
	@Autowired
	private ReimRequestDAO reimrequestDAO;

	@Override
	@Transactional
	public List<ReimRequest> getReimRequests() {
		return reimrequestDAO.getReimRequests();
	}

	@Override
	@Transactional
	public void saveReimRequest(ReimRequest theReimRequest) {
		reimrequestDAO.saveReimRequest(theReimRequest);
	}

	@Override
	@Transactional
	public ReimRequest getReimRequest(int theId) {
		return reimrequestDAO.getReimRequest(theId);
	}

	@Override
	@Transactional
	public void deleteReimRequest(int theId) {
		reimrequestDAO.deleteReimRequest(theId);
		
	}

//	@Override
//	@Transactional
//	public List<ReimRequest> searchReimRequests(String theSearch) {
//		return reimrequestDAO.searchReimRequests(theSearch);
//	}

}
