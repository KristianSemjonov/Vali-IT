package ee.bcs.valiit.tasks.solution.controller;


import org.hibernate.sql.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("game")
@RestController
public class BankController {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    HashMap<String, BigDecimal> accountMap = new HashMap<>();

    // http://localhost:8081/game/createAccount?accountNr=EE124

    @GetMapping("createAccount")
    public void createAccount(@RequestParam("accountNr") String accountNr) {
        String sql = "INSERT INTO account (account_number, balance) VALUES (:accountNumber,:balance)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("accountNumber", accountNr);
        paramMap.put("balance", BigDecimal.ZERO);
        jdbcTemplate.update(sql, paramMap);
        System.out.println("Account nr " + accountNr + " was created.");
        //accountMap.put(accountNr, BigDecimal.ZERO);
    }

    //http://localhost:8081/game/accountBalance?accountNr=EE123
    @GetMapping("accountBalance")
    public BigDecimal accountBalance(@RequestParam("accountNr") String accountNr) {
        String sql = "SELECT balance FROM acount WHERE account_number = :accountNumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNumber", accountNr);
        return jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);

        //return accountMap.get(accountNr);

    }

    //http://localhost:8081/game/depositMoney?accountNr=EE123&amount=12
    @GetMapping("depositMoney")
    public void depositMoney(@RequestParam("accountNr") String accountNr,
                             @RequestParam("amount") BigDecimal amount) {
        // BigDecimal balance = accountMap.get(accountNr);
        String sql = "SELECT balance FROM account WHERE account_number = :accountNumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNumber", accountNr);
        BigDecimal balance = jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);

        BigDecimal newBalance = balance.add(amount);

        // accountMap.put(accountNr, newBalance);
        String sql2 = "UPDATE account SET balance = :balance WHERE account_number = :accountNumber";
        Map<String, Object> paramMap2 = new HashMap();
        paramMap2.put("accountNumber", accountNr);
        paramMap2.put("balance", newBalance);
        jdbcTemplate.update(sql2, paramMap2);
        System.out.println("The amount " + amount + " was added to " + accountNr);
    }

//        BigDecimal balance = accountMap.get(accountNr);
//        BigDecimal newBalance = balance.add(amount);
//        accountMap.put(accountNr, newBalance);

    //http://localhost:8081/game/withdrawMoney?accountNr=EE123&amount=12
    @GetMapping("withdrawMoney")
    public void withdrawMoney(@RequestParam("accountNr") String accountNr,
                              @RequestParam("amount") BigDecimal amount) {

        String sql = "SELECT balance FROM account WHERE account_number = :accountNumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNumber", accountNr);
        BigDecimal balance = jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);

        BigDecimal newBalance = balance.subtract(amount); //saab ka teha nii et vana konto seis + amount

        // accountMap.put(accountNr, newBalance);
        String sql2 = "UPDATE account SET balance = :balance WHERE account_number = :accountNumber";
        Map<String, Object> paramMap2 = new HashMap();
        paramMap2.put("accountNumber", accountNr);
        paramMap2.put("balance", newBalance);
        jdbcTemplate.update(sql2, paramMap2);

//        BigDecimal balance = accountMap.get(accountNr);
//        BigDecimal newbalance = balance.subtract(amount);
//        if (newbalance.compareTo(BigDecimal.ZERO) < 0) {
//            throw new RuntimeException("Not enough money");
//        }
//        accountMap.put(accountNr, newbalance);
    }

    //http://localhost:8081/game/transferMoney?fromAccount=EE123&toAccount=EE124&amount=12
    @GetMapping("transferMoney")
    public void transferMoney(@RequestParam("fromAccount") String fromAccount,
                              @RequestParam("toAccount") String toAccount,
                              @RequestParam("amount") BigDecimal amount) {
        String sql = "SELECT balance FROM account WHERE account_number = :accountNr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNumber", accountNr);
        jdbcTemplate.queryForObject(sql, paramMap, Integer.class)
    }
//        BigDecimal fromAccountBalance = accountMap.get(fromAccount);
//        BigDecimal newFromAccountBalance = fromAccountBalance.subtract(amount);
//        if (newFromAccountBalance.compareTo(BigDecimal.ZERO) < 0) {
//            throw new RuntimeException("Not enough money");
//        }
//        accountMap.put(fromAccount, newFromAccountBalance);
//        BigDecimal toAccountBalance = accountMap.get(toAccount);
//        BigDecimal newToAccountBalance = toAccountBalance.add(amount);
//        accountMap.put(toAccount, newToAccountBalance);
//    }
}
