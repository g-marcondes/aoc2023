plugins {
    kotlin("jvm") version "1.9.21"
}

sourceSets {
    main {
        kotlin.srcDir("main")
    }
}

tasks {
    wrapper {
        gradleVersion = "8.5"
    }
}
