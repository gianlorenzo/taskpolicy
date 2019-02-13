package it.uniroma3.taskpolicy;


import it.uniroma3.taskpolicy.model.Result;

import it.uniroma3.taskpolicy.service.impl.ImageService;
import it.uniroma3.taskpolicy.service.impl.ResultService;
import it.uniroma3.taskpolicy.service.impl.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.ResolutionSyntax;
import java.awt.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class policy {

    @Autowired
    private TaskService taskService;

    @Autowired
    private ResultService resultService;

    @Autowired
    private ImageService imageService;

    private final int incertezza = 4;

    private Random randomGenerator = new Random();

    @GetMapping("/assignTaskPolicy")
    public String assignTaskPolicy() {

        int countSi = 0;
        int countNo = 0;

        BigInteger id = this.imageService.findAllImageResult(); // id dell'immagine selezionata

        System.out.println("Id Immagine da mostrare: " + id + "\n");

        /*--------Caso in cui ho finito i task da assegnare sono finiti--------*/
        if(id==null) {
            return null;
        } else {
            /*--------Caso in cui ho ancora task da assegnare--------*/
            List<BigInteger> resultsId = this.resultService.findResultWithNoNullAnswer(id.longValue());

            System.out.println("Numero risultati con risposta non nulla: " + resultsId.size() + "\n");

            List<Result> resultWithNoNullAnswer = new ArrayList<>();


            for (BigInteger resultId : resultsId) {
                resultWithNoNullAnswer.add(this.resultService.retrieveResult(resultId.longValue())); // lista dei risultati con risposta non nulla relativi all'immagine
            }

            System.out.println("Numero risultati con risposta non nulla dopo aver reucuperato i risultati : " + resultsId.size() + "\n");

            if (resultWithNoNullAnswer.size() == 0) {

                System.out.println("Mi trovo nella situazione dove la lista dei risultati con risposta non nulla è vuota" + "\n");

                return String.valueOf(id.longValue());
            } else {
                System.out.println("Mi trovo nella situazione in cui la lista dei risultati con risposta non nulla non è vuota" + "\n");
                for (Result r : resultWithNoNullAnswer) {
                    System.out.println("Sono nel ciclo for dei risultati non nulli");
                    System.out.println(r.getAnswer());

                    if(r.getAnswer().equals("SI")) {
                        countSi++;
                    }
                    if(r.getAnswer().equals("NO")) {
                        countNo++;
                        System.out.println("countNo:" + countNo);
                    }
                }

                if(Math.abs(countSi-countNo)>1 || Math.abs(countNo-countSi)>1)
                    return String.valueOf(this.imageService.findAllImageResult());
                if(Math.abs(countSi-countNo)==1 || Math.abs(countNo-countSi)==1)
                    return String.valueOf(id.longValue());
            }
        }

        return assignTaskPolicy();

    }

}

