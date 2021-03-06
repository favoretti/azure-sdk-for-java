// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License. See License.txt in the project root for
// license information.
// 
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.management.resources.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * The FeatureOperationsListResult model.
 */
@Fluent
public final class FeatureOperationsListResultInner {
    /*
     * The array of features.
     */
    @JsonProperty(value = "value")
    private List<FeatureResultInner> value;

    /*
     * The URL to use for getting the next set of results.
     */
    @JsonProperty(value = "nextLink")
    private String nextLink;

    /**
     * Get the value property: The array of features.
     * 
     * @return the value value.
     */
    public List<FeatureResultInner> getValue() {
        return this.value;
    }

    /**
     * Set the value property: The array of features.
     * 
     * @param value the value value to set.
     * @return the FeatureOperationsListResultInner object itself.
     */
    public FeatureOperationsListResultInner setValue(List<FeatureResultInner> value) {
        this.value = value;
        return this;
    }

    /**
     * Get the nextLink property: The URL to use for getting the next set of
     * results.
     * 
     * @return the nextLink value.
     */
    public String getNextLink() {
        return this.nextLink;
    }

    /**
     * Set the nextLink property: The URL to use for getting the next set of
     * results.
     * 
     * @param nextLink the nextLink value to set.
     * @return the FeatureOperationsListResultInner object itself.
     */
    public FeatureOperationsListResultInner setNextLink(String nextLink) {
        this.nextLink = nextLink;
        return this;
    }
}
