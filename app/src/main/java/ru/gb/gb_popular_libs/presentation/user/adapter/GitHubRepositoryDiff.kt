package ru.gb.gb_popular_libs.presentation.user.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import ru.gb.gb_popular_libs.data.repository.GitHubRepository

object GitHubRepositoryDiff : DiffUtil.ItemCallback<GitHubRepository>() {

    private val payload = Any()

    override fun areItemsTheSame(oldItem: GitHubRepository, newItem: GitHubRepository): Boolean {
        return oldItem.name == newItem.name
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: GitHubRepository, newItem: GitHubRepository): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: GitHubRepository, newItem: GitHubRepository) = payload

}

