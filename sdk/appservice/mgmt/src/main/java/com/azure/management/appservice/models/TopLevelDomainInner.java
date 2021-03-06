// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License. See License.txt in the project root for
// license information.
// 
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.management.appservice.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.JsonFlatten;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.azure.management.appservice.ProxyOnlyResource;

/**
 * The TopLevelDomain model.
 */
@JsonFlatten
@Fluent
public class TopLevelDomainInner extends ProxyOnlyResource {
    /*
     * If <code>true</code>, then the top level domain supports domain privacy;
     * otherwise, <code>false</code>.
     */
    @JsonProperty(value = "properties.privacy")
    private Boolean privacy;

    /**
     * Get the privacy property: If &lt;code&gt;true&lt;/code&gt;, then the top
     * level domain supports domain privacy; otherwise,
     * &lt;code&gt;false&lt;/code&gt;.
     * 
     * @return the privacy value.
     */
    public Boolean privacy() {
        return this.privacy;
    }

    /**
     * Set the privacy property: If &lt;code&gt;true&lt;/code&gt;, then the top
     * level domain supports domain privacy; otherwise,
     * &lt;code&gt;false&lt;/code&gt;.
     * 
     * @param privacy the privacy value to set.
     * @return the TopLevelDomainInner object itself.
     */
    public TopLevelDomainInner withPrivacy(Boolean privacy) {
        this.privacy = privacy;
        return this;
    }
}
