# Quarkus Blog project ![Java CI with Gradle](https://github.com/ElinaValieva/quarkus-blog-app/workflows/Java%20CI%20with%20Gradle/badge.svg?branch=master)

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./gradlew quarkusDev
```

## Packaging and running the application

The application can be packaged using `./gradlew quarkusBuild`.
It produces the `blog-1.0.0-SNAPSHOT-runner.jar` file in the `build` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `build/lib` directory.

The application is now runnable using `java -jar build/blog-1.0.0-SNAPSHOT-runner.jar`.

If you want to build an _über-jar_, just add the `--uber-jar` option to the command line:
```
./gradlew quarkusBuild --uber-jar
```

## Creating a native executable

You can create a native executable using: `./gradlew buildNative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./gradlew buildNative --docker-build=true`.

You can then execute your native executable with: `./build/blog-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/gradle-tooling#building-a-native-executable.

&nbsp;
## Openshift deployment :triangular_flag_on_post:
```console
oc new-app quay.io/quarkus/ubi-quarkus-native-s2i:19.3.1-java11~https://github.com/Elina/quarkus-quickstarts.git --context-dir=. --name=quarkus-quickstart-native
oc expose svc/quarkus-quickstart-native
```
