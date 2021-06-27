val user = System.getProperty("repoUser") ?: System.getenv("repoUser")
val pwd = System.getProperty("repoPassword") ?: System.getenv("repoPassword")

//网络上有两种Maven仓库，分别是mavenCenter()和jCenter():
//1. Maven Central 则是由sonatype.org维护的Maven仓库 仓库地址无效 http://jcenter.bintray.com/
//2. jcenter是一个由 bintray.com维护的Maven仓库。仓库地址 https://oss.sonatype.org/content/repositories/releases/
//实际地址 https://repo1.maven.org/maven2
buildscript {
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
}