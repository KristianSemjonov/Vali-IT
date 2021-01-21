package ee.bcs.valiit.tasks.solution.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;

@RequestMapping("mybank")
@RestController
public class BankController {
    HashMap<String, BigDecimal> accountMap = new HashMap<>();

    // http://localhost:8080/mybank/createAccount?accountNr=EE123
    public void createAccount(){
    }

    // http://localhost:8080/mybank/accountBalance?accountNr=EE123
    public BigDecimal accountBalance(){
        return BigDecimal.ZERO;
    }

    // http://localhost:8080/mybank/depositMoney?accountNr=EE123&amount=12
    public void depositMoney(){

    }

    // http://localhost:8080/mybank/withdrawMoney?accountNr=EE123&amount=12
    public void withdrawMoney(){

    }

    // http://localhost:8080/mybank/transferMoney?fromAccount=EE123&toAccount=EE124&amount=12
    public void transferMoney(){

    }
}

