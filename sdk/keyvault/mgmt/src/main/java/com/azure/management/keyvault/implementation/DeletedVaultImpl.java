/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 */

package com.azure.management.keyvault.implementation;

import java.time.OffsetDateTime;
import java.util.Map;

import com.azure.management.keyvault.models.DeletedVaultInner;
import com.azure.management.keyvault.DeletedVault;
import com.azure.management.resources.fluentcore.model.implementation.WrapperImpl;

/**
 * Deleted vault information with extended details.
 */
public class DeletedVaultImpl extends WrapperImpl<DeletedVaultInner> implements DeletedVault {

    DeletedVaultImpl(DeletedVaultInner inner) {
        super(inner);
    }

    @Override
    public String name() {
        return inner().name();
    }

    @Override
    public String id() {
        return inner().getId();
    }

    @Override
    public String location() {
        return inner().properties().location();
    }

    @Override
    public OffsetDateTime deletionDate() {
        return inner().properties().deletionDate();
    }

    @Override
    public OffsetDateTime scheduledPurgeDate() {
        return inner().properties().scheduledPurgeDate();
    }

    @Override
    public Map<String, String> tags() {
        return inner().properties().tags();
    }

}
