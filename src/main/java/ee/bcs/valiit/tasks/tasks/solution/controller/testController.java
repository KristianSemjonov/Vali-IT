package ee.bcs.valiit.tasks.tasks.solution.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    @GetMapping("test/{name}")
    public String getHelloWorld(@PathVariable("name") String userName, @RequestParam("name") String lastName) {
        return "Hello World " + userName + lastName;
    }

}
