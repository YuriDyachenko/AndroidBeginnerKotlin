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
    }

    private fun outInfo(text: String, clear: Boolean = false) {
        val sb = StringBuilder()
        if (!clear) sb.append(binding.infoTextView.text.toString())
        sb.append(text).append("\n")
        binding.infoTextView.text = sb.toString()
    }

    override fun onClick(v: View?) {
        Counters.countButtonPressed++
        val clear = Counters.countButtonPressed == Constants.CONSOLE_CLEAR_LIMIT
        if (clear) Counters.countButtonPressed = 0
        outInfo("${Counters.countButtonPressed}: I was pressed softly", clear)
    }
}