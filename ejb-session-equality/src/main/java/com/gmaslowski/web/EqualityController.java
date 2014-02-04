package com.gmaslowski.web;

import com.gmaslowski.singleton.SingletonBean;
import com.gmaslowski.singleton.view.SingletonLocal;
import com.gmaslowski.stateful.StatefulBean;
import com.gmaslowski.stateful.view.StatefulLocal;
import com.gmaslowski.stateless.StatelessBean;
import com.gmaslowski.stateless.view.StatelessLocal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Stateless
@Path("/equality")
public class EqualityController {

    private static final Logger log = LoggerFactory.getLogger(EqualityController.class);

    @EJB
    private SingletonBean singleton1;
    @EJB
    private SingletonBean singleton2;
    @EJB
    private SingletonLocal singletonLocal;

    @EJB
    private StatelessBean stateless1;
    @EJB
    private StatelessBean stateless2;
    @EJB
    private StatelessLocal statelessLocal;

    @EJB
    private StatefulBean stateful1;
    @EJB
    private StatefulBean stateful2;
    @EJB
    private StatefulLocal statefulLocal;

    @GET
    public String checkEquality() {

        log.info("*** Singleton beans.");
        log.info("singleton1.equals(singleton1) " + areEqual(singleton1, singleton1));
        log.info("singleton1.equals(singleton2) " + areEqual(singleton1, singleton2));
        log.info("singleton2.equals(singleton1) " + areEqual(singleton2, singleton1));
        log.info("singleton1.equals(singletonLocal) " + areNotEqual(singleton1, singletonLocal));

        log.info("*** Stateless beans.");
        log.info("stateless1.equals(stateless1) " + areEqual(stateless1, stateless1));
        log.info("stateless1.equals(stateless2) " + areEqual(stateless1, stateless2));
        log.info("stateless2.equals(stateless1) " + areEqual(stateless2, stateless1));
        log.info("statelessLocal.equals(stateless1) " + areNotEqual(statelessLocal, stateless1));
        log.info("statelessLocal.equals(stateless2) " + areNotEqual(statelessLocal, stateless2));

        log.info("*** Stateful beans.");
        log.info("stateful1.equals(stateful1) " + areEqual(stateful1, stateful1));
        log.info("stateful1.equals(stateful2) " + areNotEqual(stateful1, stateful2));
        log.info("stateful2.equals(stateful1) " + areNotEqual(stateful2, stateful1));
        log.info("stateful1.equals(statefulLocal) " + areNotEqual(stateful1, statefulLocal));
        log.info("stateful2.equals(statefulLocal) " + areNotEqual(stateful2, statefulLocal));

        return "OK";
    }

    private boolean areEqual(Object o1, Object o2) {
        if (!o1.equals(o2)) {
            throw new EJBException("Objects not equal!");
        }
        return true;
    }

    private boolean areNotEqual(Object o1, Object o2) {
        if (o1.equals(o2)) {
            throw new EJBException("Objects equal!");
        }

        return false;
    }
}
