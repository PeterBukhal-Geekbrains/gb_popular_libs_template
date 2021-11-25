package ru.gb.gb_popular_libs.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.gb.gb_popular_libs.data.api.GitHubApi
import ru.gb.gb_popular_libs.data.api.GitHubApiErrorInterceptor
import ru.gb.gb_popular_libs.data.api.GitHubApiInterceptor
import ru.gb.gb_popular_libs.data.user.GitHubUser
import ru.gb.gb_popular_libs.data.user.GitHubUserTypeDeserializer

@Module
class NetworkModule {

    @Provides
    fun provideGson(): Gson =
        GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(GitHubUser.Type::class.java, GitHubUserTypeDeserializer())
            .create()

    @Reusable
    @Provides
    fun provideGitHubApi(gson: Gson): GitHubApi =
        Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(GitHubApiInterceptor)
                    .addInterceptor(GitHubApiErrorInterceptor)
                    .addNetworkInterceptor(
                        HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.BODY
                        }
                    )
                    .build()
            )
            .addCallAdapterFactory(RxJava3CallAdapterFactory.createSynchronous())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(GitHubApi::class.java)

}