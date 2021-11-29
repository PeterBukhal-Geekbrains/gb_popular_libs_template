package ru.gb.gb_popular_libs.presentation.user

import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import moxy.ktx.moxyPresenter
import ru.gb.gb_popular_libs.R.layout.view_user_details
import ru.gb.gb_popular_libs.arguments
import ru.gb.gb_popular_libs.data.repository.GitHubRepository
import ru.gb.gb_popular_libs.data.user.GitHubUserRepository
import ru.gb.gb_popular_libs.databinding.ViewUserDetailsBinding
import ru.gb.gb_popular_libs.presentation.GitHubUserViewModel
import ru.gb.gb_popular_libs.presentation.abs.AbsFragment
import ru.gb.gb_popular_libs.presentation.user.adapter.GitHubRepositoryAdapter
import ru.gb.gb_popular_libs.setTextColorCompat
import ru.gb.gb_popular_libs.setUserAvatar
import javax.inject.Inject

class UserFragment: AbsFragment(view_user_details), UserView {

    companion object {

        private const val ARG_USER_LOGIN = "arg_user_login"

        fun newInstance(userId: String): Fragment =
            UserFragment()
                .arguments(ARG_USER_LOGIN to userId)

    }

    private val userLogin: String by lazy {
        arguments?.getString(ARG_USER_LOGIN).orEmpty()
    }

    @Inject
    lateinit var presenterFactory: UserPresenterAssistedFactory

    @Suppress("unused")
    private val presenter: UserPresenter by moxyPresenter {
        presenterFactory.create(userLogin)
    }

    private val viewBinding: ViewUserDetailsBinding by viewBinding()
    private val gitHubRepositoryAdapter = GitHubRepositoryAdapter()

    override fun showUser(user: GitHubUserViewModel) {
        with(viewBinding) {
            this.user.setUserAvatar(user.avatar)
            this.user.setTextColorCompat(user.nameColor)
            this.user.text = user.name
        }
    }

    override fun showRepositories(repositories: List<GitHubRepository>) {
        with(viewBinding) {
            userRepositories.adapter = gitHubRepositoryAdapter
        }

        gitHubRepositoryAdapter
            .submitList(repositories)
    }

    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), error.message, Toast.LENGTH_LONG).show()
    }

}