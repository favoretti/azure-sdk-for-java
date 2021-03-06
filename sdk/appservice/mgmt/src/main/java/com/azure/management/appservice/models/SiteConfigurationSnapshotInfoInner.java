// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License. See License.txt in the project root for
// license information.
// 
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.management.appservice.models;

import com.azure.core.annotation.Immutable;
import com.azure.core.annotation.JsonFlatten;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.azure.management.appservice.ProxyOnlyResource;
import java.time.OffsetDateTime;

/**
 * The SiteConfigurationSnapshotInfo model.
 */
@JsonFlatten
@Immutable
public class SiteConfigurationSnapshotInfoInner extends ProxyOnlyResource {
    /*
     * The time the snapshot was taken.
     */
    @JsonProperty(value = "properties.time", access = JsonProperty.Access.WRITE_ONLY)
    private OffsetDateTime time;

    /*
     * The id of the snapshot
     */
    @JsonProperty(value = "properties.snapshotId", access = JsonProperty.Access.WRITE_ONLY)
    private Integer snapshotId;

    /**
     * Get the time property: The time the snapshot was taken.
     * 
     * @return the time value.
     */
    public OffsetDateTime time() {
        return this.time;
    }

    /**
     * Get the snapshotId property: The id of the snapshot.
     * 
     * @return the snapshotId value.
     */
    public Integer snapshotId() {
        return this.snapshotId;
    }
}
