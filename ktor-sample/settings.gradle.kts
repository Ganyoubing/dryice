rootProject.name = "ktor-sample"

fun defineSubProject(name: String, path: String) {
    val prjName = "ktor-$name"
    include(prjName)
    project(":$prjName").projectDir = file(path)
}

defineSubProject("webservice-contract", "webservice/contract")
defineSubProject("webservice-service", "webservice/service")
defineSubProject("webservice-rest", "webservice/rest")