package org.example.serviceregistry

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
//@EnableEurekaServer
class ServiceRegistryApplication

fun main(args: Array<String>) {
    runApplication<ServiceRegistryApplication>(*args)
}
