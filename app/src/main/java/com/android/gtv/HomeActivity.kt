package com.android.gtv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import java.text.DateFormat
import java.util.Calendar

class HomeActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val calendar = Calendar.getInstance().time
        val dateFormat = DateFormat.getDateInstance(DateFormat.FULL).format(calendar)

        val dateTextView = findViewById<TextView>(R.id.xml_text_date)
        dateTextView.text = dateFormat

        //slide anim

        val move = findViewById<TextView>(R.id.dsn)
        move.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slight_out_left)
        }

    }
}