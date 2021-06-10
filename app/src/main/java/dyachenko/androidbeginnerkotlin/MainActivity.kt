package dyachenko.androidbeginnerkotlin

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import dyachenko.androidbeginnerkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        binding.clickMeButton.setOnClickListener(this)

        binding.personButton.setOnClickListener {
            personTest()
        }

        binding.cycleButton.setOnClickListener(this)
    }

    private fun outInfo(text: String, clear: Boolean = false) {
        val sb = StringBuilder()
        if (!clear) sb.append(binding.infoTextView.text.toString())
        sb.append(text).append("\n")
        binding.infoTextView.text = sb.toString()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.click_me_button -> pressButton()
            R.id.cycle_button -> cycleTest()
        }
    }

    private fun personTest() {
        val sergey = Person("Sergey", 34)
        outInfo(sergey.toString())
        val nikita = sergey.copy(name = "Nikita")
        outInfo(nikita.toString())
    }

    private fun pressButton() {
        Counters.countButtonPressed++
        val clear = Counters.countButtonPressed == Constants.CONSOLE_CLEAR_LIMIT
        if (clear) Counters.countButtonPressed = 0
        outInfo("${Counters.countButtonPressed}: I was pressed softly", clear)
    }

    private fun cycleTest() {
        val fruits = arrayOf("apple", "mango", "orange", "lime", "cherry")

        outInfo("fruits.forEach")
        fruits.forEach {
            outInfo("  $it")
        }

        outInfo("for (i in 0 until fruits.size)")
        for (i in 0 until fruits.size) {
            outInfo("  $i - ${fruits[i]}")
        }

        outInfo("for (i in fruits.indices step 2)")
        for (i in fruits.indices step 2) {
            outInfo("  $i - ${fruits[i]}")
        }

        outInfo("for (i in 3..7)")
        for (i in 3..7) {
            outInfo("  $i")
        }

        outInfo("for (i in 10 downTo 6)")
        for (i in 10 downTo 6) {
            outInfo("  $i")
        }
    }
}