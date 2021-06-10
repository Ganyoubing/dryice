val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val exposed_version: String by project
val h2_version: String by project

plugins {
    application
    kotlin("plugin.serialization") version "1.5.0"
    kotlin("jvm") version "1.5.10"
}

group = "com.example"
version = "0.0.1"



application {
    mainClass.set("com.example.ApplicationKt")
}
//网络上有两种Maven仓库，分别是mavenCenter()和jCenter():
//1. Maven Central 则是由sonatype.org维护的Maven仓库 仓库地址无效 http://jcenter.bintray.com/
//2. jcenter是一个由 bintray.com维护的Maven仓库。仓库地址 https://oss.sonatype.org/content/repositories/releases/
repositories {
    jcenter()
}

dependencies {
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    //添加exposed框架（SQL框架）
    implementation("org.jetbrains.exposed:exposed-core:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-dao:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-java-time:$exposed_version")
    implementation("com.h2database:h2:$h2_version")

    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
}