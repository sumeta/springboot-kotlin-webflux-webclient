package com.github.sumeta.springboot.webflux.webclient.features.host

import com.github.sumeta.springboot.webflux.webclient.webclients.worker.model.WorkerRequest
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*

@Component
class HostHandler(
    private val hostService: HostService
    ) {

    suspend fun get(serverRequest: ServerRequest):ServerResponse =
        hostService.get().let {
            ServerResponse.ok().json().bodyValueAndAwait(it)
        }

    suspend fun update(serverRequest: ServerRequest) =
        hostService.update().let {
            ServerResponse.ok().json().bodyValueAndAwait(it)
        }

}