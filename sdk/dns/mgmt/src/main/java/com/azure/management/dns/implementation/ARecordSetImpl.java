/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */
package com.azure.management.dns.implementation;

import com.azure.management.dns.models.RecordSetInner;
import com.azure.management.dns.ARecord;
import com.azure.management.dns.ARecordSet;
import com.azure.management.dns.RecordType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implementation of ARecordSet.
 */
class ARecordSetImpl
        extends DnsRecordSetImpl
        implements ARecordSet {
    ARecordSetImpl(final String name, final DnsZoneImpl parent, final RecordSetInner innerModel) {
        super(name, RecordType.A.toString(), parent, innerModel);
    }

    static ARecordSetImpl newRecordSet(final String name, final DnsZoneImpl parent) {
        return new ARecordSetImpl(name, parent,
                new RecordSetInner()
                    .withARecords(new ArrayList<>()));
    }

    @Override
    public List<String> ipv4Addresses() {
        List<String> ipv4Addresses = new ArrayList<>();
        if (this.inner().aRecords() != null) {
            for (ARecord aRecord : this.inner().aRecords()) {
                ipv4Addresses.add(aRecord.ipv4Address());
            }
        }
        return Collections.unmodifiableList(ipv4Addresses);
    }

    @Override
    protected RecordSetInner prepareForUpdate(RecordSetInner resource) {
        if (this.inner().aRecords() != null && this.inner().aRecords().size() > 0) {
            if (resource.aRecords() == null) {
                resource.withARecords(new ArrayList<>());
            }

            resource.aRecords().addAll(this.inner().aRecords());
            this.inner().aRecords().clear();
        }

        if (this.recordSetRemoveInfo.aRecords().size() > 0) {
            if (resource.aRecords() != null) {
                for (ARecord recordToRemove : this.recordSetRemoveInfo.aRecords()) {
                    for (ARecord record : resource.aRecords()) {
                        if (record.ipv4Address().equalsIgnoreCase(recordToRemove.ipv4Address())) {
                            resource.aRecords().remove(record);
                            break;
                        }
                    }
                }
            }
            this.recordSetRemoveInfo.aRecords().clear();
        }
        return resource;
    }
}
