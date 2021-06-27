
val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val exposed_version: String by project
val h2_version: String by project
val mysql_version: String by project
val okhttp_version: String by project
val exile_version: String by project

group = "com.example"
version = "0.0.1"

val user = System.getProperty("repoUser") ?: System.getenv("repoUser")
val pwd = System.getProperty("repoPassword") ?: System.getenv("repoPassword")

//网络上有两种Maven仓库，分别是mavenCenter()和jCenter():
//1. Maven Central 则是由sonatype.org维护的Maven仓库 仓库地址无效 http://jcenter.bintray.com/
//2. jcenter是一个由 bintray.com维护的Maven仓库。仓库地址 https://oss.sonatype.org/content/repositories/releases/
//实际地址 https://repo1.maven.org/maven2
if (user == null || pwd == null) {
    println("Missing username and password of maven repository. Set in ~/.gradle/gradle.properties .\nMore information at http://wiki.ekuaibao.com/pages/viewpage.action?pageId=6230137 .")
    repositories {
        mavenLocal()
        jcenter()
        mavenCentral()
        maven("https://kotlin.bintray.com/ktor")
        maven("https://plugins.gradle.org/m2/")
    }
} else {
    repositories {
        mavenLocal()
        jcenter()
        mavenCentral()
        maven("https://kotlin.bintray.com/ktor")
        maven("https://repo.ekuaibao.com/repository/java-group/") {
            credentials {
                username = user
                password = pwd
            }
        }
        maven("https://plugins.gradle.org/m2/")
    }
}


plugins {
    application
    kotlin("plugin.serialization") version "1.5.0"
    kotlin("jvm") version "1.5.10"
}



application {
    mainClass.set("com.example.ApplicationKt")
}


dependencies {
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.1")
    //添加exposed框架（SQL框架）
    implementation("org.jetbrains.exposed:exposed-core:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-dao:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-java-time:$exposed_version")


    implementation("io.ktor:ktor-jackson:$ktor_version")

    //mysql依赖
    implementation ("mysql:mysql-connector-java:$mysql_version")

    implementation ("com.squareup.okhttp3:okhttp:$okhttp_version")

    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests:$ktor_version")

    //引入exile 框架
    implementation("com.ekuaibao.exile:exile-java:$exile_version")
    implementation("com.ekuaibao.exile:exile-jersey:$exile_version")
    implementation("com.ekuaibao.exile:exile-redis:$exile_version")

    implementation(fileTree(mapOf("dir" to "libs","include" to listOf("*.jar"))))

}
