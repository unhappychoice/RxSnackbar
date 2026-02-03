package com.github.unhappychoice.rxsnackbar

import io.reactivex.Observable
import org.junit.Test

class ObservableSnackbarTest {

    @Test
    fun `withNextSnackBar passes through values`() {
        val results = mutableListOf<Int>()

        Observable.just(1, 2, 3)
            .withNextSnackBar(null, "test")
            .subscribe { results.add(it) }

        assert(results == listOf(1, 2, 3))
    }

    @Test
    fun `withErrorSnackBar passes through values on success`() {
        val results = mutableListOf<Int>()

        Observable.just(1, 2, 3)
            .withErrorSnackBar(null, "error")
            .subscribe { results.add(it) }

        assert(results == listOf(1, 2, 3))
    }

    @Test
    fun `withCompletedSnackBar passes through values`() {
        val results = mutableListOf<Int>()
        var completed = false

        Observable.just(1, 2, 3)
            .withCompletedSnackBar(null, "done")
            .subscribe(
                { results.add(it) },
                {},
                { completed = true }
            )

        assert(results == listOf(1, 2, 3))
        assert(completed)
    }

    @Test
    fun `subscribeNextWithSnackBar receives values`() {
        val results = mutableListOf<Int>()

        Observable.just(1, 2, 3)
            .doOnNext { results.add(it) }
            .subscribeNextWithSnackBar(null, "test")

        assert(results == listOf(1, 2, 3))
    }

    @Test
    fun `withNextSnackBar with null view does not crash`() {
        Observable.just("test")
            .withNextSnackBar(null)
            .test()
            .assertValue("test")
            .assertComplete()
    }

    @Test
    fun `withErrorSnackBar with null view does not crash on error`() {
        Observable.error<String>(RuntimeException("test error"))
            .withErrorSnackBar(null)
            .test()
            .assertError(RuntimeException::class.java)
    }
}
