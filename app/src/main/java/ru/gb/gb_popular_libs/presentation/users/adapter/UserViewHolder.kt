package ru.gb.gb_popular_libs.presentation.users.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.gb.gb_popular_libs.click
import ru.gb.gb_popular_libs.databinding.ViewUserBinding
import ru.gb.gb_popular_libs.presentation.GitHubUserViewModel
import ru.gb.gb_popular_libs.presentation.users.adapter.UsersAdapter.Delegate
import ru.gb.gb_popular_libs.setTextColorCompat
import ru.gb.gb_popular_libs.setUserAvatar

class UserViewHolder(view: View): ViewHolder(view) {

    private val viewBinding: ViewUserBinding by viewBinding()

    fun bind(userModel: GitHubUserViewModel, delegate: Delegate?) {
        with(viewBinding) {
            user.setUserAvatar(userModel.avatar)
            user.setTextColorCompat(userModel.nameColor)
            user.text = userModel.name

            root.click { delegate?.onUserPicked(userModel) }
        }
    }

}