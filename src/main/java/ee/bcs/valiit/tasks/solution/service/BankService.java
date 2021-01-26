package ee.bcs.valiit.tasks.solution.service;


import ee.bcs.valiit.tasks.solution.respository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    public void createAccount(String accountNr) {
        bankRepository.createAccount(accountNr);
    }

    public BigDecimal accountBalance(String accountNr) {
        return bankRepository.accountBalance(accountNr);

    }

    public void depositMoney(String accountNr, BigDecimal amount) {
        BigDecimal balance = bankRepository.accountBalance(accountNr);
        BigDecimal newbalance = balance.add(amount);
        bankRepository.updateBalance(accountNr, newbalance);
    }

    public void withdrawMoney(String accountNr, BigDecimal amount) {
        BigDecimal balance = bankRepository.accountBalance(accountNr);
        BigDecimal newbalance = balance.add(amount);
        if (newbalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Not enough money");
        }
        bankRepository.updateBalance(accountNr, newbalance);
    }

    public void transferMoney(String fromAccount, String toAccount, BigDecimal amount) {
        BigDecimal balance = bankRepository.accountBalance(fromAccount);
        BigDecimal newbalance = balance.subtract(amount);
        if (newbalance.compareTo(BigDecimal.ZERO)<0) {
            throw new RuntimeException("Not enough money");
        }
        BigDecimal newbalance2 = balance.add(amount);
        //bankRepository.updateBalance(accountNr, newbalance2);
    }
}
