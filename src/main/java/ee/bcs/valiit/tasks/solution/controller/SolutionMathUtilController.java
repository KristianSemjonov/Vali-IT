package ee.bcs.valiit.tasks.solution.controller;

import ee.bcs.valiit.tasks.Lesson1MathUtil;
import ee.bcs.valiit.tasks.solution.SolutionLesson1MathUtil;
import org.springframework.web.bind.annotation.*;

@RequestMapping("solution")
@RestController
public class SolutionMathUtilController {

    // http://localhost:8080/solution/min?a=5&b=9
    @GetMapping("min")
    public int min(@RequestParam("a") int aVariable, @RequestParam("b") int bVariable) {
        return Lesson1MathUtil.min(aVariable, bVariable);
    }

    // http://localhost:8080/solution/max/5/9
    @GetMapping("max/{a}/{b}")
    public int max(@PathVariable("a") int aVariable, @PathVariable("b") int bVariable) {
        return Lesson1MathUtil.max(aVariable, bVariable);
    }

    //    http://localhost:8080/solution/abs/-1
    @GetMapping("abs/{a}")
    public int abs(@PathVariable("a") int aVariable) {
        return Lesson1MathUtil.abs(aVariable);
    }

    //http://localhost:8080/solution/iseven/7
    @GetMapping("iseven/{a}")
    public boolean isEven(@PathVariable("a") int aVariable) {
        return Lesson1MathUtil.isEven(aVariable);
    }
    //http://localhost:8080/solution/min3/1/3/6
    @GetMapping("min3/{a}/{b}/{c}")
    public int min(@PathVariable("a") int aVariable, @PathVariable("b") int bVariable, @PathVariable("c") int cVariable) {
        return Lesson1MathUtil.min(aVariable, bVariable, cVariable);
    }
    //http://localhost:8080/solution/max3/1/3/6
    @GetMapping("max3/{a}/{b}/{c}")
    public int max( @PathVariable("a") int aVariable,  @PathVariable("b") int bVariable,  @PathVariable("c") int cVariable){
        return Lesson1MathUtil.max(aVariable, bVariable, cVariable);
    }
}
