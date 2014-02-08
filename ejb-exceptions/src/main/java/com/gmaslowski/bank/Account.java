package com.gmaslowski.bank;

import com.gmaslowski.exception.application.CannotWithdrawException;
import com.gmaslowski.exception.application.NoCashOnAccountException;
import com.gmaslowski.exception.system.ConnectionToBankRefusedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;

@Stateless
public class Account {

    private final static Logger log = LoggerFactory.getLogger(Account.class);

    private final static Long moneyOnNormalAccount = 700L;
    public final static String ING = "ing";

    public void withdrawMoney(Long money, boolean loan, String bank) throws CannotWithdrawException {

        if (!ING.equals(bank)) {
            throw new ConnectionToBankRefusedException();
        }

        if (loan) {
            throw new NoCashOnAccountException("No cash on loan account");
        } else {
            if (money > moneyOnNormalAccount) {
                throw new CannotWithdrawException("Not enough money on account!");
            }
            log.info("Money withdraw : {} ", money);
        }
    }
}
