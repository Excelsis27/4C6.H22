package ca.qc.cstj.s01premiereapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // findViewById équivalent document.getElementById()
        val btnMessage = findViewById<Button>(R.id.btnMessage)
        val btnAppel = findViewById<Button>(R.id.btnAppel)
        val btnSms = findViewById<Button>(R.id.btnSms)
        val edtName = findViewById<EditText>(R.id.edtName)
        val btnJeu = findViewById<Button>(R.id.secondActivity)


        btnMessage.setOnClickListener {
            Toast.makeText(this, "Allo", Toast.LENGTH_SHORT).show()
        }

        btnAppel.setOnClickListener {
            val phoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:555-555-5555"))
            startActivity(phoneIntent)
        }

        btnSms.setOnClickListener {
            val name = edtName.text.toString()
            val smsIntent = Intent(Intent.ACTION_VIEW, Uri.parse("smsto:450-327-6399"))
            smsIntent.putExtra("sms_body", "Bonjour $name")// ou "Bonjour edtName.text"
            startActivity(smsIntent)
        }

        btnJeu.setOnClickListener {
            val secondActivityIntent = SecondaryActivity.newIntent(this, edtName.text.toString())
            startActivity((secondActivityIntent))
        }
    }


}