package com.gmaslowski.service.account;

import com.gmaslowski.api.account.AccountRequest;
import com.gmaslowski.api.account.AccountResponse;
import com.gmaslowski.api.local.account.AccountServiceLocal;
import com.gmaslowski.api.remote.account.AccountServiceRemote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Local(AccountServiceLocal.class)
@Remote(AccountServiceRemote.class)
public class AccountService implements AccountServiceLocal, AccountServiceRemote {

    private static final Logger log = LoggerFactory.getLogger(AccountService.class);

    @Override
    public AccountResponse createAccount(AccountRequest request) {
        log.info(request.toString());
        return new AccountResponse("Local Pong");
    }

    @Override
    public AccountResponse createAccountFromFarFarAway(AccountRequest request) {
        log.info(request.toString());
        return new AccountResponse("Remote Pong");
    }
}
