package ee.bcs.valiit.tasks.tasks;

import ee.bcs.valiit.tasks.tasks.solution.service.BankService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RequestMapping("bank2")
@RestController
public class BankController2 {

//    @Autowired
//    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private BankService2 bankService2;

    //http://localhost:8081/bank2/newCustomer?name=Kristian
    @GetMapping("newCustomer")
    public String newCustomer(@RequestParam("name") String name) {
        return bankService2.newCustomer(name);
//        String sql = "INSERT INTO customer (name) VALUES (:name)";
//        Map<String, String> paramMap = new HashMap<>();
//        paramMap.put("name", name);
//        jdbcTemplate.update(sql,paramMap);
//        return "New customer has beed added";
    }

    // http://localhost:8081/bank2/createAccount?accountNr=EE123&customer_id=1
    @GetMapping("createAccount")
    public void createAccount(@RequestParam("accountNr") String accountNr, @RequestParam ("customer_id") int customer_id) {
        bankService2.createAccount(accountNr, customer_id);
    }

    // GetMapping("bank2/transaction")

    // http://localhost:8081/bank2/accountBalance?accountNr=EE123 TOMIS 0.0
    @GetMapping("accountBalance")
    public BigDecimal accountBalance(@RequestParam("accountNr") String accountNr) {
        return bankService2.accountBalance(accountNr);
    }

    // http://localhost:8081/bank2/depositMoney?accountNr=EE123&amount=12 TOIMIS
    @GetMapping("depositMoney")
    public void depositMoney(@RequestParam("accountNr") String accountNr, @RequestParam("amount") BigDecimal amount) {
        bankService2.depositMoney(accountNr, amount);
    }

    // http://localhost:8081/bank2/withdrawMoney?accountNr=EE555&amount=12 TOIMIS
    @GetMapping("withdrawMoney")
    public void withdrawMoney(@RequestParam("accountNr") String accountNr, @RequestParam("amount") BigDecimal amount) {
        bankService2.withdrawMoney(accountNr, amount);
    }

    // http://localhost:8081/bank2/transferMoney?fromAccount=EE123&toAccount=EE124&amount=12 TOIMIS
    @GetMapping("transferMoney")
    public void transferMoney(@RequestParam("fromAccount") String fromAccount,
                              @RequestParam("toAccount") String toAccount,
                              @RequestParam("amount") BigDecimal amount) {
        bankService2.transferMoney(fromAccount, toAccount, amount);
    }
}
