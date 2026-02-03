# RxSnackbar
[![](https://jitpack.io/v/unhappychoice/rxsnackbar.svg)](https://jitpack.io/#unhappychoice/rxsnackbar)
![GitHub](https://img.shields.io/github/license/unhappychoice/RxSnackbar.svg)

RxJava 2 / RxKotlin adapter for Android Snackbar (AndroidX)

## Requirements

- RxJava 2
- AndroidX (Material Components)
- minSdk 21

## Usage

### Kotlin

```kotlin
Observable.just(true)
    .withNextSnackBar(view, "Data is coming!")
    .subscribe()

// with action
Observable.just("Some data")
    .withNextSnackBar(view, actionName = "Undo") { view -> someUndoAction() } 
    .subscribe()

// error handling
Observable.just("data")
    .withErrorSnackBar(view, "Something went wrong")
    .subscribe()
```

## Installation

### Gradle

```groovy
repositories {
    maven { url "https://jitpack.io" }
}

dependencies {
    implementation 'com.github.unhappychoice:rxsnackbar:2.0.0'
}
```

## LICENSE
see [LICENSE](./LICENSE)
