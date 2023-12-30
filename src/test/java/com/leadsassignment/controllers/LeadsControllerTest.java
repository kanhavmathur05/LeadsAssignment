package com.leadsassignment.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leadsassignment.models.Lead;
import com.leadsassignment.response.ErrorResponse;
import com.leadsassignment.response.SuccessResponse;
import com.leadsassignment.response.SuccessResponseLeads;
import com.leadsassignment.services.LeadService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class LeadsControllerTest {
    private Lead createSampleLead() {
        return new Lead(
                673,
                "lskdfsldf",
                "skjdfff",
                "kansdf",
                "7641139800",
                "Male",
                "2013-09-09",
                "skjdf@gmail.com");
    }
    @Mock
    private LeadService leadService;

    @InjectMocks
    private LeadsController leadController;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testCreateLead_Success() throws Exception {
        Lead lead = createSampleLead();
        when(leadService.existsByLeadId(lead.getLeadId())).thenReturn(false);

        ResponseEntity<?> responseEntity = leadController.createLead(lead);

        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assert.assertEquals("success", ((SuccessResponse) responseEntity.getBody()).getStatus());

        verify(leadService, times(1)).existsByLeadId(lead.getLeadId());
        verify(leadService, times(1)).saveLead(lead);
    }

    @Test
    public void testCreateLead_Failure_LeadExists() throws Exception {
        Lead lead = createSampleLead();
        when(leadService.existsByLeadId(lead.getLeadId())).thenReturn(true);

        ResponseEntity<?> responseEntity = leadController.createLead(lead);

        Assert.assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        Assert.assertEquals("error", ((ErrorResponse) responseEntity.getBody()).getStatus());
        Assert.assertEquals("E10010", ((ErrorResponse) responseEntity.getBody()).getErrorResponse().getCode());

        verify(leadService, times(1)).existsByLeadId(lead.getLeadId());
        verify(leadService, times(0)).saveLead(lead);
    }

    @Test
    public void testFetchLeadsByMobileNumber_Success() throws Exception {
        String mobileNumber = "8877887788";
        List<Lead> leads = Arrays.asList(createSampleLead(), createSampleLead());
        when(leadService.getLeadsByMobileNumber(mobileNumber)).thenReturn(leads);

        ResponseEntity<?> responseEntity = leadController.fetchLeadsByMobileNumber(mobileNumber);

        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assert.assertEquals("success", ((SuccessResponseLeads) responseEntity.getBody()).getStatus());

        verify(leadService, times(1)).getLeadsByMobileNumber(mobileNumber);
    }

    @Test
    public void testFetchLeadsByMobileNumber_NoLeadsFound() throws Exception {
        String mobileNumber = "8877887788";
        when(leadService.getLeadsByMobileNumber(mobileNumber)).thenReturn(Collections.emptyList());

        ResponseEntity<?> responseEntity = leadController.fetchLeadsByMobileNumber(mobileNumber);

        Assert.assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        Assert.assertEquals("error", ((ErrorResponse) responseEntity.getBody()).getStatus());
        Assert.assertEquals("E10011", ((ErrorResponse) responseEntity.getBody()).getErrorResponse().getCode());

        verify(leadService, times(1)).getLeadsByMobileNumber(mobileNumber);
    }
}