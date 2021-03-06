// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.management.sql.models;

import com.azure.core.annotation.Delete;
import com.azure.core.annotation.ExpectedResponses;
import com.azure.core.annotation.Get;
import com.azure.core.annotation.Headers;
import com.azure.core.annotation.Host;
import com.azure.core.annotation.HostParam;
import com.azure.core.annotation.PathParam;
import com.azure.core.annotation.Post;
import com.azure.core.annotation.QueryParam;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceInterface;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.annotation.UnexpectedResponseExceptionType;
import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.PagedResponse;
import com.azure.core.http.rest.PagedResponseBase;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.RestProxy;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.management.CloudException;
import com.azure.core.util.polling.AsyncPollResponse;
import java.nio.ByteBuffer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * An instance of this class provides access to all the operations defined in
 * ReplicationLinks.
 */
public final class ReplicationLinksInner {
    /**
     * The proxy service used to perform REST calls.
     */
    private ReplicationLinksService service;

    /**
     * The service client containing this operation class.
     */
    private SqlManagementClientImpl client;

    /**
     * Initializes an instance of ReplicationLinksInner.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    ReplicationLinksInner(SqlManagementClientImpl client) {
        this.service = RestProxy.create(ReplicationLinksService.class, client.getHttpPipeline(), client.getSerializerAdapter());
        this.client = client;
    }

    /**
     * The interface defining all the services for
     * SqlManagementClientReplicationLinks to be used by the proxy service to
     * perform REST calls.
     */
    @Host("{$host}")
    @ServiceInterface(name = "SqlManagementClientReplicationLinks")
    private interface ReplicationLinksService {
        @Headers({ "Accept: application/json;q=0.9", "Content-Type: application/json" })
        @Delete("/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Sql/servers/{serverName}/databases/{databaseName}/replicationLinks/{linkId}")
        @ExpectedResponses({200, 204})
        @UnexpectedResponseExceptionType(CloudException.class)
        Mono<Response<Void>> delete(@HostParam("$host") String host, @QueryParam("api-version") String apiVersion, @PathParam("subscriptionId") String subscriptionId, @PathParam("resourceGroupName") String resourceGroupName, @PathParam("serverName") String serverName, @PathParam("databaseName") String databaseName, @PathParam("linkId") String linkId);

        @Headers({ "Accept: application/json", "Content-Type: application/json" })
        @Get("/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Sql/servers/{serverName}/databases/{databaseName}/replicationLinks/{linkId}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(CloudException.class)
        Mono<SimpleResponse<ReplicationLinkInner>> get(@HostParam("$host") String host, @QueryParam("api-version") String apiVersion, @PathParam("subscriptionId") String subscriptionId, @PathParam("resourceGroupName") String resourceGroupName, @PathParam("serverName") String serverName, @PathParam("databaseName") String databaseName, @PathParam("linkId") String linkId);

        @Headers({ "Accept: application/json;q=0.9", "Content-Type: application/json" })
        @Post("/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Sql/servers/{serverName}/databases/{databaseName}/replicationLinks/{linkId}/failover")
        @ExpectedResponses({202, 204})
        @UnexpectedResponseExceptionType(CloudException.class)
        Mono<SimpleResponse<Flux<ByteBuffer>>> failover(@HostParam("$host") String host, @QueryParam("api-version") String apiVersion, @PathParam("subscriptionId") String subscriptionId, @PathParam("resourceGroupName") String resourceGroupName, @PathParam("serverName") String serverName, @PathParam("databaseName") String databaseName, @PathParam("linkId") String linkId);

        @Headers({ "Accept: application/json;q=0.9", "Content-Type: application/json" })
        @Post("/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Sql/servers/{serverName}/databases/{databaseName}/replicationLinks/{linkId}/forceFailoverAllowDataLoss")
        @ExpectedResponses({202, 204})
        @UnexpectedResponseExceptionType(CloudException.class)
        Mono<SimpleResponse<Flux<ByteBuffer>>> failoverAllowDataLoss(@HostParam("$host") String host, @QueryParam("api-version") String apiVersion, @PathParam("subscriptionId") String subscriptionId, @PathParam("resourceGroupName") String resourceGroupName, @PathParam("serverName") String serverName, @PathParam("databaseName") String databaseName, @PathParam("linkId") String linkId);

        @Headers({ "Accept: application/json", "Content-Type: application/json" })
        @Get("/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Sql/servers/{serverName}/databases/{databaseName}/replicationLinks")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(CloudException.class)
        Mono<SimpleResponse<ReplicationLinkListResultInner>> listByDatabase(@HostParam("$host") String host, @QueryParam("api-version") String apiVersion, @PathParam("subscriptionId") String subscriptionId, @PathParam("resourceGroupName") String resourceGroupName, @PathParam("serverName") String serverName, @PathParam("databaseName") String databaseName);

        @Headers({ "Accept: application/json;q=0.9", "Content-Type: application/json" })
        @Post("/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Sql/servers/{serverName}/databases/{databaseName}/replicationLinks/{linkId}/failover")
        @ExpectedResponses({202, 204})
        @UnexpectedResponseExceptionType(CloudException.class)
        Mono<Response<Void>> beginFailover(@HostParam("$host") String host, @QueryParam("api-version") String apiVersion, @PathParam("subscriptionId") String subscriptionId, @PathParam("resourceGroupName") String resourceGroupName, @PathParam("serverName") String serverName, @PathParam("databaseName") String databaseName, @PathParam("linkId") String linkId);

        @Headers({ "Accept: application/json;q=0.9", "Content-Type: application/json" })
        @Post("/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Sql/servers/{serverName}/databases/{databaseName}/replicationLinks/{linkId}/forceFailoverAllowDataLoss")
        @ExpectedResponses({202, 204})
        @UnexpectedResponseExceptionType(CloudException.class)
        Mono<Response<Void>> beginFailoverAllowDataLoss(@HostParam("$host") String host, @QueryParam("api-version") String apiVersion, @PathParam("subscriptionId") String subscriptionId, @PathParam("resourceGroupName") String resourceGroupName, @PathParam("serverName") String serverName, @PathParam("databaseName") String databaseName, @PathParam("linkId") String linkId);
    }

    /**
     * Deletes a database replication link. Cannot be done during failover.
     * 
     * @param resourceGroupName 
     * @param serverName 
     * @param databaseName 
     * @param linkId 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> deleteWithResponseAsync(String resourceGroupName, String serverName, String databaseName, String linkId) {
        final String apiVersion = "2014-04-01";
        return service.delete(this.client.getHost(), apiVersion, this.client.getSubscriptionId(), resourceGroupName, serverName, databaseName, linkId);
    }

    /**
     * Deletes a database replication link. Cannot be done during failover.
     * 
     * @param resourceGroupName 
     * @param serverName 
     * @param databaseName 
     * @param linkId 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> deleteAsync(String resourceGroupName, String serverName, String databaseName, String linkId) {
        return deleteWithResponseAsync(resourceGroupName, serverName, databaseName, linkId)
            .flatMap((Response<Void> res) -> Mono.empty());
    }

    /**
     * Deletes a database replication link. Cannot be done during failover.
     * 
     * @param resourceGroupName 
     * @param serverName 
     * @param databaseName 
     * @param linkId 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void delete(String resourceGroupName, String serverName, String databaseName, String linkId) {
        deleteAsync(resourceGroupName, serverName, databaseName, linkId).block();
    }

    /**
     * Gets a database replication link.
     * 
     * @param resourceGroupName 
     * @param serverName 
     * @param databaseName 
     * @param linkId 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<ReplicationLinkInner>> getWithResponseAsync(String resourceGroupName, String serverName, String databaseName, String linkId) {
        final String apiVersion = "2014-04-01";
        return service.get(this.client.getHost(), apiVersion, this.client.getSubscriptionId(), resourceGroupName, serverName, databaseName, linkId);
    }

    /**
     * Gets a database replication link.
     * 
     * @param resourceGroupName 
     * @param serverName 
     * @param databaseName 
     * @param linkId 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<ReplicationLinkInner> getAsync(String resourceGroupName, String serverName, String databaseName, String linkId) {
        return getWithResponseAsync(resourceGroupName, serverName, databaseName, linkId)
            .flatMap((SimpleResponse<ReplicationLinkInner> res) -> {
                if (res.getValue() != null) {
                    return Mono.just(res.getValue());
                } else {
                    return Mono.empty();
                }
            });
    }

    /**
     * Gets a database replication link.
     * 
     * @param resourceGroupName 
     * @param serverName 
     * @param databaseName 
     * @param linkId 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ReplicationLinkInner get(String resourceGroupName, String serverName, String databaseName, String linkId) {
        return getAsync(resourceGroupName, serverName, databaseName, linkId).block();
    }

    /**
     * Sets which replica database is primary by failing over from the current primary replica database.
     * 
     * @param resourceGroupName 
     * @param serverName 
     * @param databaseName 
     * @param linkId 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<Flux<ByteBuffer>>> failoverWithResponseAsync(String resourceGroupName, String serverName, String databaseName, String linkId) {
        final String apiVersion = "2014-04-01";
        return service.failover(this.client.getHost(), apiVersion, this.client.getSubscriptionId(), resourceGroupName, serverName, databaseName, linkId);
    }

    /**
     * Sets which replica database is primary by failing over from the current primary replica database.
     * 
     * @param resourceGroupName 
     * @param serverName 
     * @param databaseName 
     * @param linkId 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> failoverAsync(String resourceGroupName, String serverName, String databaseName, String linkId) {
        Mono<SimpleResponse<Flux<ByteBuffer>>> mono = failoverWithResponseAsync(resourceGroupName, serverName, databaseName, linkId);
        return this.client.<Void, Void>getLroResultAsync(mono, this.client.getHttpPipeline(), Void.class, Void.class)
            .last()
            .flatMap(AsyncPollResponse::getFinalResult);
    }

    /**
     * Sets which replica database is primary by failing over from the current primary replica database.
     * 
     * @param resourceGroupName 
     * @param serverName 
     * @param databaseName 
     * @param linkId 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void failover(String resourceGroupName, String serverName, String databaseName, String linkId) {
        failoverAsync(resourceGroupName, serverName, databaseName, linkId).block();
    }

    /**
     * Sets which replica database is primary by failing over from the current primary replica database. This operation might result in data loss.
     * 
     * @param resourceGroupName 
     * @param serverName 
     * @param databaseName 
     * @param linkId 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<Flux<ByteBuffer>>> failoverAllowDataLossWithResponseAsync(String resourceGroupName, String serverName, String databaseName, String linkId) {
        final String apiVersion = "2014-04-01";
        return service.failoverAllowDataLoss(this.client.getHost(), apiVersion, this.client.getSubscriptionId(), resourceGroupName, serverName, databaseName, linkId);
    }

    /**
     * Sets which replica database is primary by failing over from the current primary replica database. This operation might result in data loss.
     * 
     * @param resourceGroupName 
     * @param serverName 
     * @param databaseName 
     * @param linkId 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> failoverAllowDataLossAsync(String resourceGroupName, String serverName, String databaseName, String linkId) {
        Mono<SimpleResponse<Flux<ByteBuffer>>> mono = failoverAllowDataLossWithResponseAsync(resourceGroupName, serverName, databaseName, linkId);
        return this.client.<Void, Void>getLroResultAsync(mono, this.client.getHttpPipeline(), Void.class, Void.class)
            .last()
            .flatMap(AsyncPollResponse::getFinalResult);
    }

    /**
     * Sets which replica database is primary by failing over from the current primary replica database. This operation might result in data loss.
     * 
     * @param resourceGroupName 
     * @param serverName 
     * @param databaseName 
     * @param linkId 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void failoverAllowDataLoss(String resourceGroupName, String serverName, String databaseName, String linkId) {
        failoverAllowDataLossAsync(resourceGroupName, serverName, databaseName, linkId).block();
    }

    /**
     * Lists a database's replication links.
     * 
     * @param resourceGroupName 
     * @param serverName 
     * @param databaseName 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<ReplicationLinkInner>> listByDatabaseSinglePageAsync(String resourceGroupName, String serverName, String databaseName) {
        final String apiVersion = "2014-04-01";
        return service.listByDatabase(this.client.getHost(), apiVersion, this.client.getSubscriptionId(), resourceGroupName, serverName, databaseName)
            .map(res -> new PagedResponseBase<>(
                res.getRequest(),
                res.getStatusCode(),
                res.getHeaders(),
                res.getValue().value(),
                null,
                null));
    }

    /**
     * Lists a database's replication links.
     * 
     * @param resourceGroupName 
     * @param serverName 
     * @param databaseName 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<ReplicationLinkInner> listByDatabaseAsync(String resourceGroupName, String serverName, String databaseName) {
        return new PagedFlux<>(
            () -> listByDatabaseSinglePageAsync(resourceGroupName, serverName, databaseName));
    }

    /**
     * Lists a database's replication links.
     * 
     * @param resourceGroupName 
     * @param serverName 
     * @param databaseName 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<ReplicationLinkInner> listByDatabase(String resourceGroupName, String serverName, String databaseName) {
        return new PagedIterable<>(listByDatabaseAsync(resourceGroupName, serverName, databaseName));
    }

    /**
     * Sets which replica database is primary by failing over from the current primary replica database.
     * 
     * @param resourceGroupName 
     * @param serverName 
     * @param databaseName 
     * @param linkId 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> beginFailoverWithResponseAsync(String resourceGroupName, String serverName, String databaseName, String linkId) {
        final String apiVersion = "2014-04-01";
        return service.beginFailover(this.client.getHost(), apiVersion, this.client.getSubscriptionId(), resourceGroupName, serverName, databaseName, linkId);
    }

    /**
     * Sets which replica database is primary by failing over from the current primary replica database.
     * 
     * @param resourceGroupName 
     * @param serverName 
     * @param databaseName 
     * @param linkId 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> beginFailoverAsync(String resourceGroupName, String serverName, String databaseName, String linkId) {
        return beginFailoverWithResponseAsync(resourceGroupName, serverName, databaseName, linkId)
            .flatMap((Response<Void> res) -> Mono.empty());
    }

    /**
     * Sets which replica database is primary by failing over from the current primary replica database.
     * 
     * @param resourceGroupName 
     * @param serverName 
     * @param databaseName 
     * @param linkId 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void beginFailover(String resourceGroupName, String serverName, String databaseName, String linkId) {
        beginFailoverAsync(resourceGroupName, serverName, databaseName, linkId).block();
    }

    /**
     * Sets which replica database is primary by failing over from the current primary replica database. This operation might result in data loss.
     * 
     * @param resourceGroupName 
     * @param serverName 
     * @param databaseName 
     * @param linkId 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> beginFailoverAllowDataLossWithResponseAsync(String resourceGroupName, String serverName, String databaseName, String linkId) {
        final String apiVersion = "2014-04-01";
        return service.beginFailoverAllowDataLoss(this.client.getHost(), apiVersion, this.client.getSubscriptionId(), resourceGroupName, serverName, databaseName, linkId);
    }

    /**
     * Sets which replica database is primary by failing over from the current primary replica database. This operation might result in data loss.
     * 
     * @param resourceGroupName 
     * @param serverName 
     * @param databaseName 
     * @param linkId 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> beginFailoverAllowDataLossAsync(String resourceGroupName, String serverName, String databaseName, String linkId) {
        return beginFailoverAllowDataLossWithResponseAsync(resourceGroupName, serverName, databaseName, linkId)
            .flatMap((Response<Void> res) -> Mono.empty());
    }

    /**
     * Sets which replica database is primary by failing over from the current primary replica database. This operation might result in data loss.
     * 
     * @param resourceGroupName 
     * @param serverName 
     * @param databaseName 
     * @param linkId 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void beginFailoverAllowDataLoss(String resourceGroupName, String serverName, String databaseName, String linkId) {
        beginFailoverAllowDataLossAsync(resourceGroupName, serverName, databaseName, linkId).block();
    }
}
