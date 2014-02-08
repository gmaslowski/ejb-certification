package com.gmaslowski.api.remote.account;

import com.gmaslowski.api.account.AccountRequest;
import com.gmaslowski.api.account.AccountResponse;

public interface AccountServiceRemote {

    AccountResponse createAccountFromFarFarAway(AccountRequest request);

}
