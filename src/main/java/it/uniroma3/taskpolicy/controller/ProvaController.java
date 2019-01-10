package it.uniroma3.taskpolicy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProvaController {

    @GetMapping(value = "/prova")
    public String getProva() {
        return "Sto provando il controller rest";
    }

}
