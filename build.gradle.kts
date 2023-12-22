plugins {
    kotlin("jvm") version "1.9.21"
}

sourceSets {
    main {
        kotlin.srcDir("main")
    }
}

dependencies{
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.1.0")
}

tasks {
    wrapper {
        gradleVersion = "8.5"
    }
}
