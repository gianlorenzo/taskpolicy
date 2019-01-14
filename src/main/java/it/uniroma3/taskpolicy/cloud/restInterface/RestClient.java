package it.uniroma3.taskpolicy.cloud.restInterface;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("https://incodiceratio")
public interface RestClient {

    @RequestMapping("/students")
    String getStudents();

}
