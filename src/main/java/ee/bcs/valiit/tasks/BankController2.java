package ee.bcs.valiit.tasks;

import ee.bcs.valiit.tasks.solution.service.BankService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("bank2")
@RestController
public class BankController2 {

    @Autowired
    private BankService2 bankService2;

    // http://localhost:8081/bank2/createAccount?accountNr=EE555 TOIMIS
    @GetMapping("createAccount")
    public void createAccount(@RequestParam("accountNr") String accountNr) {
        bankService2.createAccount(accountNr);
    }

    // http://localhost:8081/bank2/accountBalance?accountNr=EE555 TOMIS 0.0
    @GetMapping("accountBalance")
    public BigDecimal accountBalance(@RequestParam("accountNr") String accountNr) {
        return bankService2.accountBalance(accountNr);
    }
    // http://localhost:8081/bank2/depositMoney?accountNr=EE555&amount=12 TOIMIS
    @GetMapping("depositMoney")
    public void depositMoney(@RequestParam("accountNr") String accountNr, @RequestParam("amount") BigDecimal amount) {
        bankService2.depositMoney(accountNr, amount);
    }
    // http://localhost:8081/bank2/withdrawMoney?accountNr=EE555&amount=12 TOIMIS
    @GetMapping("withdrawMoney")
    public void withdrawMoney(@RequestParam("accountNr") String accountNr, @RequestParam("amount") BigDecimal amount) {
        bankService2.withdrawMoney(accountNr, amount);
    }
    // http://localhost:8081/bank2/transferMoney?fromAccount=EE123&toAccount=EE555&amount=12 TOIMIS
    @GetMapping("transferMoney")
    public void transferMoney(@RequestParam("fromAccount") String fromAccount,
                              @RequestParam("toAccount") String toAccount,
                              @RequestParam("amount") BigDecimal amount) {
        bankService2.transferMoney(fromAccount, toAccount, amount);
    }
}