package tech.devJucelio.picpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.devJucelio.picpay.entity.Transfer;

import java.util.UUID;

public interface TransferRepository extends JpaRepository<Transfer, UUID> {
}