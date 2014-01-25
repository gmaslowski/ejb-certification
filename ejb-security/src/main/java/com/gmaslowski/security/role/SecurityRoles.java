package com.gmaslowski.security.role;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class SecurityRoles {

    public static final String ADMIN_ROLE = "ADMIN";
    public static final String USER_ROLE = "USER";
    public static final String EMPLOYEE_ROLE = "EMPLOYEE";

    public static final List<String> ALL_ROLES = newArrayList(ADMIN_ROLE, USER_ROLE, EMPLOYEE_ROLE);
}
