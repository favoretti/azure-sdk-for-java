/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.costmanagement.v2019_11_01.implementation;

import com.microsoft.azure.management.costmanagement.v2019_11_01.QueryResult;
import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import java.util.List;
import com.microsoft.azure.management.costmanagement.v2019_11_01.QueryColumn;
import java.util.Map;

class QueryResultImpl extends WrapperImpl<QueryResultInner> implements QueryResult {
    private final CostManagementManager manager;
    QueryResultImpl(QueryResultInner inner, CostManagementManager manager) {
        super(inner);
        this.manager = manager;
    }

    @Override
    public CostManagementManager manager() {
        return this.manager;
    }

    @Override
    public List<QueryColumn> columns() {
        return this.inner().columns();
    }

    @Override
    public String id() {
        return this.inner().id();
    }

    @Override
    public String name() {
        return this.inner().name();
    }

    @Override
    public String nextLink() {
        return this.inner().nextLink();
    }

    @Override
    public List<List<Object>> rows() {
        return this.inner().rows();
    }

    @Override
    public Map<String, String> tags() {
        return this.inner().tags();
    }

    @Override
    public String type() {
        return this.inner().type();
    }

}
