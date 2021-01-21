package ee.bcs.valiit.tasks.solution.controller;


import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;

@RequestMapping("game")
@RestController
public class BankController {
    HashMap<String, BigDecimal> accountMap = new HashMap<>();

    // http://localhost:8080/game/bank?a=EE123  siis vastab "Your account EE123 (konto param)"
    @GetMapping("bank") //kui oleks reuqestparam siis {} pole vaja
    public String createAccount(@RequestParam("a") String konto) {
        //kui oleks lihtsalt return konto, saaks sama konto tagasi
        return "Your account is " + konto;
    }
//    http://localhost:8080/game/bank?b=EE123
//    @GetMapping("bank")
//    public BigDecimal accountBalance(@RequestParam("b") String balance ){
//        return BigDecimal.ZERO;
//    }
//    http://localhost:8080/game/bank/depositMoney?accountNr=EE123&amount=12
//    @GetMapping("bank/{depositMoney}")
//    public void depositMoney(@RequestParam("depositMoney")xxxx){
//    }
//    http://localhost:8080/game/bank/withdrawMoney?accountNr=EE123&amount=12
//    @GetMapping("bank/{withdrawMoney}")
//    public void withdrawMoney(@RequestParam("withdrawMoney") xxxx){
//
//    }
//    http://localhost:8080/game/bank/transferMoney?fromAccount=EE123&toAccount=EE124&amount=12
//    @GetMapping("bank/{transferMoney}")
//    public void transferMoney(@RequestParam("transferMoney"){
//
}
