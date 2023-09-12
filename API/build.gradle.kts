plugins {
    id("java-conventions")
}

dependencies {
    testImplementation(libs.jupiterApi)
    compileOnly(libs.fastutil)
    compileOnly(libs.zstdJni)
    compileOnly(libs.nettyBuffer)
    compileOnly(libs.caffeine)
    compileOnly(libs.slf4jApi)
    compileOnly(libs.jbAnnotations)
}
