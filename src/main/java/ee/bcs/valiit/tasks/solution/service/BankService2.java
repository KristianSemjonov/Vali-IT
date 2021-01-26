package ee.bcs.valiit.tasks.solution.service;

import ee.bcs.valiit.tasks.solution.respository.BankRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class BankService2 {

    @Autowired
    private BankRepository2 bankRepository2;
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createAccount(String accountNr) {
        bankRepository2.createAccount(accountNr);
    }

    public BigDecimal accountBalance(String accountNr) {
        return bankRepository2.accountBalance(accountNr);
    }

    public void depositMoney(String accountNr, BigDecimal amount) {
        BigDecimal balance = bankRepository2.depositMoney(accountNr, amount);
        BigDecimal newBalance = balance.add(amount);
        bankRepository2.updateBalance(accountNr, newBalance);
    }
//        String sql = "SELECT balance FROM account where account_number = :accountNumber";
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("accountNumber", accountNr);
//        BigDecimal balance = jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class); //vaja
//        String sql2 = "UPDATE account SET balance = :balance WHERE account_number = :accountNumber";
//        Map<String, Object> paramMap2 = new HashMap();
//        paramMap2.put("accountNumber", accountNr);
//        paramMap2.put("balance", newBalance);
//        jdbcTemplate.update(sql2, paramMap2);

    public void withdrawMoney(String accountNr, BigDecimal amount) {
        BigDecimal balance = bankRepository2.withdrawMoney(accountNr, amount);
        BigDecimal newBalance = balance.subtract(amount);
        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Not enough money");
        }
        bankRepository2.updateBalance(accountNr, newBalance);
    }
//        String sql = "SELECT balance FROM account where account_number = :accountNumber";
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("accountNumber", accountNr);
//        BigDecimal balance = jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
//
//        BigDecimal newBalance = balance.subtract(amount);
//        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
//            throw new RuntimeException("Not enough money");
//        }
//
//        String sql2 = "UPDATE account SET balance = :balance WHERE account_number = :accountNumber";
//        Map<String, Object> paramMap2 = new HashMap();
//        paramMap2.put("accountNumber", accountNr);
//        paramMap2.put("balance", newBalance);
//        jdbcTemplate.update(sql2, paramMap2);
//    http://localhost:8081/bank2/transferMoney?fromAccount=EE444&toAccount=EE777&amount=12
    public void transferMoney(String fromAccount, String toAccount, BigDecimal amount) {
        BigDecimal balance1 = bankRepository2.withdrawMoney(fromAccount, amount);
        BigDecimal newBalance1 = balance1.subtract(amount);
        if (newBalance1.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Not enough money");
        }
        bankRepository2.updateBalance(fromAccount, newBalance1);

        BigDecimal balance2 = bankRepository2.depositMoney(toAccount, amount);
        BigDecimal newBalance2 = balance2.add(amount);
        bankRepository2.updateBalance(toAccount, newBalance2);
    }
}


//        String sql = "SELECT balance FROM account where account_number = :accountNumber";
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("accountNumber", fromAccount);
//        BigDecimal fromAccountBalance = jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
//
//        BigDecimal newFromAccountBalance = fromAccountBalance.subtract(amount);
//        if (newFromAccountBalance.compareTo(BigDecimal.ZERO) < 0) {
//            throw new RuntimeException("Not enough money");
//        }
//
//        // accountMap.put(fromAccount, newFromAccountBalance);
//        String sql2 = "UPDATE account SET balance = :balance WHERE account_number = :accountNumber";
//        Map<String, Object> paramMap2 = new HashMap();
//        paramMap2.put("accountNumber", fromAccount);
//        paramMap2.put("balance", newFromAccountBalance);
//        jdbcTemplate.update(sql2, paramMap2);
//
//        // BigDecimal toAccountBalance = accountMap.get(toAccount);
//        String sql3 = "SELECT balance FROM account where account_number = :accountNumber";
//        Map<String, Object> paramMap3 = new HashMap<>();
//        paramMap3.put("accountNumber", toAccount);
//        BigDecimal toAccountBalance = jdbcTemplate.queryForObject(sql3, paramMap3, BigDecimal.class);
//
//        BigDecimal newToAccountBalance = toAccountBalance.add(amount);
//
//        // accountMap.put(toAccount, newToAccountBalance);
//        String sql4 = "UPDATE account SET balance = :balance WHERE account_number = :accountNumber";
//        Map<String, Object> paramMap4 = new HashMap();
//        paramMap4.put("accountNumber", toAccount);
//        paramMap4.put("balance", newToAccountBalance);
//        jdbcTemplate.update(sql4, paramMap4);
//    }
//}
