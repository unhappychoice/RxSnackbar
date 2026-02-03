package com.github.unhappychoice.rxsnackbar

import com.google.android.material.snackbar.Snackbar
import android.view.View
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy

fun <T> Observable<T>.withNextSnackBar(
        view: View?,
        message: String? = null,
        length: Int = Snackbar.LENGTH_SHORT,
        actionName: String? = null,
        action: ((View?) -> Unit)? = null
): Observable<T> =
    doOnNext { data -> makeSnackbar(view, message ?: data.toString(), length, actionName, action)?.show() }

fun <T> Observable<T>.withErrorSnackBar(
        view: View?,
        message: String? = null,
        length: Int = Snackbar.LENGTH_SHORT,
        actionName: String? = null,
        action: ((View?) -> Unit)? = null
): Observable<T> =
    doOnError { e -> makeSnackbar(view, message ?: e.message!!, length, actionName, action)?.show() }

fun <T> Observable<T>.withCompletedSnackBar(
        view: View?,
        message: String,
        length: Int = Snackbar.LENGTH_SHORT,
        actionName: String? = null,
        action: ((View?) -> Unit)? = null
): Observable<T> =
    doOnComplete { makeSnackbar(view, message, length, actionName, action)?.show() }

fun <T: Any> Observable<T>.subscribeNextWithSnackBar(
        view: View?,
        message: String? = null,
        length: Int = Snackbar.LENGTH_SHORT,
        actionName: String? = null,
        action: ((View?) -> Unit)? = null
): Disposable =
    subscribeBy(
        onError = {},
        onNext = { data -> makeSnackbar(view, message ?: data.toString(), length, actionName, action)?.show() }
    )

fun <T: Any> Observable<T>.subscribeErrorWithSnackBar(
        view: View?,
        message: String? = null,
        length: Int = Snackbar.LENGTH_SHORT,
        actionName: String? = null,
        action: ((View?) -> Unit)? = null
): Disposable =
    subscribeBy(
        onError = { e -> makeSnackbar(view, message ?: e.message!!, length, actionName, action)?.show() }
    )

fun <T: Any> Observable<T>.subscribeCompletedWithSnackBar(
        view: View?,
        message: String,
        length: Int = Snackbar.LENGTH_SHORT,
        actionName: String? = null,
        action: ((View?) -> Unit)? = null
): Disposable =
    subscribeBy(
        onError = {},
        onComplete = { makeSnackbar(view, message, length, actionName, action)?.show() }
    )

private fun makeSnackbar(
        view: View?,
        message: String,
        length: Int = Snackbar.LENGTH_SHORT,
        actionName: String? = null,
        action: ((View?) -> Unit)? = null
): Snackbar? = view?.let {
    val bar = Snackbar.make(it, message, length)
    if (actionName != null && action != null) bar.setAction(actionName, action)
    bar
}