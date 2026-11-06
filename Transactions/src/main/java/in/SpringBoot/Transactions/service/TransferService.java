package in.SpringBoot.Transactions.service;

import in.SpringBoot.Transactions.entity.Account;
import in.SpringBoot.Transactions.entity.TransferRecord;
import in.SpringBoot.Transactions.repository.AccountRepository;
import in.SpringBoot.Transactions.repository.TransferRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class TransferService {
    private AccountRepository accountRepository;
    private TransferRepository transferRepository;

    public TransferService(AccountRepository accountRepository,
                           TransferRepository transferRepository) {
        this.accountRepository = accountRepository;
        this.transferRepository = transferRepository;
    }

    @Transactional  //--> it causes rollBack if something went wrong
    public void transfer(Long fromAccountId,
                         Long toAccountId,
                         BigDecimal amount){
        Account fromAccount = accountRepository.findById(fromAccountId)
                .orElseThrow(() -> new RuntimeException("User not Found"));

        Account toAccount = accountRepository.findById(toAccountId)
                .orElseThrow(() -> new RuntimeException("User not Found"));

        fromAccount.debitAccount(amount);
        accountRepository.saveAndFlush(fromAccount);
        toAccount.creditAccount(amount);
        accountRepository.saveAndFlush(toAccount);
        transferRepository.save(new TransferRecord(
                fromAccountId,
                toAccountId,
                amount,
                LocalDate.now()
        ));
        transferRepository.flush();
        throw new RuntimeException("Some Error Occurred");
    }
}
