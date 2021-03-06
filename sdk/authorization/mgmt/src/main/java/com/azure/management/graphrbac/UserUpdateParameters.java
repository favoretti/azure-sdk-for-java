// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License. See License.txt in the project root for
// license information.
// 
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.management.graphrbac;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The UserUpdateParameters model.
 */
@Fluent
public final class UserUpdateParameters extends UserBase {
    /*
     * Whether the account is enabled.
     */
    @JsonProperty(value = "accountEnabled")
    private Boolean accountEnabled;

    /*
     * The display name of the user.
     */
    @JsonProperty(value = "displayName")
    private String displayName;

    /*
     * The password profile of the user.
     */
    @JsonProperty(value = "passwordProfile")
    private PasswordProfile passwordProfile;

    /*
     * The user principal name (someuser@contoso.com). It must contain one of
     * the verified domains for the tenant.
     */
    @JsonProperty(value = "userPrincipalName")
    private String userPrincipalName;

    /*
     * The mail alias for the user.
     */
    @JsonProperty(value = "mailNickname")
    private String mailNickname;

    /**
     * Get the accountEnabled property: Whether the account is enabled.
     * 
     * @return the accountEnabled value.
     */
    public Boolean accountEnabled() {
        return this.accountEnabled;
    }

    /**
     * Set the accountEnabled property: Whether the account is enabled.
     * 
     * @param accountEnabled the accountEnabled value to set.
     * @return the UserUpdateParameters object itself.
     */
    public UserUpdateParameters withAccountEnabled(Boolean accountEnabled) {
        this.accountEnabled = accountEnabled;
        return this;
    }

    /**
     * Get the displayName property: The display name of the user.
     * 
     * @return the displayName value.
     */
    public String displayName() {
        return this.displayName;
    }

    /**
     * Set the displayName property: The display name of the user.
     * 
     * @param displayName the displayName value to set.
     * @return the UserUpdateParameters object itself.
     */
    public UserUpdateParameters withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Get the passwordProfile property: The password profile of the user.
     * 
     * @return the passwordProfile value.
     */
    public PasswordProfile passwordProfile() {
        return this.passwordProfile;
    }

    /**
     * Set the passwordProfile property: The password profile of the user.
     * 
     * @param passwordProfile the passwordProfile value to set.
     * @return the UserUpdateParameters object itself.
     */
    public UserUpdateParameters withPasswordProfile(PasswordProfile passwordProfile) {
        this.passwordProfile = passwordProfile;
        return this;
    }

    /**
     * Get the userPrincipalName property: The user principal name
     * (someuser@contoso.com). It must contain one of the verified domains for
     * the tenant.
     * 
     * @return the userPrincipalName value.
     */
    public String userPrincipalName() {
        return this.userPrincipalName;
    }

    /**
     * Set the userPrincipalName property: The user principal name
     * (someuser@contoso.com). It must contain one of the verified domains for
     * the tenant.
     * 
     * @param userPrincipalName the userPrincipalName value to set.
     * @return the UserUpdateParameters object itself.
     */
    public UserUpdateParameters withUserPrincipalName(String userPrincipalName) {
        this.userPrincipalName = userPrincipalName;
        return this;
    }

    /**
     * Get the mailNickname property: The mail alias for the user.
     * 
     * @return the mailNickname value.
     */
    public String mailNickname() {
        return this.mailNickname;
    }

    /**
     * Set the mailNickname property: The mail alias for the user.
     * 
     * @param mailNickname the mailNickname value to set.
     * @return the UserUpdateParameters object itself.
     */
    public UserUpdateParameters withMailNickname(String mailNickname) {
        this.mailNickname = mailNickname;
        return this;
    }
}
