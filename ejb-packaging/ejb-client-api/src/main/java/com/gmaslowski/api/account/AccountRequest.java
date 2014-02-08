package com.gmaslowski.api.account;

import java.io.Serializable;

import static com.google.common.base.Objects.toStringHelper;

public class AccountRequest implements Serializable {

    private String request;

    public AccountRequest(String request) {
        this.request = request;
    }

    @Override
    public String toString() {
        return toStringHelper(AccountRequest.class)
                .add("request", request)
                .toString();
    }
}
