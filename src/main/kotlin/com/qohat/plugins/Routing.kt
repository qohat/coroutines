package com.qohat.plugins

import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*

fun Application.configureRouting() {
    // Starting point for a Ktor app:
    routing {
        get("/orgs/{org}/repos?per_page=100") {
            call.respondText("Hello World!")
        }
    }

}
