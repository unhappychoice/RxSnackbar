# RxSnackbar
[![](https://jitpack.io/v/unhappychoice/rxsnackbar.svg)](https://jitpack.io/#unhappychoice/rxsnackbar)

This is RxJava / RxKotlin adapter for Android Snackbar

## Usage

### Kotlin

```kotlin:
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
