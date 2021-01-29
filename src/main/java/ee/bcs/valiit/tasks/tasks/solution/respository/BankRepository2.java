package ee.bcs.valiit.tasks.tasks.solution.respository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BankRepository2 {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createAccount(String account, int customer_id) {

        String sql = "INSERT INTO account (customer_id, account_number, balance) VALUES (:customer_id,:accountNumber, :balance)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("accountNumber", account);
        paramMap.put("balance", BigDecimal.ZERO);
        paramMap.put("customer_id", customer_id);
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
        String sql = "SELECT balance FROM account WHERE account_number = :accountNumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNumber", accountNr);
        return jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
//        BigDecimal newBalance = balance.subtract(amount);
//        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
//            throw new RuntimeException("Not enough money");
    }

//    public String getName(int id) {
//        String sql = "SELECT name FROM customer WHERE id = id    ";
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("id", account_id);
//        return jdbcTemplate.queryForObject(sql, paramMap, String.class);

        //peab tagastama nime ID põhjal
//    }

//    public Integer getAccountId(int id) {
//        String sql = "SELECT account_id from customer WHERE id = id ";
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("id", id);
//        return jdbcTemplate.queryForObject(sql, paramMap, String.class);
//
////        tagastab account_id, id põhjal
//    }

    public void transactionHistory(String name, String date, int account_id) {
        String sql = "INSERT INTO transaction (name, account_id) VALUES (:nameParameter, :dateParameter, :account_idParameter)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("nameParameter", name);
        paramMap.put("dateParameter", LocalDate.now().toString());
        paramMap.put("account_idParameter", account_id);
        jdbcTemplate.update(sql, paramMap);
    }

    public String newCustomer(String name) {
        String sql = "INSERT INTO customer (name) VALUES (:name)";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("name", name);
        jdbcTemplate.update(sql, paramMap);
        return "New customer has beed added";
    }
}

