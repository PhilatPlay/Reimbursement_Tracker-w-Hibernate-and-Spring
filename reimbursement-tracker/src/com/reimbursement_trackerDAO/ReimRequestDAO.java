package com.reimbursement_trackerDAO;

import java.util.List;

import com.reimbursement_trackerContoller.entity.ReimRequest;

public interface ReimRequestDAO {
	
	public List<ReimRequest> getReimRequests();

	public void saveReimRequest(ReimRequest theReimRequest);

	public ReimRequest getReimRequest(int theId);

	void approveReimRequest(ReimRequest theReimRequest);

	void declineReimRequest(ReimRequest theReimRequest);

	public void deleteReimRequest(int theId);

//	public List<ReimRequest> searchReimRequests(String theSearch);

}
