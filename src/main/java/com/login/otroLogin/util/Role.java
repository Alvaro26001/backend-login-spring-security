package com.login.otroLogin.util;

import java.util.Arrays;
import java.util.List;

public enum Role {

    ADMINISTRATOR(
                    Arrays.asList(Permission.CREATE_ONE_PRODUCT,
                    Permission.UPDATE_ONE_PRODUCT,
                    Permission.LIST_ALL_PRODUCT,
                    Permission.DELETE_ONE_PRODUCT)),
    USER(
                    Arrays.asList(Permission.CREATE_ONE_PRODUCT,
                    Permission.UPDATE_ONE_PRODUCT,
                    Permission.LIST_ALL_PRODUCT)
    );

    private List<Permission> permissions;

    Role(List<Permission> permissions){
        this.permissions = permissions;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
