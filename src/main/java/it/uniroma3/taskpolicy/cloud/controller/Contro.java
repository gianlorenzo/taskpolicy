package it.uniroma3.taskpolicy.cloud.controller;

import it.uniroma3.taskpolicy.cloud.restInterface.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Contro {

    final RestClient restClient;

    @Autowired
    public Contro(RestClient restClient) {
        this.restClient = restClient;
    }

    @GetMapping("/provaStud")
    public String getStudents() {

        return restClient.getStudents();
    }
}
