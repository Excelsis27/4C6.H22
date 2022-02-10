package ca.qc.cstj.s01premiereapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import android.widget.Toast

class SecondaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)

        val txvWelcome = findViewById<TextView>(R.id.txvWelcome)
        val nprNumber = findViewById<NumberPicker>(R.id.nprNumber)
        val btnVerify = findViewById<Button>(R.id.btnVerify)

        txvWelcome.text = getString(R.string.msgDeviner, intent.getStringExtra(INTENT_EXTRA_NAME))

        nprNumber.minValue = 0
        nprNumber.maxValue = 100

        val theNumber = (0 .. 100).random()

        btnVerify.setOnClickListener {
            when {
                nprNumber.value == theNumber -> {
                    Toast.makeText(this, getString(R.string.msgWinner), Toast.LENGTH_SHORT).show()
                }
                nprNumber.value > theNumber -> {
                    Toast.makeText(this, getString(R.string.msgLow), Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(this, getString(R.string.msgHigh), Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    // Companion statique de ma classe/partie statique
    companion object {
        const val INTENT_EXTRA_NAME = "EXTRA_NAME"
        fun newIntent(context: Context, name:String) : Intent {
            val intent = Intent(context, SecondaryActivity::class.java)
            intent.putExtra(INTENT_EXTRA_NAME, name)
            return intent
        }
    }
}