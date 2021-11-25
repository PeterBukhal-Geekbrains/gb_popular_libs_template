package ru.gb.gb_popular_libs.data.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import ru.gb.gb_popular_libs.data.repository.GitHubRepository

@Dao
interface GitHubRepositoryDao {

    @Query("SELECT * FROM github_repositories WHERE login LIKE :login")
    fun getRepositoriesByLogin(login: String): Observable<List<GitHubRepository>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun retain(users: List<GitHubRepository>): Completable

}