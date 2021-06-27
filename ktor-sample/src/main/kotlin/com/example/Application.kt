package com.example

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

fun main() {
    //创建具有给定工厂的嵌入式服务器
    //那这里用的就是jetty，轻量级的web服务器和servlet引擎
    //嵌入式WEB服务器常见的有：Lighttpd, Shttpd, Thttpd, Boa, Mini_httpd, Appweb, Goahead
    // Netty  Java 网络编程框架
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
        routing {
            get("/") {
                call.respondText("Hello, world!", ContentType.Text.Html)
            }
        }
    }.start(wait = true)
}
