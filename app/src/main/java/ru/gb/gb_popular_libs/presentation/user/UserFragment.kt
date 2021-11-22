package ru.gb.gb_popular_libs.presentation.user

import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.gb.gb_popular_libs.R.layout.view_user
import ru.gb.gb_popular_libs.arguments
import ru.gb.gb_popular_libs.data.user.GitHubUserRepositoryFactory
import ru.gb.gb_popular_libs.databinding.ViewUserBinding
import ru.gb.gb_popular_libs.presentation.GitHubUserViewModel
import ru.gb.gb_popular_libs.setTextColorCompat
import ru.gb.gb_popular_libs.setUserAvatar

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

    override fun showUser(userModel: GitHubUserViewModel) {
        with(viewBinding) {
            user.setUserAvatar(userModel.avatar)
            user.setTextColorCompat(userModel.nameColor)
            user.text = userModel.name
        }
    }

    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), error.message, Toast.LENGTH_LONG).show()
    }

}