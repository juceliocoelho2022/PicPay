package tech.devJucelio.picpay.service;

import org.springframework.stereotype.Service;
import tech.devJucelio.picpay.controller.dto.CreateWalletDto;
import tech.devJucelio.picpay.entity.Wallet;
import tech.devJucelio.picpay.exception.WalletDataAlreadyExistsException;
import tech.devJucelio.picpay.repository.WalletRepository;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet createWallet(CreateWalletDto dto) {

        var walletDb = walletRepository.findByCpfCnpjOrEmail(dto.cpfCnpj(), dto.email());
        if (walletDb.isPresent()) {
            throw new WalletDataAlreadyExistsException("CpfCnpj or Email already exists");
        }

        return walletRepository.save(dto.toWallet());
    }
}