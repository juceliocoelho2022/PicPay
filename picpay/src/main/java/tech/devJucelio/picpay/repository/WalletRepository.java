package tech.devJucelio.picpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.devJucelio.picpay.entity.Wallet;

import java.util.Optional;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

    Optional<Wallet> findByCpfCnpjOrEmail(String cpfCnpj, String email);
}