package com.gmaslowski.web;

import com.gmaslowski.api.account.AccountRequest;
import com.gmaslowski.api.account.AccountResponse;
import com.gmaslowski.api.local.account.AccountServiceLocal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Stateless
@Path("/invoke")
public class LocalAccountController {

    private final static Logger log = LoggerFactory.getLogger(LocalAccountController.class);

    @EJB
    AccountServiceLocal accountServiceLocal;

    @GET
    public String request() {
        AccountResponse response = accountServiceLocal.createAccount(new AccountRequest("Local Ping"));
        log.info(response.toString());
        return "OK";
    }
}
