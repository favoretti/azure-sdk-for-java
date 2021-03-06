// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License. See License.txt in the project root for
// license information.
// 
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.management.network;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.JsonFlatten;
import com.azure.core.management.SubResource;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The AzureFirewallIPConfiguration model.
 */
@JsonFlatten
@Fluent
public class AzureFirewallIPConfiguration extends SubResource {
    /*
     * Name of the resource that is unique within a resource group. This name
     * can be used to access the resource.
     */
    @JsonProperty(value = "name")
    private String name;

    /*
     * A unique read-only string that changes whenever the resource is updated.
     */
    @JsonProperty(value = "etag", access = JsonProperty.Access.WRITE_ONLY)
    private String etag;

    /*
     * The Firewall Internal Load Balancer IP to be used as the next hop in
     * User Defined Routes.
     */
    @JsonProperty(value = "properties.privateIPAddress", access = JsonProperty.Access.WRITE_ONLY)
    private String privateIPAddress;

    /*
     * Reference to another subresource.
     */
    @JsonProperty(value = "properties.subnet")
    private SubResource subnet;

    /*
     * Reference to another subresource.
     */
    @JsonProperty(value = "properties.publicIPAddress")
    private SubResource publicIPAddress;

    /*
     * The current provisioning state.
     */
    @JsonProperty(value = "properties.provisioningState")
    private ProvisioningState provisioningState;

    /**
     * Get the name property: Name of the resource that is unique within a
     * resource group. This name can be used to access the resource.
     * 
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: Name of the resource that is unique within a
     * resource group. This name can be used to access the resource.
     * 
     * @param name the name value to set.
     * @return the AzureFirewallIPConfiguration object itself.
     */
    public AzureFirewallIPConfiguration withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the etag property: A unique read-only string that changes whenever
     * the resource is updated.
     * 
     * @return the etag value.
     */
    public String etag() {
        return this.etag;
    }

    /**
     * Get the privateIPAddress property: The Firewall Internal Load Balancer
     * IP to be used as the next hop in User Defined Routes.
     * 
     * @return the privateIPAddress value.
     */
    public String privateIPAddress() {
        return this.privateIPAddress;
    }

    /**
     * Get the subnet property: Reference to another subresource.
     * 
     * @return the subnet value.
     */
    public SubResource subnet() {
        return this.subnet;
    }

    /**
     * Set the subnet property: Reference to another subresource.
     * 
     * @param subnet the subnet value to set.
     * @return the AzureFirewallIPConfiguration object itself.
     */
    public AzureFirewallIPConfiguration withSubnet(SubResource subnet) {
        this.subnet = subnet;
        return this;
    }

    /**
     * Get the publicIPAddress property: Reference to another subresource.
     * 
     * @return the publicIPAddress value.
     */
    public SubResource publicIPAddress() {
        return this.publicIPAddress;
    }

    /**
     * Set the publicIPAddress property: Reference to another subresource.
     * 
     * @param publicIPAddress the publicIPAddress value to set.
     * @return the AzureFirewallIPConfiguration object itself.
     */
    public AzureFirewallIPConfiguration withPublicIPAddress(SubResource publicIPAddress) {
        this.publicIPAddress = publicIPAddress;
        return this;
    }

    /**
     * Get the provisioningState property: The current provisioning state.
     * 
     * @return the provisioningState value.
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Set the provisioningState property: The current provisioning state.
     * 
     * @param provisioningState the provisioningState value to set.
     * @return the AzureFirewallIPConfiguration object itself.
     */
    public AzureFirewallIPConfiguration withProvisioningState(ProvisioningState provisioningState) {
        this.provisioningState = provisioningState;
        return this;
    }
}
