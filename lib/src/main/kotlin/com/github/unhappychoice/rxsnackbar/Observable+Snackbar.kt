package com.github.unhappychoice.rxsnackbar

import android.support.design.widget.Snackbar
import android.view.View
import rx.Observable
import rx.Subscription
import rx.lang.kotlin.subscribeWith

fun <T> Observable<T>.withNextSnackBar(view: View?, message: String? = null): Observable<T> {
    return this.doOnNext { data ->
        view?.let {
            Snackbar.make(it, message ?: data.toString(), Snackbar.LENGTH_SHORT).show()
        }
    }
}

fun <T> Observable<T>.withErrorSnackBar(view: View?, message: String? = null): Observable<T> {
    return this.doOnError { e ->
        view?.let {
            Snackbar.make(it, message ?: e.message!!, Snackbar.LENGTH_SHORT).show()
        }
    }
}

fun <T> Observable<T>.withCompletedSnackBar(view: View?, message: String): Observable<T> {
    return this.doOnCompleted {
        view?.let {
            Snackbar.make(it, message, Snackbar.LENGTH_SHORT).show()
        }
    }
}

fun <T> Observable<T>.subscribeNextWithSnackBar(view: View?, message: String? = null): Subscription {
    return this.subscribeWith {
        onNext { data ->
            view?.let {
                Snackbar.make(it, message ?: data.toString(), Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}

fun <T> Observable<T>.subscribeErrorWithSnackBar(view: View?, message: String? = null): Subscription {
    return this.subscribeWith {
        onError { e ->
            view?.let {
                Snackbar.make(it, message ?: e.message!!, Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}

fun <T> Observable<T>.subscribeCompletedWithSnackBar(view: View?, message: String): Subscription {
    return this.subscribeWith {
        onCompleted {
            view?.let {
                Snackbar.make(it, message, Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}
