package in.SpringBoot.Transactions.service;

import in.SpringBoot.Transactions.entity.Account;
import in.SpringBoot.Transactions.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createAccount(Account account) {
        accountRepository.save(account);
    }
}
