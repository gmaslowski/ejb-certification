package com.gmaslowski.api.local.account;

import com.gmaslowski.api.account.AccountRequest;
import com.gmaslowski.api.account.AccountResponse;

public interface AccountServiceLocal {

    AccountResponse createAccount(AccountRequest request);

}
