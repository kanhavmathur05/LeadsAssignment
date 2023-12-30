package com.leadsassignment.controllers;

import com.leadsassignment.models.Lead;
import com.leadsassignment.response.ErrorResponse;
import com.leadsassignment.response.ErrorResponseDetails;
import com.leadsassignment.response.SuccessResponse;
import com.leadsassignment.response.SuccessResponseLeads;
import com.leadsassignment.services.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leads/")
public class LeadsController {

    @Autowired
    LeadService leadService;

    @PostMapping("/create")
    public ResponseEntity<?> createLead(@RequestBody Lead lead) {
        if (leadService.existsByLeadId(lead.getLeadId())) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse("error", new ErrorResponseDetails("E10010","Lead Already Exists in the database with the lead id")));
        } else {
            leadService.saveLead(lead);
            return ResponseEntity.ok(new SuccessResponse("success","Created Leads Successfully"));
        }
    }

    @GetMapping("/fetchByMobileNumber/{mobileNumber}")
    public ResponseEntity<?> fetchLeadsByMobileNumber(@PathVariable String mobileNumber) {
        List<Lead> leads = leadService.getLeadsByMobileNumber(mobileNumber);
        if (leads.isEmpty()) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse("error", new ErrorResponseDetails("E10011", "No Lead found with the Mobile Number " + mobileNumber)));
        } else {
            return ResponseEntity.ok(new SuccessResponseLeads("success",leads));
        }
    }
}
