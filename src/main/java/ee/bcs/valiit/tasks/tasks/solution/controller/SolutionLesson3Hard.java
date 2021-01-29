package ee.bcs.valiit.tasks.tasks.solution.controller;

import ee.bcs.valiit.tasks.tasks.Lesson3Hard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RequestMapping("solution3hard")
@RestController
public class SolutionLesson3Hard {

    //http://localhost:8080/solution3hard/evenFibonacci?a=34
    @GetMapping("evenFibonacci")
    public static int evenFibonacci(@RequestParam("a") int aVariable) {
        return Lesson3Hard.evenFibonacci(aVariable);
    }
    //xxx
    //localhost:8080/solution3hard/randomGame?number=20
    static Random number = new Random();
    static int randomNumber = number.nextInt(100);
    @GetMapping("randomGame")
    public static String randomGame(@RequestParam("number") int aVariable) {
        if (randomNumber < aVariable) {
            String string = "Number on liiga suur, proovi väiksemat";
            return string;
        } else if (randomNumber > aVariable) {
            String string = "Number on liiga väike, proovi suuremat";
            return string;
        } else {
            String string = "Palju õnne! Number oli õige!";
            return string;
        }
    }
}
