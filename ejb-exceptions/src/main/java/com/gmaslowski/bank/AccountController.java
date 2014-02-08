package com.gmaslowski.bank;

import com.gmaslowski.exception.application.CannotWithdrawException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import static com.gmaslowski.bank.Account.ING;
import static java.lang.Long.valueOf;

@Path("/account")
@Stateless
public class AccountController {

    private static final boolean LOAN_ACCOUNT = true;
    private static final boolean NORMAL_ACCOUNT = false;

    @EJB
    private Account account;

    @POST
    @Path("/ing")
    public String withdrawFromING(String amount) throws CannotWithdrawException {
        account.withdrawMoney(valueOf(amount), NORMAL_ACCOUNT, ING);
        return "OK";
    }

    @POST
    @Path("/ing/loan")
    public String withdrawFromINGLoan(String amount) throws CannotWithdrawException {
        account.withdrawMoney(valueOf(amount), LOAN_ACCOUNT, ING);
        return "OK";
    }

    @POST
    @Path("/pko")
    public String withdrawFromPKO(String amount) throws CannotWithdrawException {
        account.withdrawMoney(valueOf(amount), NORMAL_ACCOUNT, "PKO");
        return "OK";
    }

    @POST
    @Path("/pko")
    public String withdrawFromPKOLoan(String amount) throws CannotWithdrawException {
        account.withdrawMoney(valueOf(amount), LOAN_ACCOUNT, "PKO");
        return "OK";
    }

}
