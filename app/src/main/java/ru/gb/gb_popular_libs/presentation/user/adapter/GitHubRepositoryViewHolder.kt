package ru.gb.gb_popular_libs.presentation.user.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.gb.gb_popular_libs.data.repository.GitHubRepository
import ru.gb.gb_popular_libs.databinding.ViewUserRepositoryBinding

class GitHubRepositoryViewHolder(view: View): ViewHolder(view) {

    private val viewBinding: ViewUserRepositoryBinding by viewBinding()

    fun bind(model: GitHubRepository) {
        with(viewBinding) {
            userRepository.text = model.name
        }
    }

}