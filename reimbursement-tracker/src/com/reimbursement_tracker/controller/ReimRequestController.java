package com.reimbursement_tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.reimbursement_tracker.service.ReimRequestService;
import com.reimbursement_trackerContoller.entity.ReimRequest;

@Controller
@RequestMapping("/reimrequest")
public class ReimRequestController {
	
	// injecting the Service into this controller
	@Autowired
	private ReimRequestService reimrequestService;
	
	@GetMapping("/list")
	public String listReimRequests(Model theModel) {
		
		// get reimrequests from the service
		List<ReimRequest> theReimRequests = reimrequestService.getReimRequests();
		
		// add the reimrequests to the model
		theModel.addAttribute("reimrequests", theReimRequests);
		
		return "index";
	}
	
	
	// API*********** setting up access to reimrequests from postman /javascript
	@GetMapping("/apiReimRequest")
	public List<ReimRequest> listReimRequestsapi(Model theModel) {
		
		// get reimrequests from the service
		List<ReimRequest> theReimRequests = reimrequestService.getReimRequests();
		
		return theReimRequests;
	}
	

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		//create model attribute to bind form data
		ReimRequest theReimRequest = new ReimRequest();
		
		theModel.addAttribute("reimrequest", theReimRequest);
		
		return "reimrequest-form";
	}
	
	
	@PostMapping("/saveReimRequest")
	public String saveReimRequest(@ModelAttribute("reimrequest") ReimRequest theReimRequest) {
		
		// save the reimrequest using the service
		reimrequestService.saveReimRequest(theReimRequest);
		
		return "redirect:/reimrequest/list";
	}
	
	
	@PostMapping("/showFormForMapping")
	public String showFormForUpdate(@RequestParam("reimrequest") int theId, 
									Model theModel) {
		
		// get request from the service
		ReimRequest theReimRequest = reimrequestService.getReimRequest(theId);
		
		// set the request as a model attribute to pre-populate the form.
		theModel.addAttribute("reimrequest", theReimRequest);
		
		// send over to form
		return "reimrequest-form";
	}
	
	@DeleteMapping("/delete")
	public String deleteReinRequest(@RequestParam("theReimRequestId") int theId) {
		
		// delete reimrequest
		reimrequestService.deleteReimRequest(theId);
		
		return "redirect:/reimrequest/list";
	}
	
//	 @GetMapping("/search")
//	    public String searchReimRequests(@RequestParam("theSearch") String theSearch,
//	                                    Model theModel) {
//	        // search customers from the service
//	        List<ReimRequest> theReimRequests = reimrequestService.searchReimRequests(theSearch);
//	                
//	        // add the customers to the model
//	        theModel.addAttribute("reimrequests", theReimRequests);
//	        return "list-reimrequests";        
//	    }
	
}






