// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.management.resources.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * The TagsListResult model.
 */
@Fluent
public final class TagsListResultInner {
    /*
     * An array of tags.
     */
    @JsonProperty(value = "value")
    private List<TagDetailsInner> value;

    /*
     * The URL to use for getting the next set of results.
     */
    @JsonProperty(value = "nextLink", access = JsonProperty.Access.WRITE_ONLY)
    private String nextLink;

    /**
     * Get the value property: An array of tags.
     * 
     * @return the value value.
     */
    public List<TagDetailsInner> getValue() {
        return this.value;
    }

    /**
     * Set the value property: An array of tags.
     * 
     * @param value the value value to set.
     * @return the TagsListResultInner object itself.
     */
    public TagsListResultInner setValue(List<TagDetailsInner> value) {
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
}
