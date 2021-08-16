package ru.gb.gb_popular_libs.data.di.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.gb.gb_popular_libs.data.api.GitHubApi
import ru.gb.gb_popular_libs.data.api.GitHubApiInterceptor
import javax.inject.Named
import javax.inject.Singleton

@Module
class GitHubApiModule {

    @Named("github_api")
    @Provides
    fun provideBaseUrlProd(): String = "https://api.github.com"

    @Named("github_api_test")
    @Provides
    fun provideBaseUrlTest(): String = "https://api-test.github.com"

    @Singleton
    @Provides
    fun provideGitHubApi(@Named("github_api") baseUrl: String): GitHubApi =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(GitHubApiInterceptor)
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                    .build()
            )
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(GitHubApi::class.java)

    private val gson: Gson =
        GsonBuilder()
            .create()

}