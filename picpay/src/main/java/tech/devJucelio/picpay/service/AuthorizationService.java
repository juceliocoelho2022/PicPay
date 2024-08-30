package tech.devJucelio.picpay.service;

import org.springframework.stereotype.Service;
import tech.devJucelio.picpay.client.AuthorizationClient;
import tech.devJucelio.picpay.controller.dto.TransferDto;
import tech.devJucelio.picpay.exception.PicPayException;

@Service
public class AuthorizationService {

    private final AuthorizationClient authorizationClient;

    public AuthorizationService(AuthorizationClient authorizationClient) {
        this.authorizationClient = authorizationClient;
    }

    public boolean isAuthorized(TransferDto transfer) {

        var resp = authorizationClient.isAuthorized();

        if (resp.getStatusCode().isError()) {
            throw new PicPayException();
        }

        return resp.getBody().authorized();
    }
}