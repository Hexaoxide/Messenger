plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.7.0"
}

rootProject.name = "messenger-parent"

include(":messenger-redis")
include(":messenger-raft")
include(":messenger-nats")
include(":messenger-api")
include(":messenger-rabbitmq")
project(":messenger-redis").projectDir = file("Redis")
project(":messenger-raft").projectDir = file("Raft")
project(":messenger-nats").projectDir = file("NATS")
project(":messenger-api").projectDir = file("API")
project(":messenger-rabbitmq").projectDir = file("RabbitMQ")
