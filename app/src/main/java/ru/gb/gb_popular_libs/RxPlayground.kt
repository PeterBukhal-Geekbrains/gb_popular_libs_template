package ru.gb.gb_popular_libs

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit.MILLISECONDS
import kotlin.random.Random

const val article = """Реактивное программирование обеспечивает доступ к асинхронному программированию. Оно используется, чтобы упростить асинхронную обработку длительных операций. Именно это программирование — способ обработки нескольких событий, ошибок и завершения потока событий. Такой тип программирования обеспечивает также упрощённый способ запуска различных задач в разных потоках."""
val random = Random(System.currentTimeMillis())

fun main() {
    Observable
        .just(article)
        .map { text -> text.split(" ") }
        .concatMap { words -> Observable.fromIterable(words) }
        .map(String::lowercase)
        .flatMap(::clearAllNonLetterChars)
        .subscribeOn(Schedulers.computation())
        .subscribe(::onWord, ::onError)

    Thread.sleep(15000)
}

fun clearAllNonLetterChars(word: String): Observable<String> =
    Observable.fromIterable(word.asIterable())
        .filter(Char::isLetter)
        .observeOn(Schedulers.newThread())
        .reduce(StringBuilder(), { stringBuilder: StringBuilder, char: Char -> stringBuilder.append(char) })
        .map(StringBuilder::toString)
        .delay(random.nextLong(500), MILLISECONDS, Schedulers.io())
        .toObservable()

fun onWord(word: String) = println(word)
fun onError(error: Throwable) = print(error.localizedMessage)
