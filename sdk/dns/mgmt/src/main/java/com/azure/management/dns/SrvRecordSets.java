/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */
package com.azure.management.dns;

import com.azure.core.annotation.Fluent;

/**
 *  Entry point to SRV record sets in a DNS zone.
 */
@Fluent
public interface SrvRecordSets extends DnsRecordSets<SrvRecordSet> {
}