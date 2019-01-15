package it.uniroma3.taskpolicy.controller;


import it.uniroma3.taskpolicy.model.Policy;
import it.uniroma3.taskpolicy.service.impl.PolicyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class PolicyController {

    @Autowired
    private PolicyService policyService;


    @RequestMapping(value="/toSetPolicy", method = RequestMethod.GET)
    public String toSetPolicy(@ModelAttribute Policy policy, Model model) {
        model.addAttribute("policy", policy);
        return "policy/insertPolicy";

    }


    @RequestMapping(value="/setPolicy", method = RequestMethod.POST)
    public String setPolicy(@ModelAttribute Policy policy, Model model) {
        this.policyService.savePolicy(policy);
        model.addAttribute("policy", policy);
        return "policy/policyRecap";
    }



}
