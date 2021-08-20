package ru.gb.gb_popular_libs.presentation.user

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.gb.gb_popular_libs.PopularLibraries
import ru.gb.gb_popular_libs.R.layout.view_user
import ru.gb.gb_popular_libs.arguments
import ru.gb.gb_popular_libs.data.di.GitHubUserComponent
import ru.gb.gb_popular_libs.data.user.GitHubUserRepository
import ru.gb.gb_popular_libs.databinding.ViewUserBinding
import ru.gb.gb_popular_libs.presentation.GitHubUserViewModel
import ru.gb.gb_popular_libs.scheduler.Schedulers
import ru.gb.gb_popular_libs.setStartDrawableCircleImageFromUri
import javax.inject.Inject

class UserFragment: MvpAppCompatFragment(view_user), UserView {

    companion object Factory {

        private const val ARG_USER_LOGIN = "arg_user_login"

        fun newInstance(userId: String): Fragment =
            UserFragment()
                .arguments(ARG_USER_LOGIN to userId)

    }

    private val userLogin: String by lazy {
        arguments?.getString(ARG_USER_LOGIN).orEmpty()
    }

    @Inject
    lateinit var schedulers: Schedulers

    @Inject
    lateinit var gitHubUserRepository: GitHubUserRepository

    private var gitHubUserComponent: GitHubUserComponent? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        gitHubUserComponent =
            (requireActivity().application as? PopularLibraries)
                ?.gitHubApplicationComponent
                ?.gitHubUserComponent()
                ?.build()
                ?.also { it.inject(this) }
    }

    @Suppress("unused")
    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(
            userLogin = userLogin,
            userRepository = gitHubUserRepository,
            schedulers = schedulers
        )
    }

    private val viewBinding: ViewUserBinding by viewBinding()

    override fun showUser(user: GitHubUserViewModel) {
        viewBinding.userLogin.setStartDrawableCircleImageFromUri(user.avatar)
        viewBinding.userLogin.text = user.login
    }

    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), error.message, Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        gitHubUserComponent = null
    }

}