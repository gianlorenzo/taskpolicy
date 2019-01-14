package it.uniroma3.taskpolicy.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProvaController {

    @GetMapping(value = "/prova")
    public Prova getProva() {
        Prova prova = new Prova();
        Double x = Math.random();
        prova.setStringaProva(String.valueOf(x));
        return prova;
    }


    public class Prova {
        public String stringaProva;

        public String getStringaProva() {
            return stringaProva;
        }

        public void setStringaProva(String stringaProva) {
            this.stringaProva = stringaProva;
        }
    }

}
