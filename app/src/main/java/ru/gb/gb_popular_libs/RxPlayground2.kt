package ru.gb.gb_popular_libs

import io.reactivex.rxjava3.core.*
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import java.io.IOException
import java.util.concurrent.TimeUnit

fun main() {
    Observable.empty<String>()
    Observable
        .error<String>(RuntimeException("error"))
        .doOnNext { signal -> println(signal) }
        .doOnError { error -> println("1: $error") }
        .doOnError { error -> println("2: $error") }
        .doOnError { error -> println("3: $error") }
        .doOnComplete { println("doOnComplete 1") }
        .onErrorResumeNext { error ->
            when (error) {
                //is IOException -> Observable.empty()
                //is IllegalArgumentException -> Observable.just("hello")
                else -> Observable.error(error)
            }
        }
        .doOnError { error -> println("4: $error") }
        .retryWhen { error -> error.delay(5L, TimeUnit.SECONDS) }
        .subscribe({ println("doOnNext: $it") }, { println("doOnError: $it") }, { println("doOnComplete") })

    val observableObserver = object : Observer<String> {
        override fun onSubscribe(d: Disposable) {
            TODO("Not yet implemented")
        }

        override fun onNext(t: String) {
            TODO("Not yet implemented")
        }

        override fun onError(e: Throwable) {
            TODO("Not yet implemented")
        }

        override fun onComplete() {
            TODO("Not yet implemented")
        }
    }

    Single.just(1).doOnSuccess { }.doOnError { }
    Single.error<String>(RuntimeException())

    object : SingleObserver<String> {
        override fun onSubscribe(d: Disposable) {
            TODO("Not yet implemented")
        }

        override fun onSuccess(t: String) {
            TODO("Not yet implemented")
        }

        override fun onError(e: Throwable) {
            TODO("Not yet implemented")
        }
    }

    Maybe.just(1).doOnSuccess { }.doOnError { }.doOnComplete { }
    Maybe.empty<String>()
    Maybe.error<String>(RuntimeException())

    object : MaybeObserver<String> {
        override fun onSubscribe(d: Disposable) {
            TODO("Not yet implemented")
        }

        override fun onSuccess(t: String) {
            TODO("Not yet implemented")
        }

        override fun onError(e: Throwable) {
            TODO("Not yet implemented")
        }

        override fun onComplete() {
            TODO("Not yet implemented")
        }
    }

    Completable.complete().doOnComplete { }.doOnError { }
    Completable.error(RuntimeException("error"))

    object : CompletableObserver {
        override fun onSubscribe(d: Disposable) {
            TODO("Not yet implemented")
        }

        override fun onComplete() {
            TODO("Not yet implemented")
        }

        override fun onError(e: Throwable) {
            TODO("Not yet implemented")
        }
    }

    val countDownCounter = 10L

    val hotObservable =
        Observable
            .intervalRange(1, countDownCounter, 0, 1, TimeUnit.SECONDS)
            .map { count -> countDownCounter - count }
            .doOnNext { println("hot: $it") }
            .doOnComplete { println("hot countdown!") }
            .publish()

    val counter1 =
        hotObservable
            .subscribe(
                { println("count1: ${it.inc()}") },
                {},
                ::onTimerCompleted
            )

    val counter2 =
        hotObservable
            .delay(5L, TimeUnit.SECONDS)
            .subscribe(
                { println("count2: ${it.inc()}") },
                {},
                ::onTimerCompleted
            )

    val counter3 =
        hotObservable
            .subscribe(
                { println("count3: ${it.inc()}") },
                {},
                ::onTimerCompleted
            )

    //hotObservable.connect()

    RxJavaPlugins.setErrorHandler { error -> error.cause }

    Thread.sleep(65000)
}

private fun onTimerCount(count: Long) {
    println("count: ${count.inc()}")
}

private fun onTimerCompleted() {
    println("countdown!")
}