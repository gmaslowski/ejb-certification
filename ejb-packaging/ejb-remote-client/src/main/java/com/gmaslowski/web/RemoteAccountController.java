package com.gmaslowski.web;

import com.gmaslowski.api.account.AccountRequest;
import com.gmaslowski.api.account.AccountResponse;
import com.gmaslowski.api.remote.account.AccountServiceRemote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Stateless
@Path("/invoke")
public class RemoteAccountController {

    private static final Logger log = LoggerFactory.getLogger(RemoteAccountController.class);

    @EJB
    private AccountServiceRemote accountServiceRemote;

    @GET
    public String invoke() {
        AccountResponse response = accountServiceRemote.createAccountFromFarFarAway(new AccountRequest("Remote Ping"));
        log.info(response.toString());
        return "OK";
    }
}
