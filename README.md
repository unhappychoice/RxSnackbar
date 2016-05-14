# RxSnackbar
[![](https://jitpack.io/v/unhappychoice/rxsnackbar.svg)](https://jitpack.io/#unhappychoice/rxsnackbar)

This is RxJava / RxKotlin adapter for Android Snackbar

## Installation

### Gradle

```groovy
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
dependencies {
    compile 'com.github.unhappychoice:rxsnackbar:$version'
}
```

### Maven

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.github.unhappychoice</groupId>
    <artifactId>rxsnackbar</artifactId>
    <version>$version</version>
</dependency>
```

## Usage

```kotlin
Observable.just(true)
    .withNextSnackBar(this, "Data is coming!") // will show "Number is comming!"
    .subscribe()

Observable.just("Some data")
    .withNextSnackBar(this) // will show Some data
    .subscribe()
```

## LICENSE 
see [LICENSE](./LICENSE)
