package com.example.myapplication

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_addfood.*
import kotlinx.android.synthetic.main.activity_insert.*
import java.text.SimpleDateFormat
import java.util.*

class InsertActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)

        val cal = Calendar.getInstance()
        var dateString = ""
        datePicker.setOnClickListener {
            val dialog = DatePickerDialog(this, DatePickerDialog.OnDateSetListener{ view, year, month, dayOfMonth ->
                var monthc = ""
                if(month < 9){
                    monthc = "0"
                }
                var day = ""
                if(dayOfMonth < 10){
                    day = "0"
                }
                dateString = "" + year + monthc + (month + 1) + day + dayOfMonth
                datePicker.text = dateString
            },cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH))
            dialog.show()
        }

        btnNext.setOnClickListener {
            val id = intent.getStringExtra("id")
            val intent = Intent(this@InsertActivity, InsertAddActivity::class.java)
            intent.putExtra("date", dateString)
            intent.putExtra("name", proName.text.toString())
            intent.putExtra("id", id)
            startActivity(intent)
            finish()
        }
    }
}