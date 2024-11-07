# dev-test-containers

This repo holds projects to understand dev containers and test containers.

folders - `before-boot-3.1.0` and `after-boot-3.1.0` - are on usage of test containers for both testing and local development

Spring Boot 3.1.0 introduced great support for Testcontainers that’ll not only make writing integration tests easier, but also make local development a breeze. Prior to Spring Boot 3.1.0, we had to use @DynamicPropertySource to set the dynamic properties obtained from containers started by Testcontainers. Then, Spring Boot 3.1.0 introduced the new concept of ServiceConnection. This automatically configures the necessary Spring Boot properties for the supporting containers.


## Prerequisite

* Java 17
* Gradle
* Docker desktop or Docker engine


## References
* [https://www.docker.com/blog/spring-boot-application-testing-and-development-with-testcontainers/](https://www.docker.com/blog/spring-boot-application-testing-and-development-with-testcontainers/)
* [Service Connections](https://docs.spring.io/spring-boot/docs/3.1.0/reference/htmlsingle/#features.testing.testcontainers.service-connections)