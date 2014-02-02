package com.gmaslowski.ejb.helper;

import javax.ejb.SessionContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class LookupHelpers {

    public static final String DI = "_DependencyInjection";
    public static final String SESSION_CTX_LOOKUP = "_SessionCtxLookup";
    public static final String INITIAL_CONTEXT_LOOKUP = "_InitialContextLookup";

    public static <T> T sessionContextLookup(SessionContext sessionContext, String path) {
        return (T) sessionContext.lookup(path);
    }

    public static <T> T initialContextLookup(String path) {
        try {
            return (T) new InitialContext().lookup(path);
        } catch (NamingException swallowForExample) {
            return null;
        }
    }
}
