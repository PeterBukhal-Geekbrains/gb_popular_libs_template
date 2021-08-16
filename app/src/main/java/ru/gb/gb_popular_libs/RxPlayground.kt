package ru.gb.gb_popular_libs

import io.reactivex.*
import java.lang.RuntimeException
import java.util.concurrent.TimeUnit.SECONDS

fun nonRx(): Int = 1

fun main() {
    val disposable =
        Observable
            .just(1,2,3)
            .doOnSubscribe { System.out.println("onSubscribe") }
            .doOnNext {  }
            .doOnNext {  }
            .doOnNext {  }
            .doOnError {  }
            .doOnComplete {  }
//            .subscribe({ counter ->
//                System.out.println("onNext: $counter")
//            }, { error ->
//                System.out.println("onError: $error")
//            }, { //
//                System.out.println("onComplete")
//            })

    // Прерываем подписку на источник
    //disposable.dispose()

    // Завершается без эмита событий (данных)
    Observable.empty<Int>()

    Observable.fromArray(arrayOf(1, 1, 1))

    Observable.fromIterable(listOf(1, 1, 1))

    Observable.timer(10L, SECONDS)

    // Для оборачивания синхронного кода
    Observable.fromCallable { nonRx() }

    // Для оборачивания асинхронного кода
    // обработка ошибок ручная
    Observable.create<Int> { emitter ->
        try {
            emitter.onNext(1)
        } catch (error: Throwable) {
            emitter.onError(error)
        } finally {
            emitter.onComplete()
        }
    }
    //Flowable


    Single.error<Int>(RuntimeException("dasd"))
        .subscribe({ counter ->
            System.out.println("onSuccess: $counter")
        }, { error ->
            System.out.println("onError: $error")
        })
    //Maybe

    Completable.complete()
    Completable.timer(10L, SECONDS)
}