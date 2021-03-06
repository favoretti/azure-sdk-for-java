// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License. See License.txt in the project root for
// license information.
// 
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.management.network.models;

import com.azure.core.annotation.ExpectedResponses;
import com.azure.core.annotation.Get;
import com.azure.core.annotation.Host;
import com.azure.core.annotation.HostParam;
import com.azure.core.annotation.PathParam;
import com.azure.core.annotation.QueryParam;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceInterface;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.annotation.UnexpectedResponseExceptionType;
import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.PagedResponse;
import com.azure.core.http.rest.PagedResponseBase;
import com.azure.core.http.rest.RestProxy;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.management.network.ErrorException;
import reactor.core.publisher.Mono;

/**
 * An instance of this class provides access to all the operations defined in
 * VpnSiteLinks.
 */
public final class VpnSiteLinksInner {
    /**
     * The proxy service used to perform REST calls.
     */
    private VpnSiteLinksService service;

    /**
     * The service client containing this operation class.
     */
    private NetworkManagementClientImpl client;

    /**
     * Initializes an instance of VpnSiteLinksInner.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    public VpnSiteLinksInner(NetworkManagementClientImpl client) {
        this.service = RestProxy.create(VpnSiteLinksService.class, client.getHttpPipeline(), client.getSerializerAdapter());
        this.client = client;
    }

    /**
     * The interface defining all the services for
     * NetworkManagementClientVpnSiteLinks to be used by the proxy service to
     * perform REST calls.
     */
    @Host("{$host}")
    @ServiceInterface(name = "NetworkManagementClientVpnSiteLinks")
    private interface VpnSiteLinksService {
        @Get("/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Network/vpnSites/{vpnSiteName}/vpnSiteLinks/{vpnSiteLinkName}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorException.class)
        Mono<SimpleResponse<VpnSiteLinkInner>> get(@HostParam("$host") String host, @PathParam("subscriptionId") String subscriptionId, @PathParam("resourceGroupName") String resourceGroupName, @PathParam("vpnSiteName") String vpnSiteName, @PathParam("vpnSiteLinkName") String vpnSiteLinkName, @QueryParam("api-version") String apiVersion);

        @Get("/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Network/vpnSites/{vpnSiteName}/vpnSiteLinks")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorException.class)
        Mono<SimpleResponse<ListVpnSiteLinksResultInner>> listByVpnSite(@HostParam("$host") String host, @PathParam("subscriptionId") String subscriptionId, @PathParam("resourceGroupName") String resourceGroupName, @PathParam("vpnSiteName") String vpnSiteName, @QueryParam("api-version") String apiVersion);

        @Get("{nextLink}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorException.class)
        Mono<SimpleResponse<ListVpnSiteLinksResultInner>> listByVpnSiteNext(@PathParam(value = "nextLink", encoded = true) String nextLink);
    }

    /**
     * Retrieves the details of a VPN site link.
     * 
     * @param resourceGroupName 
     * @param vpnSiteName 
     * @param vpnSiteLinkName 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<VpnSiteLinkInner>> getWithResponseAsync(String resourceGroupName, String vpnSiteName, String vpnSiteLinkName) {
        final String apiVersion = "2019-06-01";
        return service.get(this.client.getHost(), this.client.getSubscriptionId(), resourceGroupName, vpnSiteName, vpnSiteLinkName, apiVersion);
    }

    /**
     * Retrieves the details of a VPN site link.
     * 
     * @param resourceGroupName 
     * @param vpnSiteName 
     * @param vpnSiteLinkName 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<VpnSiteLinkInner> getAsync(String resourceGroupName, String vpnSiteName, String vpnSiteLinkName) {
        return getWithResponseAsync(resourceGroupName, vpnSiteName, vpnSiteLinkName)
            .flatMap((SimpleResponse<VpnSiteLinkInner> res) -> {
                if (res.getValue() != null) {
                    return Mono.just(res.getValue());
                } else {
                    return Mono.empty();
                }
            });
    }

    /**
     * Retrieves the details of a VPN site link.
     * 
     * @param resourceGroupName 
     * @param vpnSiteName 
     * @param vpnSiteLinkName 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public VpnSiteLinkInner get(String resourceGroupName, String vpnSiteName, String vpnSiteLinkName) {
        return getAsync(resourceGroupName, vpnSiteName, vpnSiteLinkName).block();
    }

    /**
     * Lists all the vpnSiteLinks in a resource group for a vpn site.
     * 
     * @param resourceGroupName 
     * @param vpnSiteName 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<VpnSiteLinkInner>> listByVpnSiteSinglePageAsync(String resourceGroupName, String vpnSiteName) {
        final String apiVersion = "2019-06-01";
        return service.listByVpnSite(this.client.getHost(), this.client.getSubscriptionId(), resourceGroupName, vpnSiteName, apiVersion).map(res -> new PagedResponseBase<>(
            res.getRequest(),
            res.getStatusCode(),
            res.getHeaders(),
            res.getValue().value(),
            res.getValue().nextLink(),
            null));
    }

    /**
     * Lists all the vpnSiteLinks in a resource group for a vpn site.
     * 
     * @param resourceGroupName 
     * @param vpnSiteName 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<VpnSiteLinkInner> listByVpnSiteAsync(String resourceGroupName, String vpnSiteName) {
        return new PagedFlux<>(
            () -> listByVpnSiteSinglePageAsync(resourceGroupName, vpnSiteName),
            nextLink -> listByVpnSiteNextSinglePageAsync(nextLink));
    }

    /**
     * Lists all the vpnSiteLinks in a resource group for a vpn site.
     * 
     * @param resourceGroupName 
     * @param vpnSiteName 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<VpnSiteLinkInner> listByVpnSite(String resourceGroupName, String vpnSiteName) {
        return new PagedIterable<>(listByVpnSiteAsync(resourceGroupName, vpnSiteName));
    }

    /**
     * Get the next page of items.
     * 
     * @param nextLink null
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<VpnSiteLinkInner>> listByVpnSiteNextSinglePageAsync(String nextLink) {
        return service.listByVpnSiteNext(nextLink).map(res -> new PagedResponseBase<>(
            res.getRequest(),
            res.getStatusCode(),
            res.getHeaders(),
            res.getValue().value(),
            res.getValue().nextLink(),
            null));
    }
}
