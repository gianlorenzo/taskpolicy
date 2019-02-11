package it.uniroma3.taskpolicy;


import it.uniroma3.taskpolicy.model.Image;
import it.uniroma3.taskpolicy.model.Result;
import it.uniroma3.taskpolicy.model.Symbol;
import it.uniroma3.taskpolicy.model.Task;
import it.uniroma3.taskpolicy.service.impl.ImageService;
import it.uniroma3.taskpolicy.service.impl.ResultService;
import it.uniroma3.taskpolicy.service.impl.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
        int countNull = 0;

        BigInteger id = this.imageService.findOneImageJob(); // id dell'immagine selezionata

        List<BigInteger> resultsId = this.resultService.findResultWithNoNullAnswer(id.longValue());
        List<Result> resultWithNoNullAnswer = new ArrayList<>();

        for (BigInteger resultId : resultsId) {
            resultWithNoNullAnswer.add(this.resultService.retrieveResult(resultId.longValue())); // lista dei risultati con risposta non nulla relativi all'immagine
        }

        System.out.println("size"+resultWithNoNullAnswer.size());


        if(resultWithNoNullAnswer.size()==0)
            return String.valueOf(id);

        else {
            for(Result r : resultWithNoNullAnswer) {
                if (r.getAnswer().equals("SI"))
                    countSi++;
                System.out.println("countsi" + countSi);
                if (r.getAnswer().equals("NO"))
                    countNo++;
                System.out.println("countno" + countNo);

                if (r.getAnswer() == null)
                    countNull++;
                System.out.println("countnull" + countNull);

                }
        }
        /*
        if(Math.abs(countSi-countNo)>2 || Math.abs(countNo-countSi)>2)
            return String.valueOf(id);

        else
            return String.valueOf(this.imageService.findOneImageJob());*/


        return assignTaskPolicy();

    }




}

