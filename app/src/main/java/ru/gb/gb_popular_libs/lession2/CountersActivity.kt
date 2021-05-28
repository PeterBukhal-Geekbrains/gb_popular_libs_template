package ru.gb.gb_popular_libs.lession2

import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AlertDialog
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.gb.gb_popular_libs.R
import ru.gb.gb_popular_libs.R.layout.activity_counters
import ru.gb.gb_popular_libs.click
import ru.gb.gb_popular_libs.databinding.ActivityCountersBinding

class CountersActivity : MvpAppCompatActivity(activity_counters), CountersView {

    private var viewBinding: ActivityCountersBinding? = null

    private val presenter by moxyPresenter {
        CountersPresenter(model = CountersModel())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding =
            ActivityCountersBinding
                .inflate(layoutInflater)
                .also { viewBinding -> setContentView(viewBinding.root) }
                .apply {
                    counter1.click(presenter::incrementCounter1)
                    counter2.click(presenter::incrementCounter2)
                    counter3.click(presenter::incrementCounter3)
                }
    }

    override fun showOnBoarding() =
        AlertDialog
            .Builder(this)
            .setMessage(R.string.onboarding_message)
            .create()
            .show()

    override fun showCounter1(counter: String) {
        viewBinding?.counter1?.text = counter
    }

    override fun showCounter2(counter: String) {
        viewBinding?.counter2?.text = counter
    }

    override fun showCounter3(counter: String) {
        viewBinding?.counter3?.text = counter
    }

    override fun showCounterMessage() =
        Toast.makeText(this, R.string.counter_message, LENGTH_SHORT)
            .show()

}
