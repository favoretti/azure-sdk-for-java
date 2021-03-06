// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.management.monitor.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * The EventDataCollection model.
 */
@Fluent
public final class EventDataCollectionInner {
    /*
     * this list that includes the Azure audit logs.
     */
    @JsonProperty(value = "value", required = true)
    private List<EventDataInner> value;

    /*
     * Provides the link to retrieve the next set of events.
     */
    @JsonProperty(value = "nextLink")
    private String nextLink;

    /**
     * Get the value property: this list that includes the Azure audit logs.
     * 
     * @return the value value.
     */
    public List<EventDataInner> value() {
        return this.value;
    }

    /**
     * Set the value property: this list that includes the Azure audit logs.
     * 
     * @param value the value value to set.
     * @return the EventDataCollectionInner object itself.
     */
    public EventDataCollectionInner withValue(List<EventDataInner> value) {
        this.value = value;
        return this;
    }

    /**
     * Get the nextLink property: Provides the link to retrieve the next set of
     * events.
     * 
     * @return the nextLink value.
     */
    public String nextLink() {
        return this.nextLink;
    }

    /**
     * Set the nextLink property: Provides the link to retrieve the next set of
     * events.
     * 
     * @param nextLink the nextLink value to set.
     * @return the EventDataCollectionInner object itself.
     */
    public EventDataCollectionInner withNextLink(String nextLink) {
        this.nextLink = nextLink;
        return this;
    }
}
