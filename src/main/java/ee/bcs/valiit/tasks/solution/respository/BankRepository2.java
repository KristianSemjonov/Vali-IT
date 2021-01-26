package ee.bcs.valiit.tasks.solution.respository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BankRepository2 {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createAccount(String account) {

        String sql = "INSERT INTO account (account_number, balance) VALUES (:accountNumber, :balance)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("accountNumber", account);
        paramMap.put("balance", BigDecimal.ZERO);
        jdbcTemplate.update(sql, paramMap);
    }

    public BigDecimal accountBalance(String accountNr) {

        String sql = "SELECT balance FROM account where account_number = :accountNumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNumber", accountNr);
        return jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
    }

    public BigDecimal depositMoney(String accountNr, BigDecimal amount) {

        String sql = "SELECT balance FROM account where account_number = :accountNumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNumber", accountNr);
        return jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
    }

    public void updateBalance(String accountNr, BigDecimal amount) {
        String sql2 = "UPDATE account SET balance = :balance WHERE account_number = :accountNumber";
        Map<String, Object> paramMap2 = new HashMap();
        paramMap2.put("accountNumber", accountNr);
        paramMap2.put("balance", amount);
        jdbcTemplate.update(sql2, paramMap2);
    }

    public BigDecimal withdrawMoney(String accountNr, BigDecimal amount) {
        String sql = "SELECT balance FROM account where account_number = :accountNumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNumber", accountNr);
        return jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
//        BigDecimal newBalance = balance.subtract(amount);
//        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
//            throw new RuntimeException("Not enough money");
        }
    }

