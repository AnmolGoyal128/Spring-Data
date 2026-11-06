package in.SpringBoot.Transactions.repository;

import in.SpringBoot.Transactions.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
