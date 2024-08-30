package tech.devJucelio.picpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.devJucelio.picpay.entity.WalletType;

public interface WalletTypeRepository extends JpaRepository<WalletType, Long> {
}