/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.servicebus.v2017_04_01;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a filter which is a composition of an expression and an action
 * that is executed in the pub/sub pipeline.
 */
public class SqlFilter {
    /**
     * The SQL expression. e.g. MyProperty='ABC'.
     */
    @JsonProperty(value = "sqlExpression")
    private String sqlExpression;

    /**
     * This property is reserved for future use. An integer value showing the
     * compatibility level, currently hard-coded to 20.
     */
    @JsonProperty(value = "compatibilityLevel", access = JsonProperty.Access.WRITE_ONLY)
    private Integer compatibilityLevel;

    /**
     * Value that indicates whether the rule action requires preprocessing.
     */
    @JsonProperty(value = "requiresPreprocessing")
    private Boolean requiresPreprocessing;

    /**
     * Get the SQL expression. e.g. MyProperty='ABC'.
     *
     * @return the sqlExpression value
     */
    public String sqlExpression() {
        return this.sqlExpression;
    }

    /**
     * Set the SQL expression. e.g. MyProperty='ABC'.
     *
     * @param sqlExpression the sqlExpression value to set
     * @return the SqlFilter object itself.
     */
    public SqlFilter withSqlExpression(String sqlExpression) {
        this.sqlExpression = sqlExpression;
        return this;
    }

    /**
     * Get this property is reserved for future use. An integer value showing the compatibility level, currently hard-coded to 20.
     *
     * @return the compatibilityLevel value
     */
    public Integer compatibilityLevel() {
        return this.compatibilityLevel;
    }

    /**
     * Get value that indicates whether the rule action requires preprocessing.
     *
     * @return the requiresPreprocessing value
     */
    public Boolean requiresPreprocessing() {
        return this.requiresPreprocessing;
    }

    /**
     * Set value that indicates whether the rule action requires preprocessing.
     *
     * @param requiresPreprocessing the requiresPreprocessing value to set
     * @return the SqlFilter object itself.
     */
    public SqlFilter withRequiresPreprocessing(Boolean requiresPreprocessing) {
        this.requiresPreprocessing = requiresPreprocessing;
        return this;
    }

}