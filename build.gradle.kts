plugins {
	java
	id("org.springframework.boot") version "3.2.5"
	id("io.spring.dependency-management") version "1.1.4"
	id("io.freefair.sass-java") version "8.6"
}

group = "com.adrian"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.postgresql:postgresql")
	implementation("org.springframework.security:spring-security-web")
	implementation("org.springframework.security:spring-security-config")
	implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity6")
	implementation ("org.springframework.boot:spring-boot-starter-validation")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

val copyScss by tasks.registering {
	copy {
		from("${projectDir}/build/resources/main/particles.css")
		into("${projectDir}/build/resources/main/static/css")
	}
}
copyScss {
	dependsOn(tasks.compileSass)
	mustRunAfter("compileSass")
}
tasks.bootRun {
	dependsOn("copyScss")
}
