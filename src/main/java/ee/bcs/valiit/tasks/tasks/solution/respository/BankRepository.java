package ee.bcs.valiit.tasks.tasks.solution.respository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BankRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createAccount(String accountNr) {

        String sql = "INSERT INTO account (account_number, balance) VALUES (:accountNumber,:balance)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("accountNumber", accountNr);
        paramMap.put("balance", BigDecimal.ZERO);
        jdbcTemplate.update(sql, paramMap);
    }

    public BigDecimal accountBalance(String accountNr) {

        String sql = "SELECT balance FROM acount WHERE account_number = :accountNumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNumber", accountNr);
        return jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);

    }

    public void updateBalance(String accountNr, BigDecimal amount) {

        String sql2 = "UPDATE account SET balance = :balance WHERE account_number = :accountNumber";
        Map<String, Object> paramMap2 = new HashMap();
        paramMap2.put("accountNumber", accountNr);
        paramMap2.put("balance", amount);
        jdbcTemplate.update(sql2,paramMap2);


    }

//    public void withdrawMoney(String accountNr, BigDecimal amount){
//        String sql = "SELECT balance FROM account WHERE account_number = :accountNumber";
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
//        //jdbcTemplate.update(sql2, paramMap2);
//    }
}
