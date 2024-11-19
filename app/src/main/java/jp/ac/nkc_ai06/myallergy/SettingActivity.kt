package jp.ac.nkc_ai06.myallergy

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class SettingActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.setting_home)

        val btAccount = findViewById<Button>(R.id.Account)
        val btTextsize = findViewById<Button>(R.id.TextSize)
        val btBack = findViewById<Button>(R.id.Back2Button)

        btAccount.setOnClickListener {

        }

        btBack.setOnClickListener {
            finish()
        }

    }
}