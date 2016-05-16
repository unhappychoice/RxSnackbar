package com.github.unhappychoice.rxsnackbar

import android.support.design.widget.Snackbar
import android.view.View
import rx.Observable
import rx.Subscription
import rx.lang.kotlin.subscribeWith

fun <T> Observable<T>.withNextSnackBar(
        view: View?,
        message: String? = null,
        length: Int = Snackbar.LENGTH_SHORT,
        actionName: String? = null,
        action: ((View?) -> Unit)? = null
): Observable<T> {
    return this.doOnNext { data ->
        val m = message ?: data.toString()
        makeSnackbar(view, m, length, actionName, action)?.show()
    }
}

fun <T> Observable<T>.withErrorSnackBar(
        view: View?,
        message: String? = null,
        length: Int = Snackbar.LENGTH_SHORT,
        actionName: String? = null,
        action: ((View?) -> Unit)? = null
): Observable<T> {
    return this.doOnError { e ->
        val m = message ?: e.message!!
        makeSnackbar(view, m, length, actionName, action)?.show()
    }
}

fun <T> Observable<T>.withCompletedSnackBar(
        view: View?,
        message: String,
        length: Int = Snackbar.LENGTH_SHORT,
        actionName: String? = null,
        action: ((View?) -> Unit)? = null
): Observable<T> {
    return this.doOnCompleted {
        makeSnackbar(view, message, length, actionName, action)?.show()
    }
}

fun <T> Observable<T>.subscribeNextWithSnackBar(
        view: View?,
        message: String? = null,
        length: Int = Snackbar.LENGTH_SHORT,
        actionName: String? = null,
        action: ((View?) -> Unit)? = null
): Subscription {
    return this.subscribeWith {
        onNext { data ->
            val m = message ?: data.toString()
            makeSnackbar(view, m, length, actionName, action)?.show()
        }
    }
}

fun <T> Observable<T>.subscribeErrorWithSnackBar(
        view: View?,
        message: String? = null,
        length: Int = Snackbar.LENGTH_SHORT,
        actionName: String? = null,
        action: ((View?) -> Unit)? = null
): Subscription {
    return this.subscribeWith {
        onError { e ->
            val m = message ?: e.message!!
            makeSnackbar(view, m, length, actionName, action)?.show()
        }
    }
}

fun <T> Observable<T>.subscribeCompletedWithSnackBar(
        view: View?,
        message: String,
        length: Int = Snackbar.LENGTH_SHORT,
        actionName: String? = null,
        action: ((View?) -> Unit)? = null
): Subscription {
    return this.subscribeWith {
        onCompleted {
            makeSnackbar(view, message, length, actionName, action)?.show()
        }
    }
}

private fun makeSnackbar(
        view: View?,
        message: String,
        length: Int = Snackbar.LENGTH_SHORT,
        actionName: String? = null,
        action: ((View?) -> Unit)? = null
): Snackbar? {
    return view?.let {
        val bar = Snackbar.make(it, message, length)
        if (actionName != null && action != null) bar.setAction(actionName, action)
        bar
    }
}