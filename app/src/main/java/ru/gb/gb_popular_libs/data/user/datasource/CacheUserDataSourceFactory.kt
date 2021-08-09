package ru.gb.gb_popular_libs.data.user.datasource

object CacheUserDataSourceFactory {

    fun create(): CacheUserDataSource = CacheUserDataSourceImpl()

}