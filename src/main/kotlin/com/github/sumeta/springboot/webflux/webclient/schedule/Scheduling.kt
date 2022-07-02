package com.github.sumeta.springboot.webflux.webclient.schedule

import com.github.sumeta.springboot.webflux.webclient.features.host.HostService
import kotlinx.coroutines.runBlocking
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
@EnableScheduling
class Scheduling(private val hostService: HostService) {

    @Scheduled(cron = "0 */10 * * * ?") // run every 10 minutes
    fun doUpdate(){
        runBlocking {
            hostService.update()
        }
    }

}