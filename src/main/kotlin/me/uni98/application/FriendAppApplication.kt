package me.uni98.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.slf4j.LoggerFactory

@SpringBootApplication
class FriendAppApplication : CommandLineRunner {

    @Value("\${app.name:DefaultAppName}")
    private lateinit var appName: String

    override fun run(vararg args: String?) {
        log.info("FriendAppApplication is starting up...")
        log.info("Application name from properties: {}", appName)
        log.info("Performing initial setup tasks...")
        // Add more application-specific startup logic here if needed
        log.info("Application '{}' started successfully!", appName)
    }

    companion object {
        private val log = LoggerFactory.getLogger(FriendAppApplication::class.java)
    }
}

fun main(args: Array<String>) {
    runApplication<FriendAppApplication>(*args)
}
