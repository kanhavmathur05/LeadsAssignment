package com.leadsassignment.services;

import com.leadsassignment.models.Lead;
import com.leadsassignment.repositories.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LeadService {

    @Autowired
    LeadRepository leadRepository;

    public boolean existsByLeadId(Integer leadId) {
        return leadRepository.existsByLeadId(leadId);
    }

    public void saveLead(Lead lead) {
        leadRepository.save(lead);
    }

    public List<Lead> getLeadsByMobileNumber(String mobileNumber) {
        return leadRepository.findByMobileNumber(mobileNumber);
    }
}
