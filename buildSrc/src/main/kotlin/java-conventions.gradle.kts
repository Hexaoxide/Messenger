plugins {
    `java-library`
    `maven-publish`
}

repositories {
    mavenCentral()
    maven("https://nexus.egg82.me/repository/maven-releases/")
}

java {
    withSourcesJar()
    withJavadocJar()
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

publishing {
    repositories.maven {
        name = "Repo"
        url = uri("https://repo.jpenilla.xyz/snapshots")
        credentials {
            username = System.getenv("REPO_USER")
            password = System.getenv("REPO_TOKEN")
        }
    }
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks.withType<JavaCompile>() {
    options.encoding = Charsets.UTF_8.name()
    options.release.set(17)
}

tasks.withType<Javadoc>() {
    options.encoding = Charsets.UTF_8.name()
}
