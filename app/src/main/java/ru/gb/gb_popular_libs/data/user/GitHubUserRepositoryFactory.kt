package ru.gb.gb_popular_libs.data.user

/**
 * Пока нет DI на основе Dagger2 мы решаем проблему
 * по старинке используя фабрики.
 */
object GitHubUserRepositoryFactory {

    fun create(): GitHubUserRepository = GitHubUserRepositoryImpl()

}