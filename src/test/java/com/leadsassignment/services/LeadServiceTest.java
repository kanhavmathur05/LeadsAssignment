package com.leadsassignment.services;

import com.leadsassignment.models.Lead;
import com.leadsassignment.repositories.LeadRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LeadServiceTest {

    @Mock
    private LeadRepository leadRepository;

    @InjectMocks
    private LeadService leadService;

    private Lead createSampleLead() {
        return new Lead(
                673,
                "lskdfsldf",
                "skjdfff",
                "kansdf",
                "8877887788",
                "Male",
                "2013-09-09",
                "skjdf@gmail.com");
    }

    @Test
    public void testExistsByLeadId_True() {
        Mockito.when(leadRepository.existsByLeadId(1)).thenReturn(true);

        boolean result = leadService.existsByLeadId(1);

        Assert.assertTrue(result);
        Mockito.verify(leadRepository, times(1)).existsByLeadId(1);
    }

    @Test
    public void testExistsByLeadId_False() {
        Mockito.when(leadRepository.existsByLeadId(1)).thenReturn(false);

        boolean result = leadService.existsByLeadId(1);

        Assert.assertFalse(result);
        Mockito.verify(leadRepository, times(1)).existsByLeadId(1);
    }

    @Test
    public void testGetLeadsByMobileNumber_Success() {
        String mobileNumber = "8877887788";
        List<Lead> leads = Arrays.asList(createSampleLead(), createSampleLead());
        when(leadRepository.findByMobileNumber(mobileNumber)).thenReturn(leads);

        List<Lead> result = leadService.getLeadsByMobileNumber(mobileNumber);

        Assert.assertEquals(leads, result);
        verify(leadRepository, times(1)).findByMobileNumber(mobileNumber);
    }

    @Test
    public void testGetLeadsByMobileNumber_NoLeadsFound() {
        String mobileNumber = "8877887788";
        when(leadRepository.findByMobileNumber(mobileNumber)).thenReturn(Collections.emptyList());

        List<Lead> result = leadService.getLeadsByMobileNumber(mobileNumber);

        Assert.assertTrue(result.isEmpty());
        verify(leadRepository, times(1)).findByMobileNumber(mobileNumber);
    }

}