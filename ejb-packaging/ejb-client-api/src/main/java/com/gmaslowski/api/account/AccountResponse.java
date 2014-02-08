package com.gmaslowski.api.account;

import java.io.Serializable;

import static com.google.common.base.Objects.toStringHelper;

public class AccountResponse implements Serializable {

    private String response;

    public AccountResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return toStringHelper(AccountResponse.class)
                .add("response", response)
                .toString();
    }
}
