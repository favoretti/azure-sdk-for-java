// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.management.graphrbac;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.JsonFlatten;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The RoleAssignmentCreateParameters model.
 */
@JsonFlatten
@Fluent
public class RoleAssignmentCreateParameters {
    /*
     * The role definition ID used in the role assignment.
     */
    @JsonProperty(value = "properties.roleDefinitionId", required = true)
    private String roleDefinitionId;

    /*
     * The principal ID assigned to the role. This maps to the ID inside the
     * Active Directory. It can point to a user, service principal, or security
     * group.
     */
    @JsonProperty(value = "properties.principalId", required = true)
    private String principalId;

    /*
     * The delegation flag used for creating a role assignment
     */
    @JsonProperty(value = "properties.canDelegate")
    private Boolean canDelegate;

    /**
     * Get the roleDefinitionId property: The role definition ID used in the
     * role assignment.
     * 
     * @return the roleDefinitionId value.
     */
    public String roleDefinitionId() {
        return this.roleDefinitionId;
    }

    /**
     * Set the roleDefinitionId property: The role definition ID used in the
     * role assignment.
     * 
     * @param roleDefinitionId the roleDefinitionId value to set.
     * @return the RoleAssignmentCreateParameters object itself.
     */
    public RoleAssignmentCreateParameters withRoleDefinitionId(String roleDefinitionId) {
        this.roleDefinitionId = roleDefinitionId;
        return this;
    }

    /**
     * Get the principalId property: The principal ID assigned to the role.
     * This maps to the ID inside the Active Directory. It can point to a user,
     * service principal, or security group.
     * 
     * @return the principalId value.
     */
    public String principalId() {
        return this.principalId;
    }

    /**
     * Set the principalId property: The principal ID assigned to the role.
     * This maps to the ID inside the Active Directory. It can point to a user,
     * service principal, or security group.
     * 
     * @param principalId the principalId value to set.
     * @return the RoleAssignmentCreateParameters object itself.
     */
    public RoleAssignmentCreateParameters withPrincipalId(String principalId) {
        this.principalId = principalId;
        return this;
    }

    /**
     * Get the canDelegate property: The delegation flag used for creating a
     * role assignment.
     * 
     * @return the canDelegate value.
     */
    public Boolean canDelegate() {
        return this.canDelegate;
    }

    /**
     * Set the canDelegate property: The delegation flag used for creating a
     * role assignment.
     * 
     * @param canDelegate the canDelegate value to set.
     * @return the RoleAssignmentCreateParameters object itself.
     */
    public RoleAssignmentCreateParameters withCanDelegate(Boolean canDelegate) {
        this.canDelegate = canDelegate;
        return this;
    }
}
