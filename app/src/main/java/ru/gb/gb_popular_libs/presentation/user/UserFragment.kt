package ru.gb.gb_popular_libs.presentation.user

import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.gb.gb_popular_libs.R.layout.view_user
import ru.gb.gb_popular_libs.arguments
import ru.gb.gb_popular_libs.data.user.GitHubUser
import ru.gb.gb_popular_libs.data.user.GitHubUserRepositoryFactory
import ru.gb.gb_popular_libs.databinding.ViewUserBinding

class UserFragment: MvpAppCompatFragment(view_user), UserView {

    companion object {

        private const val ARG_USER_LOGIN = "arg_user_login"

        fun newInstance(userId: String): Fragment =
            UserFragment()
                .arguments(ARG_USER_LOGIN to userId)

    }

    private val userLogin: String by lazy {
        arguments?.getString(ARG_USER_LOGIN).orEmpty()
    }

    @Suppress("unused")
    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(
            userLogin = userLogin,
            userRepository = GitHubUserRepositoryFactory.create()
        )
    }

    private val viewBinding: ViewUserBinding by viewBinding()

    override fun showUser(user: GitHubUser) {
        viewBinding.userLogin.text = user.login
    }

}