package ru.gb.gb_popular_libs.presentation.users

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.gb.gb_popular_libs.PopularLibraries.Navigation.router
import ru.gb.gb_popular_libs.R.layout.view_users
import ru.gb.gb_popular_libs.arguments
import ru.gb.gb_popular_libs.data.user.GitHubUser
import ru.gb.gb_popular_libs.data.user.GitHubUserRepositoryFactory
import ru.gb.gb_popular_libs.databinding.ViewUsersBinding
import ru.gb.gb_popular_libs.presentation.users.adapter.UsersAdapter

class UsersFragment: MvpAppCompatFragment(view_users), UsersView, UsersAdapter.Delegate {

    companion object {

        fun newInstance(): Fragment =
            UsersFragment()
                .arguments()

    }

    private val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(
            userRepository = GitHubUserRepositoryFactory.create(),
            router = router
        )
    }

    private val viewBinding: ViewUsersBinding by viewBinding()
    private val usersAdapter = UsersAdapter(delegate = this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.users.adapter = usersAdapter
    }

    override fun showUsers(users: List<GitHubUser>) {
        usersAdapter.submitList(users)
    }

    override fun onUserPicked(user: GitHubUser) =
        presenter.displayUser(user)

}