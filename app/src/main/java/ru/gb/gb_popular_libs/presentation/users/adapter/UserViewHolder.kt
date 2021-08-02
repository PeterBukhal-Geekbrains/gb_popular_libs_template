package ru.gb.gb_popular_libs.presentation.users.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.gb.gb_popular_libs.click
import ru.gb.gb_popular_libs.data.user.GitHubUser
import ru.gb.gb_popular_libs.databinding.ViewUserBinding
import ru.gb.gb_popular_libs.presentation.users.adapter.UsersAdapter.Delegate

class UserViewHolder(view: View): ViewHolder(view) {

    private val viewBinding: ViewUserBinding by viewBinding()

    fun bind(user: GitHubUser, delegate: Delegate?) {
        with(viewBinding) {
            userLogin.text = user.login

            root.click { delegate?.onUserPicked(user) }
        }
    }

}