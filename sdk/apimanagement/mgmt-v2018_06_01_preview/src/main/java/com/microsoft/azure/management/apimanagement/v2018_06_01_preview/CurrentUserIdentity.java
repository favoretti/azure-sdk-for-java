/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.apimanagement.v2018_06_01_preview;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The CurrentUserIdentity model.
 */
public class CurrentUserIdentity {
    /**
     * API Management service user id.
     */
    @JsonProperty(value = "id")
    private String id;

    /**
     * Get aPI Management service user id.
     *
     * @return the id value
     */
    public String id() {
        return this.id;
    }

    /**
     * Set aPI Management service user id.
     *
     * @param id the id value to set
     * @return the CurrentUserIdentity object itself.
     */
    public CurrentUserIdentity withId(String id) {
        this.id = id;
        return this;
    }

}
