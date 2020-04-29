// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.core.amqp.implementation.handler;

import com.azure.core.util.CoreUtils;
import org.apache.qpid.proton.engine.BaseHandler;
import org.apache.qpid.proton.engine.EndpointState;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.ReplayProcessor;
import reactor.core.publisher.UnicastProcessor;

import java.io.Closeable;

public abstract class Handler extends BaseHandler implements Closeable {
    private final ReplayProcessor<EndpointState> endpointStateProcessor =
        ReplayProcessor.cacheLastOrDefault(EndpointState.UNINITIALIZED);
    private final UnicastProcessor<Throwable> errorContextProcessor = UnicastProcessor.create();
    private final FluxSink<EndpointState> endpointSink = endpointStateProcessor.sink();
    private final FluxSink<Throwable> errorSink = errorContextProcessor.sink();
    private final String connectionId;
    private final String hostname;
    private final String customHostName;

    Handler(final String connectionId, final String hostname, final String customHostName) {
        this.connectionId = connectionId;
        this.hostname = hostname;
        this.customHostName = customHostName;
    }

    public String getConnectionId() {
        return connectionId;
    }

    public String getHostname() {
        return CoreUtils.isNullOrEmpty(customHostName) ? hostname : customHostName;
    }

    public String getCustomHostName() {
        return customHostName;
    }

    public Flux<EndpointState> getEndpointStates() {
        return endpointStateProcessor.distinct();
    }

    public Flux<Throwable> getErrors() {
        return errorContextProcessor;
    }

    void onNext(EndpointState state) {
        endpointSink.next(state);

        if (state == EndpointState.CLOSED) {
            endpointSink.complete();
        }
    }

    void onNext(Throwable context) {
        errorSink.next(context);
    }

    @Override
    public void close() {
        endpointSink.complete();
        errorSink.complete();
    }
}
