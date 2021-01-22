package ee.bcs.valiit.tasks.solution.controller;


import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;

@RequestMapping("game")
@RestController
public class BankController {
    HashMap<String, BigDecimal> accountMap = new HashMap<>();

    // http://localhost:8081/game/createAccount?accountNr=EE123
    @GetMapping("createAccount")
    public String createAccount(@RequestParam("accountNr") String accountNr) {
        accountMap.put(accountNr, BigDecimal.ZERO);
        return "Your account is " + accountNr;
    }

    //http://localhost:8081/game/accountBalance?accountNr=EE123
    @GetMapping("accountBalance")
    public BigDecimal accountBalance(@RequestParam("accountNr") String accountNr) {
        return accountMap.get(accountNr);

    }

    //http://localhost:8081/game/depositMoney?accountNr=EE123&amount=12
    @GetMapping("depositMoney")
    public void depositMoney(@RequestParam("accountNr") String accountNr,
                             @RequestParam("amount") String amount) {

    return accountMap.put(accountNr, amount);
    }

    //http://localhost:8081/game/withdrawMoney?accountNr=EE123&amount=12
    @GetMapping("withdrawMoney")
    public void withdrawMoney(@RequestParam("accountNr") String accountNr,
                              @RequestParam("amount") String BigDecima amount) {
        BigDecimal balance = accountMap.get(accountNr);
        BigDecima newbalance
    }

    //http://localhost:8081/game/transferMoney?fromAccount=EE123&toAccount=EE124&amount=12
    @GetMapping("transferMoney")
    public void transferMoney(@RequestParam("fromAccount") String fromAccount,
                              @RequestParam("toAccount") String toAccount,
                              @RequestParam("amount") String amount) {
    }
}
