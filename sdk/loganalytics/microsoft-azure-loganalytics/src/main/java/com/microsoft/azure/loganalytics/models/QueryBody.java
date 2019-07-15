/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.loganalytics.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Analytics query. Learn more about the [Analytics query
 * syntax](https://azure.microsoft.com/documentation/articles/app-insights-analytics-reference/).
 */
public class QueryBody {
    /**
     * The query to execute.
     */
    @JsonProperty(value = "query", required = true)
    private String query;

    /**
     * Optional. The timespan over which to query data. This is an ISO8601 time
     * period value.  This timespan is applied in addition to any that are
     * specified in the query expression.
     */
    @JsonProperty(value = "timespan")
    private String timespan;

    /**
     * A list of workspaces that are included in the query.
     */
    @JsonProperty(value = "workspaces")
    private List<String> workspaces;

    /**
     * Get the query to execute.
     *
     * @return the query value
     */
    public String query() {
        return this.query;
    }

    /**
     * Set the query to execute.
     *
     * @param query the query value to set
     * @return the QueryBody object itself.
     */
    public QueryBody withQuery(String query) {
        this.query = query;
        return this;
    }

    /**
     * Get optional. The timespan over which to query data. This is an ISO8601 time period value.  This timespan is applied in addition to any that are specified in the query expression.
     *
     * @return the timespan value
     */
    public String timespan() {
        return this.timespan;
    }

    /**
     * Set optional. The timespan over which to query data. This is an ISO8601 time period value.  This timespan is applied in addition to any that are specified in the query expression.
     *
     * @param timespan the timespan value to set
     * @return the QueryBody object itself.
     */
    public QueryBody withTimespan(String timespan) {
        this.timespan = timespan;
        return this;
    }

    /**
     * Get a list of workspaces that are included in the query.
     *
     * @return the workspaces value
     */
    public List<String> workspaces() {
        return this.workspaces;
    }

    /**
     * Set a list of workspaces that are included in the query.
     *
     * @param workspaces the workspaces value to set
     * @return the QueryBody object itself.
     */
    public QueryBody withWorkspaces(List<String> workspaces) {
        this.workspaces = workspaces;
        return this;
    }

}