package com.leadsassignment.repositories;

import com.leadsassignment.models.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeadRepository extends JpaRepository<Lead,Integer> {
    boolean existsByLeadId(Integer leadId);
    List<Lead> findByMobileNumber(String mobileNumber);
}
