package ee.bcs.valiit.tasks.solution.controller;


import ee.bcs.valiit.tasks.Lesson3;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("solution3")
@RestController
public class SolutionLesson3 {
//http://localhost:8080/solution3/sum?a=1,2,3,4,5
    @GetMapping("sum")
    public int sum(@RequestParam("a") int [] aVariable) {
        return Lesson3.sum(aVariable);
    }
    //http://localhost:8080/solution3/factorial?a=5
    @GetMapping("factorial")
    public int factorial(@RequestParam("a") int aVariable) {
        return Lesson3.factorial(aVariable);
    }
}
