// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License. See License.txt in the project root for
// license information.
// 
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.management.compute;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The ContainerServiceDiagnosticsProfile model.
 */
@Fluent
public final class ContainerServiceDiagnosticsProfile {
    /*
     * Profile for diagnostics on the container service VMs.
     */
    @JsonProperty(value = "vmDiagnostics", required = true)
    private ContainerServiceVMDiagnostics vmDiagnostics;

    /**
     * Get the vmDiagnostics property: Profile for diagnostics on the container
     * service VMs.
     * 
     * @return the vmDiagnostics value.
     */
    public ContainerServiceVMDiagnostics vmDiagnostics() {
        return this.vmDiagnostics;
    }

    /**
     * Set the vmDiagnostics property: Profile for diagnostics on the container
     * service VMs.
     * 
     * @param vmDiagnostics the vmDiagnostics value to set.
     * @return the ContainerServiceDiagnosticsProfile object itself.
     */
    public ContainerServiceDiagnosticsProfile withVmDiagnostics(ContainerServiceVMDiagnostics vmDiagnostics) {
        this.vmDiagnostics = vmDiagnostics;
        return this;
    }
}
