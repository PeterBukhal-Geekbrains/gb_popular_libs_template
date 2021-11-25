package ru.gb.gb_popular_libs.presentation.user.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.gb.gb_popular_libs.R.layout.view_user_repository
import ru.gb.gb_popular_libs.data.repository.GitHubRepository

class GitHubRepositoryAdapter: ListAdapter<GitHubRepository, GitHubRepositoryViewHolder>(GitHubRepositoryDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitHubRepositoryViewHolder =
        GitHubRepositoryViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(view_user_repository, parent, false)
        )

    override fun onBindViewHolder(holder: GitHubRepositoryViewHolder, position: Int) =
        holder.bind(getItem(position))

}