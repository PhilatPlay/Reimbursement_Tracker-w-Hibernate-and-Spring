package com.reimbursement_tracker.service;

import java.util.List;

import com.reimbursement_trackerContoller.entity.ReimRequest;

public interface ReimRequestService {
	
	public List<ReimRequest> getReimRequests();

	public void saveReimRequest(ReimRequest theReimRequest);

	public ReimRequest getReimRequest(int theId);

	public void deleteReimRequest(int theId);

//	public List<ReimRequest> searchReimRequests(String theSearch);
}
