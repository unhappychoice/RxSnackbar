# RxSnackbar
[![](https://jitpack.io/v/unhappychoice/rxsnackbar.svg)](https://jitpack.io/#unhappychoice/rxsnackbar)
![CircleCI](https://img.shields.io/circleci/build/github/unhappychoice/RxSnackbar.svg)
[![Libraries.io dependency status for GitHub repo](https://img.shields.io/librariesio/github/unhappychoice/RxSnackbar.svg)](https://libraries.io/github/unhappychoice/RxSnackbar)
![GitHub](https://img.shields.io/github/license/unhappychoice/RxSnackbar.svg)

This is RxJava / RxKotlin adapter for Android Snackbar

## Usage

### Kotlin

```kotlin
Observable.just(true)
    .withNextSnackBar(view, "Data is coming!") // will show "Number is comming!"
    .subscribe()

// will show "Some data" and Undo action
Observable.just("Some data")
    .withNextSnackBar(view, actionName = "Undo") { view -> someUndoAction() } 
    .subscribe()
```

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

## LICENSE
see [LICENSE](./LICENSE)
