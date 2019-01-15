package it.uniroma3.taskpolicy.service.impl;


import it.uniroma3.taskpolicy.dao.PolicyDao;
import it.uniroma3.taskpolicy.model.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyService {

    @Autowired
    private PolicyDao policyDao;

    public void savePolicy(Policy policy) {
        this.policyDao.save(policy);
    }

    public List<Policy> findAllPolicy() {
        return this.policyDao.findAll();
    }

    public Policy findById(Long id) {
        return this.policyDao.findOne(id);
    }



}
