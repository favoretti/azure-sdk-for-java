// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License. See License.txt in the project root for
// license information.
// 
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.management.appservice;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/**
 * Defines values for AppServiceCertificateOrderPropertiesAppServiceCertificateNotRenewableReasonsItem.
 */
public final class AppServiceCertificateOrderPropertiesAppServiceCertificateNotRenewableReasonsItem extends ExpandableStringEnum<AppServiceCertificateOrderPropertiesAppServiceCertificateNotRenewableReasonsItem> {
    /**
     * Static value RegistrationStatusNotSupportedForRenewal for AppServiceCertificateOrderPropertiesAppServiceCertificateNotRenewableReasonsItem.
     */
    public static final AppServiceCertificateOrderPropertiesAppServiceCertificateNotRenewableReasonsItem REGISTRATION_STATUS_NOT_SUPPORTED_FOR_RENEWAL = fromString("RegistrationStatusNotSupportedForRenewal");

    /**
     * Static value ExpirationNotInRenewalTimeRange for AppServiceCertificateOrderPropertiesAppServiceCertificateNotRenewableReasonsItem.
     */
    public static final AppServiceCertificateOrderPropertiesAppServiceCertificateNotRenewableReasonsItem EXPIRATION_NOT_IN_RENEWAL_TIME_RANGE = fromString("ExpirationNotInRenewalTimeRange");

    /**
     * Static value SubscriptionNotActive for AppServiceCertificateOrderPropertiesAppServiceCertificateNotRenewableReasonsItem.
     */
    public static final AppServiceCertificateOrderPropertiesAppServiceCertificateNotRenewableReasonsItem SUBSCRIPTION_NOT_ACTIVE = fromString("SubscriptionNotActive");

    /**
     * Creates or finds a AppServiceCertificateOrderPropertiesAppServiceCertificateNotRenewableReasonsItem from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding AppServiceCertificateOrderPropertiesAppServiceCertificateNotRenewableReasonsItem.
     */
    @JsonCreator
    public static AppServiceCertificateOrderPropertiesAppServiceCertificateNotRenewableReasonsItem fromString(String name) {
        return fromString(name, AppServiceCertificateOrderPropertiesAppServiceCertificateNotRenewableReasonsItem.class);
    }

    /**
     * @return known AppServiceCertificateOrderPropertiesAppServiceCertificateNotRenewableReasonsItem values.
     */
    public static Collection<AppServiceCertificateOrderPropertiesAppServiceCertificateNotRenewableReasonsItem> values() {
        return values(AppServiceCertificateOrderPropertiesAppServiceCertificateNotRenewableReasonsItem.class);
    }
}
