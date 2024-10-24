package jp.ac.nkc_ai06.myallergy

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class SettingActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.setting_home)

        val button2: Button = findViewById<Button>(R.id.Back2Button)
        button2.setOnClickListener {
            finish()
        }
    }
}