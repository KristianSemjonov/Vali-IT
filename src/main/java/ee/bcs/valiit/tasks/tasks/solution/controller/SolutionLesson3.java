package ee.bcs.valiit.tasks.tasks.solution.controller;


import ee.bcs.valiit.tasks.tasks.Lesson3;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("solution3")
@RestController
public class SolutionLesson3 {
    //http://localhost:8080/solution3/sum?a=1,2,3,4,5
    @GetMapping("sum")
    public int sum(@RequestParam("a") int[] aVariable) { //kui muutuja tyyp pole kirjas, j'relikult vaikimisi request param
        return Lesson3.sum(aVariable);
    }

    //http://localhost:8080/solution3/factorial?a=5
    @GetMapping("factorial")
    public int factorial(@RequestParam("a") int aVariable) {
        return Lesson3.factorial(aVariable);
    }
    //http://localhost:8080/solution3/sort?a=3,2,1
    @GetMapping("sort")
    public int [] sort(@RequestParam("a") int[] aVariable){ //vasakul pool sisend [] ja paremal pool väljund []
        return Lesson3.sort(aVariable);
    }
    //http://localhost:8080/solution3/reverseString?a=Kristian
    @GetMapping("reverseString")
    public String reverseString(@RequestParam("a") String aVariable){
    return Lesson3.reverseString(aVariable);
    }
    //http://localhost:8080/solution3/isPrime?a=10
    @GetMapping("isPrime")
    public boolean isPrime(@RequestParam("a") int aVariable) {
        return Lesson3.isPrime(aVariable);
    }
}
