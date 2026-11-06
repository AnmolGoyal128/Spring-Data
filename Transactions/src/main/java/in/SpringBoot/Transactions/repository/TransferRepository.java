package in.SpringBoot.Transactions.repository;

import in.SpringBoot.Transactions.entity.TransferRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<TransferRecord, Long> {
}
