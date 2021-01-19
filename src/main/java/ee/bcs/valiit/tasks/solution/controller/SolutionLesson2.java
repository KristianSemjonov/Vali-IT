package ee.bcs.valiit.tasks.solution.controller;

import ee.bcs.valiit.tasks.Lesson2;
import org.springframework.web.bind.annotation.*;

@RequestMapping("solution2")
@RestController
public class SolutionLesson2 {
    //http://localhost:8080/solution2/fib?b=10
    @GetMapping("fib") //path
    public int fib(@RequestParam("a") int aVariable) {
        return Lesson2.exercise4(aVariable);
    }

    @GetMapping("cycle")
    public String cycle(@RequestParam("a") int aVariable, @RequestParam("b") int bVariable) {
      return Lesson2.exercise5(1,10);
    }
}
